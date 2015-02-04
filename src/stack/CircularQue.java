package stack;

public class CircularQue {
	int[] myQue;
	int max = 5;
	int front = -1;
	int rear = -1;
	public void push(int val)
	{
		if(front == -1 || rear == -1)
		{
			myQue = new int[max];
			front++;
			myQue[front] = val;
			rear = front;
		}
		
		else if(front >= max-1)
		{
			System.out.println("front: " + front + "rear: " + rear);
			if(front+1 < rear)
			{
				front++;
				myQue[front] = val;
			}
			else if(rear > 0)
			{
				front = 0;
				myQue[front] = val;
			}
			else
			{	System.out.println("Hii");
				System.out.println("Stack Overflow");
			}
		}
		
		else
		{
			front++;
			myQue[front] = val;
		}
	}
	public void pop()
	{
		if(rear == -1 || front == -1)
		{
			System.out.println("Stack Underflow");
		}
		else if(rear <= max-1)
		{
			System.out.println("Popping " + myQue[rear]);
			rear++;
		}
		else if(rear > max-1)
		{
			System.out.println("restarting rear");
			rear = 0;
		}
	}
	
	public static void main(String[] args)
	{
		CircularQue q = new CircularQue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		//q.push(6);
		q.pop();
		q.pop();
		q.pop();
//		q.pop();
//		q.pop();
//		q.pop();
//		q.pop();
		q.push(6);
		q.pop();
		q.pop();
		q.pop();
		q.pop();
				
		
	}
}
