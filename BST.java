import java.util.*;
import java.util.Queue;
/**
 *
 * @author 19bcd7073
 */
class Node
{
int data;
Node left = null, right = null;

Node(int data) {
this.data = data;
}
}

class BST
{

public static void inorder(Node root)
{
if (root == null)
return;

inorder(root.left);
System.out.print(root.data + " ");
inorder(root.right);
}

// Helper function to find minimum value node in subtree rooted at curr
public static Node minimumKey(Node curr)
{
while(curr.left != null) {
curr = curr.left;
}
return curr;
}

// Recursive function to insert a key into BST
public static Node insert(Node root, int key)
{
// if the root is null, create a new node and return it
if (root == null) {
return new Node(key);
}

// if given key is less than the root node, recur for left subtree
if (key < root.data) {
root.left = insert(root.left, key);
}

// if given key is more than the root node, recur for right subtree
else {
root.right = insert(root.right, key);
}

return root;
}


public static Node deleteNode(Node root, int key)
{

Node parent = null;


Node curr = root;


while (curr != null && curr.data != key)
{

parent = curr;


if (key < curr.data) {
curr = curr.left;
}
else {
curr = curr.right;
}
}


if (curr == null) {
return root;
}


if (curr.left == null && curr.right == null)
{

if (curr != root) {
if (parent.left == curr) {
parent.left = null;
} else {
parent.right = null;
}
}

else {
root = null;
}
}


else if (curr.left != null && curr.right != null)
{

Node successor  = minimumKey(curr.right);


int val = successor.data;


deleteNode(root, successor.data);


curr.data = val;
}


else
{

Node child = (curr.left != null)? curr.left: curr.right;


if (curr != root)
{
if (curr == parent.left) {
parent.left = child;
} else {
parent.right = child;
}
}


else {
root = child;
}
}

return root;
}

public static void main(String[] args)
{
Node root = null;
int[] keys = { 80,100,20,90,12,69,48,85,105,36,58,78,40,32,9,18};

for (int key : keys) {
root = insert(root, key);
}
for(int i=45;i<=90;i++)
{
      root = deleteNode(root, i);
}
inorder(root);
System.out.println();
displaySumOfBinaryTreeNodesAtEachLevel(root);
}
public static  void displaySumOfBinaryTreeNodesAtEachLevel(Node root) {
 Queue<Node> queue = new ArrayDeque<>();
 int sum = 0;
 int level = 1;
 Node dummy = new Node(Integer.MIN_VALUE);
 if (root != null) {
  queue.add(root);
  queue.add(dummy);
  while (!queue.isEmpty()) {
   /* Dequeue form queue and update sum or display it */
   root = queue.remove();
   /* Dequeued node is marker node and */
   if (root.equals(dummy)) {
    System.out.println("Sum at level " + level + " is " + sum);
    sum = 0;
    level++;
    /* Add marker node only when queue has some element */
    if (queue.size() != 0)
     queue.add(dummy);
   }
   /* all nodes of that level is not traversed */
   else {
    sum += root.data;
    Node lc = root.left;
    Node rc = root.right;
    if (lc != null) {
     queue.add(lc);
    }
    if (rc != null) {
     queue.add(rc);
    }
   }
  }
 }
}
}