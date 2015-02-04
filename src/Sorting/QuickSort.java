package Sorting;

public class QuickSort {
	
	public static void main(String[] args)
	{
		int[] nums = Utility.nums;
		sort(nums,0,nums.length-1);
		Utility.display(nums);
	}

	private static void sort(int[] nums, int start, int end) {
		if(start < end){
		int pIndex = partion(nums, start, end);
		sort(nums, start, pIndex - 1);
		sort(nums, pIndex+1, end);
		}
	}

	private static int partion(int[] nums, int start, int end) {
		int pIndex = start;
		int pivot = nums[end];
		int i = start;
	
		while(i <= end-1)
		{	if(nums[i] < pivot)
			{	
				int temp = nums[pIndex];
				nums[pIndex] =nums[i];
				nums[i] = temp;
				pIndex++;
			}
			i++;
		}
		//swapping pivot and nums[pIndex]
		int temp = nums[pIndex];
		nums[pIndex] = nums[end];
		nums[end] = temp;
		
		return pIndex;
	}
}
