package Trees;

import java.util.Scanner;

public class BstImplement {

	public static void main(String[] args)
	{
		BinaryTree bt = new BinaryTree();
		Scanner scan= new Scanner(System.in);
		char ch;
		int choice, val;
		do{
			System.out.println("Welcome");
			System.out.println("1. Insert");
			System.out.println("2. Search");
			System.out.println("3. Size");
			choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Please enter the value:");
				val= scan.nextInt();
				bt.insertNode(val);
				System.out.println(bt.root);
				break;
			
			case 2:
				System.out.println("Enter the value to be searched:");
				val = scan.nextInt();
				bt.search(val);
				break;
			
			case 3:
				int s = bt.TreeSize(bt.root);
				System.out.println("Size of tree is: " + s);
			}
			System.out.println("Do you want to continue? (y/n)");
			ch = scan.next().charAt(0);
		}while(ch == 'y' || ch == 'Y');
	}
}
