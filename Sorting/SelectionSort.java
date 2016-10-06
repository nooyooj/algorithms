import edu.gwu.algtest.*; //importing edu.gwu.algtest.*;

public class SelectionSort implements SortingAlgorithm //creating class called SelectionSort and implements SortingAlgorithm
{
	public void sortInPlace(int[] data) //mathod called sortInPlace that takes int[] data array as a parameter
	{		
		int temp = 0; //declaring int temp to swap 

		for(int i = 0; i < data.length-1; i++) //begins for-loop to loop through array to check if there is something to swap
		{
			int position = i; //According to the definition of selection sort, first position or index must be 0 index.
		
			for(int j = i + 1; j < data.length; j++) //begins for-loop to loop through j-th index of i-th position of array until the end of the array.
			{
				if(data[j] < data[position]) //this is the if-statement that checks if current j-th array is less than data[position], which is i-th
				{
					position = j; //if so, then position/index becomes j	
				}
			}

			temp = data[position]; //we store the data from above if-statement and found the smallest number compared to the i-th index, we store this into temp
			data[position] = data[i]; //swaps
			data[i] = temp; //swaps
		}
	}

	public void sortInPlace(java.lang.Comparable[] data)
	{
	}

	public int[] createSortIndex(int[] data)
	{
		return data;
	}

	public int[] createSortIndex(java.lang.Comparable[] data)
	{
		int[] test = new int[data.length];
        return test;
	}

	public void setPropertyExtractor(int algID, edu.gwu.util.PropertyExtractor prop)
	{
	}
	
	public java.lang.String getName()
	{
		return "Jooyoon Byun";
	}
}
