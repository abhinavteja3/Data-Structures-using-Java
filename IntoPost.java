//Conversion of Infix to postfix
/* If the current symbol is an operand, add it to postfix string
   If the current symbol is an operator then
     i) if the stack is empty or s[top] is '(' then push current symbol onto the stack
	 ii) if the current symbol is ')' then pop all the operators from stack until s[top] 
	     is '(' add these operators to postfix string
	 iii) else pop the operator (and add it to postfix) from the stack until the precedence of the
    	 scanned operator is less-equal to the precedence of the operator residing on the top of 
		 the stack. Push the scanned operator to the stack.*/
//Assumption 1: No spaces in Infix string
import java.util.*;
class IntoPost
{
static char stack[]=new char[20];
static int top=-1;
static Scanner sc=new Scanner(System.in);
static void push(char ch)
{
	top++;
	stack[top]=ch;
}
static char pop()
{
	char ch=stack[top];
	top--;
	return ch;
}
static int op(char ch) //returns precedence of operator
{
	switch(ch)
	{
		case '+':
		case '-': return 1;
		case '/':
		case '*': 
		case '%': return 2;
	}
	return 0;
}
static boolean isalpha(char ch)
{
	if((ch>=65&&ch<=90)||(ch>=97&&ch<=122))
		return true;
	else
		return false;
}
public static void main(String args[])
{
	String post="",infix;
	System.out.println("enter a infix string");
	infix=sc.nextLine();
	int i=0;
	while(i<infix.length())
	{
		if(isalpha(infix.charAt(i)))//operand add to postfix
			post+=infix.charAt(i);
		else if(infix.charAt(i)=='(')
			push(infix.charAt(i));
		else if(infix.charAt(i)==')')
		{
			while(stack[top]!='(')
			{
				post+=pop();
			}
			pop();//to remove '('
		}
		else 
		{
			if(top==-1||stack[top]=='(')// see point#ii
				push(infix.charAt(i));
			else 
			{
				while(op(infix.charAt(i))<=op(stack[top])&&stack[top]!='(')
				{
					post+=pop();
					if(top==-1)
					break;
				}
				push(infix.charAt(i));
			}
		}
				
		i++;
	}//end of while
	//add the remainder of stack elemnets to post
	while(top!=-1)
		post+=pop();
	//make post as a string by appending '\0'
	System.out.println("The equivalent postfix expression of infix expression is: "+post);
}
}	
			
		
		
