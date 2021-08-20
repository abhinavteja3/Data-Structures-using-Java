//Program to check balancing of symbols
/*Scan the expression string input.
    a) If the current symbol is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    b) If the current symbol is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped symbol is the left counter part of closing symbol then proceed to next symbol else parenthesis are not balanced.
3) After complete traversal, if there is/are some open symbol(s) left in stack then "not balanced"*/
import java.util.*;
class Balance
{
static char stack[]=new char[20];
static Scanner sc=new Scanner(System.in);
static int top=-1;
static void push(char t)
{
	top++;
	stack[top]=t;
}
static void pop()
{
	top--;
}


public static void main(String args[])
{
	String input;
	int i=0,flag=1;
	System.out.println("Enter the string :");
	input=sc.nextLine();
	for(i=0;i<input.length();i++)
	{
		
		
		if(input.charAt(i)=='{'||input.charAt(i)=='('||input.charAt(i)=='[')
		{
			push(input.charAt(i));
		}
		else if((input.charAt(i)=='}'||input.charAt(i)==']'||input.charAt(i)==')')&&top==-1)
		{
			flag=0;
			break;
		}
		else if(((input.charAt(i)=='}'&&stack[top]=='{')||(input.charAt(i)==']'&&stack[top]=='[')||(input.charAt(i)==')'&&stack[top]=='('))&&top!=-1)
		{
			pop();
		}
		else if(input.charAt(i)!=' ')
		{
			flag=0;
			break;
		}
		else
		{
			continue;
		}
		
	}
	if(flag==1&&top==-1)
		System.out.println("Valid");
	else
		System.out.println("Invalid");
}
}