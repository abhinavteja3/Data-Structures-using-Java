//Linear Queue
import java.util.*;
class LQueue{
static int A[],n,front=-1,rear=-1,top==-1;
static Scanner sc=new Scanner(System.in);
static void enqueue()
{
	if(rear==n-1||rear+1==top)
		System.out.println("Queue is full");
	else
	{
		if(front==-1)
			front=0;
		rear++;
		System.out.println("enter an element to enqueue");
		Q[rear]=sc.nextInt();
	}
}
  static void dequeue()
	{
		if(front==-1)
			System.out.println("Queue is empty");
		else
		{
			System.out.println(Q[front]+" is dequeued");
			if(front==rear)
				front=rear=-1;
			else
			{
				for(int i=front;i<rear;i++)
					Q[i]=Q[i+1];
				rear--;
			}
		}
	}
	
static void display()
	{
		if(front==-1)
			System.out.println("Queue is empty");
		else
		{
			for(int i=front;i<=rear;i++)
				System.out.print(Q[i]+"   ");
			System.out.println();
		}
	}
public static void main(String args[])
	{
		System.out.println("Enter Max size of Queue");
		n=sc.nextInt();
		Q=new int[n];
		int ch;
		while(true)
		{
		System.out.println("Enter choice \n 1.Enqueue \n 2. Dequeue\n 3. Display \n 4. Exit ");
		ch=sc.nextInt();
		switch(ch)
		{
			case 1: enqueue();
					break;
			case 2: dequeue();
					break;
			case 3: display();
					break;
			case 4:System.exit(0);
					break;
			default: System.out.println("Invalid choice");
					break;
		}
	}
}
}