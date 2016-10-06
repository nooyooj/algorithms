import edu.gwu.algtest.*;
import java.util.Arrays;

public class SortSelect implements SelectionAlgorithm
{
	public int[] findKSmallest(int K, int[] data)
	{
		if(K == 0 || data.length == 0) //if K = 0 or length of data is 0 it means it's empty
		{
			return null; //so returns null
		}

		int[] retArray = new int[K]; //declaring retArray that has the size of K to return later
		
		Arrays.sort(data); //sort by Java
		 
		for(int k = 0; k < K; k++)
		{
			retArray[k] = data[k]; //prints retArray that has the size of k 
		}

		return retArray; //return array
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
		return "SortSelect by Jooyoon Byun";
	}
}
