package Sorting;

public class Heaping {
	
	public static void main(String args[])
	{
		int[] nums = Utility.nums;
		buildHeap(nums);
		Utility.display(nums);
	}

	private static void buildHeap(int[] num) {
		int heapSize = num.length;
		for(int i= heapSize/2; i>=0; i--)
		{
			max_Heapify(num, i);
		}
	}

	private static void max_Heapify(int[] num, int i) {
		int l = 2*i +1;
		int r = 2*i + 2;
		int max = i;
		if(l<num.length && num[l]>num[max])
		{
			max = l;
		}
		if(r<num.length && num[r]>num[max])
		{
			max = r;
		}
		if(max != i)
		{
			int temp = num[max];
			num[max] = num[i];
			num[i] = temp;
			max_Heapify(num, max);
		}
	}
}
