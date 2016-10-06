import edu.gwu.algtest.*; //importing edu.gwu.algtest.*;
public class MyPartition implements PartitionAlgorithm //creating class called MyPartition and implements PartitionAlgorithm
{
	public int leftIncreasingPartition(int[] data, int left, int right) //method called leftIncreasingPartition that takes int[] data, int left, and int right as parameters
	{
		int index = 0; //first, I declared index at position 0 of the array
		
		for(int i = 0; i < right; i++) //begins for-loop to loop through array "number of 'right'" times 
		{
			if(data[index] > data[index + 1]) //begins if-statement to check if data[index] is greater than data[index + 1]
			{
				int temp = data[index + 1]; //if so, swaps
				data[index + 1] = data[index]; //swaps
				data[index] = temp; //swaps
				index += 1; //increases index by 1 because we no longer need current index.
			}
			
			else //if the above if-statement doesn't satisfy
			{
				int temp = data[index + 1]; //declare temp and store data of index+1
				for(int j = index + 1; j < right; j++) //begins for-loop to loop from index+1 position to the number of right
				{
					data[j] = data[j + 1]; //we put all data on the right into the data of its left
				}

				data[right] = temp; //temp value declared above becomes data at the "right" position
			}
		}
		
		return index; //returns index

	}

	public int rightIncreasingPartition(int[] data, int left, int right)
	{
		return 0;
	}

	public java.lang.String getName()
	{
		return "Jooyoon Byun";
	}

	public void setPropertyExtractor(int algID, edu.gwu.util.PropertyExtractor prop)
	{
		
	}
}
