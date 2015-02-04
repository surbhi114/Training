package stack;
import java.util.*;
public class BracketChecker {
	
	char[] mystack;
	int top = -1;
	
	public void push(String str)
	{
		mystack = new char[str.length()];
		int i;
		for(i=0; i<str.length(); i++)
		{	
			if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{')
			{	
				if(top == -1)
				{
					top++;
					mystack[top] = str.charAt(i);
					System.out.println("Pushing " + mystack[top] + " at " + top);
				}
				else
				{
					top++;
					mystack[top] = str.charAt(i);
					System.out.println("Pushing " + mystack[top] + " at " + top);
					
				}
			}
			else if(str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}')
			{	
				System.out.println("Checking " + str.charAt(i));
				switch(str.charAt(i))
					{
					case ')':
						if(mystack[top] == '(')
						{
							pop();
						}
						break;
					case '}':
						if(mystack[top] == '{')
						{
							pop();
						}
						break;
					case ']':
						if(mystack[top] == '[')
						{
							pop();
						}
						break;
						
					}
				}
			
		}
		System.out.println("i: " + i + "top: " + top + "Str.len: " + str.length() );
		if(i == str.length() && top == -1)
		{
			System.out.println("Proper String");
		}
		else
		{
			System.out.println("String improper");
		}
			
		
	}
	public void pop()
	{
		if(top == -1)
		{
			System.out.println("Stack UnderFlow");
		}
		else
		{
			System.out.println("Popping " + mystack[top]);
			top--;
		}
	}
	public static void main(String[] args)
	{
		String str = "{a[b(c)d}]";
		BracketChecker checker = new BracketChecker();
		checker.push(str);
		
	}
}
