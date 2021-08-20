//Double Ended Queue (DEQue)
import java.util.*;
class Deque{
static int Q[],n,front=-1,rear=-1;
static Scanner sc=new Scanner(System.in);
static void EnqueFront()
{
	if(front==(rear+1)%n)
		System.out.println("Queue is full");
	else
	{
		if(front==-1)
			rear=front=0;
		else if (front==0)
			front=n-1;
		else 
			front--;
		System.out.println("enter an element to enqueue at front");
		Q[front]=sc.nextInt();
	}
}
static void EnqueRear()
{
	if(front==(rear+1)%n)
		System.out.println("Queue is full");
	else
	{
		if(front==-1)
			front=0;
		rear=(rear+1)%n;
		System.out.println("enter an element to enqueue at rear");
		Q[rear]=sc.nextInt();
	}
}
  static void DequeFront()
	{
		if(front==-1)
			System.out.println("Queue is empty");
		else
		{
			System.out.println(Q[front]+" is dequeued");
			if(front==rear)
				front=rear=-1;
			else
				front=(front+1)%n;
		}
	}
  static void DequeRear()
	{
		if(front==-1)
			System.out.println("Queue is empty");
		else
		{
			System.out.println(Q[rear]+" is dequeued");
			if(front==rear)
				front=rear=-1;
			else if(rear==0)
				rear=n-1;
			else
				rear--;
		}
	}
			
static void display()
	{
		if(front==-1)
			System.out.println("Queue is empty");
		else
		{
			for(int i=front;;i=(i+1)%n)
			{
				System.out.print(Q[i]+"   ");
				if(i==rear)
					break;
			}
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
		System.out.println("Enter choice \n 1.EnqueFront \n 2. EnqueRear\n 3. DequeFront\n 4. DequeRear\n 5. Display \n 6. Exit ");
		ch=sc.nextInt();
		switch(ch)
		{
			case 1: EnqueFront();
					break;
			case 2: EnqueRear();
					break;
			case 3: DequeFront();
					break;
			case 4: DequeRear();
					break;
			case 5: display();
					break;
			case 6:System.exit(0);
					break;
			default: System.out.println("Invalid choice");
					break;
		}
	}
}
}