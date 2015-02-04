package stack;

import java.util.Scanner;

public class QUsing2Stacks {
	
	int[] stack1;
	int[] stack2;
	int size = 9;
	int top = -1;
	int n = 0;
	int max1, max2;
	
	public void create()
	{
		System.out.println("hii");
		if(size%2 == 0)
		{
			max1 = (size/2);
			max2 = max1;
		}
		else
		{
			max1 = (size/2);
			max2 = max1 + 1;
		}
		//System.out.println("max1: " + max1 + " max2: " + max2);
		stack1 = new int[max1];
		stack2 = new int[max2];
	}
	
	public void push(int val)
	{
		if(top == -1)
		{
			System.out.println("Entering 1st " + val + " in stack1");
			top = 0;
			stack1[top] = val;
			n++;
		}
		else if(top >= max1 && n <= size)
		{
			System.out.println("Enetering 1st " + val + " in stack2 ");
			top = 0;
			stack2[top] = val;
			n++;
		}
		else if(n <= size) 
		{	
			top++;
			if(n >= max1)
			{
				System.out.println("Entering " + val + " in stack2");
				stack2[top] = val;
				n++;
			}
			else
			{
				System.out.println("Entering " + val + " in stack1");
				stack1[top] = val;
				n++;
			}
		}
	}
	
	public void pop()
	{
		if(top == -1 && n==0)
		{
			System.out.println("Stack Underflow");
		}
		else
		{	
			System.out.println("Popping " + stack1[0]);
			if(n >= max1)
			{
				for(int i=1; i<max1; i++)
				{
					stack1[i-1] = stack1[i];
				}
				stack1[max1-1] = stack2[0];
				for(int i=1; i<n-max1; i++)
				{
					stack2[i-1] = stack2[i]; 
				}
				if(top == 0)
				{
					top = max1-1;
				}
				else{
					top--;
				}
			}
			else{
				for(int i=1; i<n; i++)
				{
					stack1[i-1] = stack1[i];
				}
				top--;
			}
			n--;
		}
	}
	
	public static void main(String[] args)
	{
		QUsing2Stacks myQue = new QUsing2Stacks();
		myQue.create();
//		myQue.push(0);
//		myQue.push(1);
		myQue.push(2);
//		myQue.push(3);
//		myQue.push(4);
//		myQue.push(5);
		myQue.push(6);
		myQue.pop();
		myQue.pop();
		myQue.pop();
	}
	
}
