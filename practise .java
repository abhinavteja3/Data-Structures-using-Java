import java.util.*;
public class Queue
{
private int front,rear,size,length;
private int queue[];
Queue(int n)
{  
   size=n;
   front = -1;
   rear = -1;
   queue =new int[size];
}
public static void main(String args[])
{
   Queue stack=new Queue(n);
   System.out.println("Enter the size of the stack");
   Scanner sc=new Scanner(System.in);
   int n=sc.nextInt();
   int ch;
   do{
       System.out.println("1.push/n 2.pop/n 3.length/n 4.display/n 5.exit");
       ch=sc.nextInt();
       switch(ch)
       {
        case 1 :
            {
                stack.push();
                Scanner sca=new Scanner(System.in);
                x=sc.nextInt();
            }
         break;
            case 2 :
                {
                    stack.pop();
                }
            break;
                case 3 :
                    {
                        stack.length();
                    }
                    break;
                    case 4 :
                        {
                            stack.display();
                        }
                        break;
                        case 5 :
                            {
                                System.out.println("u have been exited");
                            }
                            break;
       }
   }while(ch==5);
}
   public boolean isEmpty()
   {
       return(front==-1);
   }
   public boolean isFull()
   {
       return(rear==size+1);
   }
   public void push()
   {
   if(isEmpty())
   {
       rear++;
       front=0;
       queue[rear]=x;
       length++;
       
   }
   else
   {
       System.out.println("Over flow");
   }
   }
   public void pop()
   {
   if(isEmpty())
   {
       System.out.println("under flow");
   }
   else
   {
       front++;
       System.out.println(queue[front]);
       length--;
   }
   }
   public void length()
   {
       System.out.println(length);
   }
   public void display()
   {
       for(int i=0;i<length;i++)
       {
           System.out.println(queue[i]);
       }
   }
   }