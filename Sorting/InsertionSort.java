import edu.gwu.algtest.*; 

public class InsertionSort implements SortingAlgorithm
{
	public void sortInPlace(int[] data)
	{
		int temp = 0; //declaring int temp to store data 
	
		for(int i = 0; i < data.length; i++) //begins for-loop to loop through data array
		{
			for(int j = i; j > 0; j--) //begins for-loop from i-th data to 0 because we should calculate from current position to the left direction
			{
				if(data[j] < data[j-1]) //begins if-statement to check if the data on the right is less than the data on the left
				{
					temp = data[j]; //if so, swaps
					data[j] = data[j-1]; //swaps
					data[j-1] = temp; //swaps
				} 
			}
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
