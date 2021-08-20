import java.util.*;
class Insertionsort
{
	public static void main(String args[])
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the size of the array");
	int n=sc.nextInt();
	int a[]=new int[n];
	int k,j;
	int s=a.length;
	for(int i=0;i<s;i++)
	{
		a[i]=sc.nextInt();
	}
	for(int i=1;i<s;i++)
	{
		k=a[i];
		j=i-1;
		while(j>=0 & a[j]>k)
		{
			a[j+1]=a[j];
			j=j-1;
			if(j==-1)
			{
				break;
			}
		}
		a[j+1]=k;
	}
	for(int i=0;i<s;i++)
	{
		System.out.println(a[i]);
	}

   }
}