import java.util.*;
class Dll
{
	Node head=null;
	Node tail=null;
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
	    int c;
	    Dll obj=new Dll();
	    do{
          System.out.println("1.Insert at starting");
          System.out.println("2.Insert after");
          System.out.println("3.Insert at ending");
          System.out.println("4.Deletion");
          System.out.println("5.print all the elements");
          System.out.println("Press any number other than 1 to 5 to exit from the loop");
          c=sc.nextInt();
         if(c==1)
         {
           System.out.println("Enter data");
           obj.InsertS(sc.nextInt());
         }
         else if(c==2)
         {
         	System.out.println("Enter Index , Enter Data");
         	obj.InsertA(sc.nextInt() , sc.nextInt());
         }
         else if(c==3)
         {
         	obj.InsertE(sc.nextInt());
         }
         else if(c==4)
         {
         	System.out.println("Enter Index");
         	obj.Deletion(sc.nextInt());
         }
         else 
         {
         	obj.Print();
         }
	    }while(c>=1 && c<=5);

	}
	class Node
	{
		int data;
		Node next;
		Node prev;	
		Node(int d)
		{
			data = d;
		}	
	}
	public void InsertS(int new_data)
	{
		Node node=new Node(new_data);
		if(head==null)
		{
			head=tail=node;
		}
		else 
		{
		node.next=head;
	    head.prev=node;
	    head=node;
	    head.prev=null;
	    }
	} 
	public void InsertA(int index , int new_data)
	{
		Node node=new Node(new_data);

		if(head==null)
		{
			node.next=head;
	    head.prev=node;
	    node=head;
	    head.prev=null;
		}
		Node n=head;
		
		
			for(int i=0 ; i<index-1 ; i++)
			{
				n=n.next;
			}
			node.next=n.next;
			node.prev=n;
			n.next=node;
			n=node.next;
			n.prev=node;
		
	}
	public void InsertE(int new_data)
	{
		Node node=new Node(new_data);
		if(head==null)
		{
			head=tail=node;
			head.prev=null;
		}
		else
		{
			tail.next=node;
			node.prev=tail;
			tail=node;
			tail.next=null;

		}
	}
	public void Deletion(int index)
	{
      if(head==null)
      {
      	System.out.println("Nothing to Delete");
      }
      else
      {
      	Node n=head;
      
       for(int i=0;i<index-1;i++)
       {
 		n=n.next;
       } 
       Node n1=n.next;
       n.next=n1.next;
       n=n.next;
       n.prev=n1.prev;
       n1.next=n1.prev=null;

      }
	}
	public void Print()
	{
		Node n=head;
		if(n==null)
		{
			System.out.println("Nothing to print");	
		}
		else
		{
			while(n!=null)
			{
					System.out.print(n.data+" ");
					n=n.next;
			}
		}
	}
}