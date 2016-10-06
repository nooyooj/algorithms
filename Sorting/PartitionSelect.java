import edu.gwu.algtest.*;
import java.util.Arrays;

public class PartitionSelect implements SelectionAlgorithm
{
	public int[] findKSmallest(int K, int[] data)
	{
		if(K == 0 || data.length == 0) //if K is 0 and the length of data is 0, it means that they are empty.
		{
			return null; //therefore, return null
		}	
		
		int[] retArray = new int[K]; //declare retArray that returns the array of K size

		recursiveSelect(data, K, 0, data.length-1); //begins recursiveSelect method
		
		for(int k = 0; k < K; k++)
		{
			retArray[k] = data[k]; //store data of K size after the recursion
		}

		return retArray; //returns retArray
	}
	
	void swap(int[] data, int i, int j) //this method swaps the data
	{
		int temp = data[i]; //swaps
		data[i] = data[j]; //swaps
		data[j] = temp;  //swaps
	}

	int findPartitionPosition(int[] data, int left, int right) //method to find the partitionposition
	{
		int pivot = data[left]; //first you declare the pivot and store the first data of the array.
		while(left <= right)
		{
			while(data[left] < pivot) //while data is less than the data at the pivot index,
			{
				left++; // the left index increases to check
			}

			while(data[right] > pivot) //while data is greater than pivot it means the data is on the right
			{
				right--; // right decreases
			}

			if(left <= right) //if the left index is less than the right index, 
			{
				swap(data, left, right); //we swap
				left++; //left increases to check the next left element
				right--; //right decreases to check the next right element
			}
		}
		return left; //otherwise, position should be at left
	}

	void recursiveSelect(int[] data, int K, int left, int right)
	{
		if(data == null || data.length == 0 || K == 0) //null test
		{
			return;
		}
		
		int partitionPosition = findPartitionPosition(data, left, right); //declare partitionPosition
		
		if(left < partitionPosition - 1) //if left is less than partitionPosition
		{
			recursiveSelect(data, K, left, partitionPosition - 1); //then recursive occurs on left. it recurse on partitionPosition-1 because it has to ignore the mid point
		}

		if(right > partitionPosition) //if right is greater than partitionPosition
		{
			recursiveSelect(data, K, partitionPosition, right); //then recursive occurs on right
		}
	}

	public java.lang.Comparable[] findKSmallest(int K, java.lang.Comparable[] data)
	{
		return null;		
	}

	public void setPropertyExtractor(int algID, edu.gwu.util.PropertyExtractor prop)
	{
	}

	public java.lang.String getName()
	{
		return "PartitionSelect By Jooyoon Byun";
	}
}
