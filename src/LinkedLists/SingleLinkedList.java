package LinkedLists;

import java.util.Hashtable;

public class SingleLinkedList {

	protected Node start;
	protected Node end;//we keep a track of end so that we can avoid O(n) complexity when we have to place myNode at the end.
	public int size;//we keep a track of size so that we can avoid O(n) complexity when we have to place myNode at the end or delete.
	
	public SingleLinkedList()
	{
		start = null;
		end = null;
		size = 0;
	}
	
	
	public boolean isEmpty()
	{
		return start == null;
	}
	
	public void insertAtStart(int val)
	{
		Node myNode = new Node(val, null);
		size++;
		if(isEmpty())
		{
			start = myNode;
			start.setLink(null);
			end = start;
			end.setLink(null);
		}
		else
		{
			myNode.setLink(start);
			start = myNode;
		}
	}
	
	public void insertAtEnd(int val)
	{
		Node myNode = new Node(val, null);
		size++;
		if(isEmpty())
		{
			start = myNode;
			end = start;
			start.setLink(null);
		}
		else
		{
			end.setLink(myNode);
			myNode.setLink(null);
			end = myNode;
		}
	}
	
	public int getSize()
	{
		int count = 0;
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			Node temp = start;
			while(temp!=null)
			{
				count++;
				temp = temp.getLink();
			}
			return count;
		}
		
	}
	
	public void insertAtPosition(int val, int pos)
	{
		Node myNode = new Node(val, null);
		size++;
		if(isEmpty())
		{
			start = myNode;
			end = start;
			end.setLink(null);
		}
		else
		{
			int i = 1;
			Node temp = start;
			while(i <= getSize())
			{
				if(i == pos-1)
				{
					myNode.setLink(temp.getLink());
					temp.setLink(myNode);
					break;
				}
				temp = temp.getLink();
				i++;
			}
			
		}
	}
	
	public void deleteAtPos(int pos)
	{
		if(isEmpty())
		{
			System.out.println("Sorry No elements to be deleted");
			return;
		}
		else
		{
			size--;
			int i = 1;
			Node temp = start;
			
			if(pos == 1)
			{
				//deleting the start node
				start = start.getLink();
				return;
			}
			
			else if(pos == getSize())
			{
				while(temp.getLink() != end)
				{
					temp = temp.getLink();
				}
				temp.setLink(null);
				end = temp;				
				
			}
			
			else // Delete any node other than the first and the last nodes.
			{
				while(i < getSize())
				{
					if(i == pos-1)
					{
						Node del = temp.getLink();
						temp.setLink(del.getLink());
						break;
					}
					temp = temp.getLink();
					i++;
				}
			}
		}
	}
	
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Sorry no list to be displayed");
		}
		else
		{
			Node temp = start;
			while(temp.getLink()!=null)
			{
				System.out.print(temp.getData() + " -> ");
				temp = temp.getLink();
			}
			System.out.println(temp.getData());
			
		}
	}

	public void deleteEntireList()
	{
		
		start = null;//grbage collector eats away the island of memory
		
	}
	
	public Node getPrev(Node n)
	{
		Node retNode = null;
		Node temp = start;
		Node temp2 = temp.getLink();
		if(temp == n)
		{
			retNode = null;
		}
		
		while(temp2!=null)
		{
			if(temp2 == n)
			{
				retNode = temp;
				break;
			}
			temp = temp.getLink();
			temp2 =temp2.getLink();
			
		}
		return retNode;
	}
	 
	public void removeDups()
	{
		if(isEmpty())
		{
			System.out.println("Sorry no list to be displayed");
		}
		else
		{
			Hashtable<Integer, Boolean> myTab = new Hashtable<Integer, Boolean>(); 
			Node temp = start;
			while(temp != null)
			{
				if(!myTab.containsKey(temp.getData()))
				{
					myTab.put(temp.getData(), true);
				}
				else
				{
					if(temp.getLink()==null)
					{
						getPrev(temp).setLink(null); 
					}
					else
					{
						getPrev(temp).setLink(temp.getLink());
					}
				}
				temp = temp.getLink();
			}
		}
		
	}
	
	public void removeDupWOHash()
	{
		Node temp = start;
		Node runner = temp.getLink();
		while(temp!=null)
		{
			runner = temp.getLink();
			while(runner!=null)
			{	
				if(temp.getData() == runner.getData())
				{
					getPrev(runner).setLink(runner.getLink());
				}
				runner = runner.getLink();
			}
			temp = temp.getLink();
		}
	}
	
	public void reverseLL()
	{
		if(isEmpty())
		{
			System.out.println("Sorry no list to be displayed");
		}
		else
		{
			
			Node temp = start;
			Node result = null;
			Node next = null;
			
			while(temp!=null)
			{
				//System.out.println(temp.getData() + " -> ");
				next = temp.getLink();
				temp.setLink(result);
				result = temp;
				temp = next;
			}
			start = result;
				
		}
		
	}
	
	public int mFromLast(int m)
	{
		Node temp = start;
		Node runner =start;
		while(m>0)
		{
			runner = runner.getLink();
			m--;
		}
		while(runner!=null)
		{
			temp = temp.getLink();
			runner = runner.getLink();
		}
		return temp.getData();
	}

	/*public void recRev(Node start)
	{
		Node head;
		Node rest;
		if(start == null)
			return;
		head = start;
		rest = head.getLink();
		if(rest == null)
			return;
		Node temp = head.getLink();
		temp.getLink() = head;
		head.setLink(null);
		start = rest;
		
	}*/
	
}
