package stack;

public class SortedStack {
	int max = 5;
	int[] stack = new int[5];
	int top = -1;
	int n =0;
	public void push(int val)
	{
		if(top == -1)
		{
			top++;
			stack[top] = val;
			n++;
			System.out.println("Entering 1st " + val + " at " + top);
		}
		else if(top> max || n>=max)
		{
			System.out.println("Stack Overflow");
		}
		else if (n<max)
		{	int i;
			System.out.println("n: " + n );
			for(i=0; i<n; i++)
			{
				if(stack[i] > val)
				{
					break;
				}
			}
			for(int j=n-1; j>=i; j--)
			{
				stack[j+1] = stack[j];
			}
			stack[i] = val;
			top++;
			n++;
			System.out.println("Entering " + val + " at " + i);
			System.out.println("Top value is; " + top);
			
		}
	}
	
		
	public void pop()
	{	
		//System.out.println(stack[]);
		if(top == -1 && n == 0)
		{
			System.out.println("Stack Underflow");
		}
		else
		{
			System.out.println("Popping " + stack[top] + " from top: " + top);
			top--;
			n--;
		}
	}
	
	public static void main(String[] args)
	{
		SortedStack s= new SortedStack();
		s.push(2);
		s.push(1);
		s.push(5);
		s.push(8);
		s.push(3);
		s.push(4);
//		s.push(13);
//		s.push(40);		
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		System.out.println("-----------------");
		
	}
}
