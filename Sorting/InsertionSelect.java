/*
The InsertionSelect algorithm scans the data to find the smallest integer and puts that in the first position of the return array. Then, it scans the data to find the second-smallest integer and puts that in the second position of the return array. And so on. This needs to be repeated K times
*/

import edu.gwu.algtest.*;

public class InsertionSelect implements SelectionAlgorithm
{
	public int[] findKSmallest(int K, int[] data)
	{
		//if K is 0 and the length of data is 0, it means that they are empty.
		if(K == 0 || data.length == 0)
		{
			return null;
		}
		
		//declare retArray that returns the array of K size
		int[] retArray = new int[K];
		
		//declaring int temp to store data
		int temp = 0;

		for(int i = 0; i < data.length; i++) //begins for-loop to loop through data array
		{
			for(int j = i; j > 0; j--) //begins for-loop from i-th data to 0 because we should calculate from current position to the left direction
			{
				if(data[j] < data[j-1]) //begins if-statement to check if the data on the right is less than the data on the left
				{
					temp = data[j]; //swaps
					data[j] = data[j-1]; //swaps
					data[j-1] = temp; //swaps
				}
			}
		}
	
		for(int k = 0; k < retArray.length; k++) //Here, I am storing K data into the new array to return.
		{
			retArray[k] = data[k];
		}
		
		return retArray; //return k data of array
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
		return "InsertionSelect by Jooyoon Byun";
	}
}
