//Evaluation of Postfix expression
/* Scan input from left to right
  if current symbol is operand then push on to stack
  if current symbol is operator then pop top most two elements from stack and perform operation on these two operators*/
  
//Assumption 1: Input postfix expression is always valid
//Assumption 2: Operands and operators are separated with spaces
//Note 1:Result will be on top of stack   
//Sample Input :12 14 15 * + 16 + 17 -
//Sample Output:221
import java.util.*;
class Postfix_eva
{
static int stack[]=new int[20], top=-1;
static Scanner sc=new Scanner(System.in);
static void push(int ch)
{
	top++;
	stack[top]=ch;
}
static int pop()
{
	int t=stack[top];
	top--;
	return t;
}
public static void main(String args[])
{
	String post;
	System.out.println("enter a postfix string : ");
	post=sc.nextLine();
	int i=0;
	boolean flag=true;
	while(i<post.length())//scan input from left to right 
	{
		
		if(post.charAt(i)>=48&&post.charAt(i)<=57)//if the current symbol is digit then convert it into equivalent integer
		{   int t=0;
			while(post.charAt(i)!=' ')
			{
				t=(t*10)+(post.charAt(i)-48);
				i++;
			}
			push(t);
		}
		else //operator
		{
			if(post.charAt(i)!=' ')//checking if it is a space or not, because if it is a space no use pooping operands
			{
				if(top<=0) // validating input. if stack is empty or has only one element then we can't perform airthmetic operation (we need atleast two operands).
				{
						flag=false;
						break;
				}
				int a=pop(),b=pop();
			switch(post.charAt(i))
			{
				case '+':push(b+a);break;
				case '-':push(b-a);break;
				case '*':push(b*a);break;
				case '/':push(b/a);break;
				case '%':push(b%a);break;
			}	
			}
		}
		i++;
	}//end of while
		
	if(flag)
	System.out.println("Result: "+pop());	
	else
	System.out.println("Invalid postfix expression");	
}	
}
