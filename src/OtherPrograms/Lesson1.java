package OtherPrograms;
import java.util.*;
import java.math.*;

enum word{million, lakh, tenthousand, thousand, hundreds};
public class Lesson1 {

	public static void main(String[] args)
	{
		//spaceReplace();
		//compress();
		inWords();
		
	}
	
	public static void inWords()
	{
		int num = 123;
		//counting the number of digits:
		String numLen = "" + num;
		System.out.println(numLen.length());
		int m = (int)Math.pow(10,3);
		System.out.println(m);
		int r;
		Stack<Integer> myStack = new Stack<Integer>();
		while(num*10/10 == 10)		{
			r =num%m;
			myStack.push(r);
			num = num/m;
			m=m/10;			
		}
	}
	public static void spaceReplace()
	{
		String str = "Mr Smith Jackson";
		//String strReplaced = str.replaceAll(" ", "%20");
		//System.out.println("String is: " + strReplaced);
		char[] charArray = new char[str.length() + 4];
		//System.out.println(str.charAt(0));
		for(int i=0, k=0; i<str.length() && k<str.length()+4; i++, k++)
		{
			if(str.charAt(i) == ' ')
			{
				charArray[k] = '%';
				charArray[k+1] = '2';
				charArray[k+2] = '0';
				k += 2;
			}
			else
			{
				charArray[k] = str.charAt(i);
			}
		}
		String strReplaced = new String(charArray);
		System.out.println("Here is the final string:" + strReplaced);
	
	}
	
	public static void compress()
	{
		String str = "aabcccccaadd";
		String compressedStr;
		char[] charArray = new char[str.length()];
		char a;
		System.out.println(str.length());
		int count;
		for(int i=0, j=0; i<str.length(); i++,j++)
		{
			a = str.charAt(i);
			System.out.println(a);
			count = 0;
			for(int k=i; k<str.length()-i && str.charAt(k) == a; k++)
			{
				//System.out.println(str.charAt(k));
				count++;
//				i = i+count-1;
			}
			System.out.println(count);
			if(j<str.length())
			{
				charArray[j] = a;
				charArray[j+1] = Character.forDigit(count, 10);
				//System.out.println(count);
				j += 1;
//				System.out.println("before: " + i);
				i += count-1;
//				System.out.println("after: " + i);
			}
			else{
				compressedStr = str;
			}
//			i += count-1;
		}
		compressedStr = new String(charArray);
		System.out.println(compressedStr);
	}
}
