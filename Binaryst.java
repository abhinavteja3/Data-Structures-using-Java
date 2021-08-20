import java.util.*;
class Binaryst
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int c;
        Binaryst t=new Binaryst();	
		do{
			System.out.println("1.To insert the element");
			System.out.println("2.To print the inorder of the binary tree");
			System.out.println("3.To print the height of the tree");
			c=sc.nextInt();
			if(c==1)
			{
				System.out.println("Enter the key value which u wanted to enter");
				int v=sc.nextInt();
				t.insert(t.root ,v);
			}
			else if(c==2)
			{
				t.print(t.root);
			}
			else if (c==3)
			{
				//t.height();
			}
		}while(c==1 || c==2 || c==3);
	}
	public void insert(Node n,int v)
	{
		Node a=new Node(v);
		if(n==null)
		{
			root=a;
		}
		else if(v<n.v)
		{
		if(n.left==null)
		{
		n.left=a;
	    }
	    else
	    {
	    	insert(n.left , v);
	    }
		}
		else if(v>n.v)
		{
			if(n.right==null)
			{
				n.right=a;
			}
			else
			{
				insert(n.right , v);
			}
		}
	}
	public void print(Node n)
	{
     if(n==null)
     {
     	return ;
     }
     print(n.left);
     System.out.println(n.v);
     print(n.right);
	}
	Node root;
	class Node{
		
		int v ;
		Node left , right;
		Node(int c)
		{
			v=c;
			left=right=null;
		}
	}	
}