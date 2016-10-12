import edu.gwu.geometry.*;
import java.util.*;

public class NaiveClosestPair 
{
	public double findClosestPairDistance(Pointd[] points)
	{
		System.out.println("--------------------");
		for(int i = 0; i < points.length; i++)
		{
			System.out.println(points[i].x + " " + points[i].y);
		}
		System.out.println("--------------------");

		int length = points.length; 
			
		double xDist = 0; 
		double yDist = 0; 

		double dist = 0; 

		int k = 0; 
		
		double[] distArray = new double[length*length-length]; 
		
		for(int i = 0; i < length; i++) 
		{
			for(int j = 0; j < length; j++) 
			{
				if(i != j) 
				{
					xDist = points[j].x - points[i].x; 
					yDist = points[j].y - points[i].y; 
					dist = calculateDistance(xDist, yDist); 
					distArray[k] = dist; 
					k++; 
				}
			}
		}
		
		insertionSort(distArray); 

		return distArray[0]; 
	}

	public double calculateDistance(double dist1, double dist2) 
	{
		return Math.sqrt(dist1*dist1 + dist2*dist2); 
	}

	public static double[] swap(double[] arr, int i, int j) 
	{
		double temp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = temp; 

		return arr; 
	}

	public static void insertionSort(double[] array) 
	{
		for(int i = 1; i < array.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(array[j] < array[j - 1])
				{
					swap(array, j, j - 1);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		NaiveClosestPair pair = new NaiveClosestPair();
		
		Pointd[] a = new Pointd[]{new Pointd(2.0, 5.0), new Pointd(8.0, 5.0)};
		
		System.out.println("Closest distance is " + pair.findClosestPairDistance(a));
		System.out.println();
		System.out.println();

		Pointd[] b = new Pointd[]{new Pointd(3.0, 2.0), new Pointd(1.0, 2.0), new Pointd(3.0, 1.0)};

		System.out.println("Closest distance is " + pair.findClosestPairDistance(b));
		System.out.println();
		System.out.println();

		Pointd[] c = new Pointd[]{new Pointd(10.0, 5.0), new Pointd(1.0, 5.0), new Pointd(3.0, 4.0), new Pointd(1.0, 1.0)};	

		System.out.println("Closest distance is " + pair.findClosestPairDistance(c));
		System.out.println();
		System.out.println();
	}
}


