import edu.gwu.algtest.*;
import java.util.*;
import edu.gwu.util.*;

public class Kruskal implements SpanningTreeAlgorithm
{
	public String getName(){return "Kruskal by Jooyoon Byun";}
	public void setPropertyExtractor(int algID,edu.gwu.util.PropertyExtractor prop){}

	private double[][] adjMatrix; //matrix
	private double[] x; //x values
	private double[] y; //y values
	private double weight; //declaring weight

	UnionFindInt unionFindInt = new UnionFindInt(); //declaring unionFindInt

	public void initialize(int numVertices) //this method will initialize the entire object
	{
		//System.out.println("numVertices: " + numVertices);

		adjMatrix = new double[numVertices][numVertices]; //matrix will be the size of numVertices X numVertices

		x = new double[numVertices]; //initializing x array into numVertices size
		y = new double[numVertices]; //initializing y array into numVertices size
		
		unionFindInt.initialize(numVertices); //initializing unionFindInt initialized as private above

		weight = 0; //weight is 0 now

		for(int i = 0; i < numVertices; i++)
		{
			x[i] = UniformRandom.uniform();
		}

		for(int j = 0; j < numVertices; j++)
		{
			y[j] = UniformRandom.uniform();
		}
	}

	public double calculateDistance(double x1, double y1, double x2, double y2) //this method will calculate distance for x's and y's
	{
		return Math.sqrt( Math.pow( (x2 - x1), 2 ) + Math.pow ( (y2 - y1), 2 ) ); //returning calculated distance
	}

	public double[][] minimumSpanningTree(double[][] adjMatrix) //this method will take adjacency matrix as an argument and return adjacency matrix corresponding to the minimum spanning tree
	{
		List<GraphEdge> sortedEdge = new ArrayList<GraphEdge>(); //declaring sortedEdge list and this will be arraylist

		GraphEdge ge = new GraphEdge(0, 0, 0); //GraphEdge initialized to null
		double min = 11;

		int i = 0; 
		int j = 0;

		double[][] matrixBatman = new double[x.length][x.length]; //matrix1
		double[][] matrixSuperman = new double[x.length][x.length]; //matrix2

		for(int a = 0; a < matrixBatman[0].length; a++) //looping through matrix1.size
		{
			for(int b = 0; b < matrixBatman[0].length; b++) //looping through matrix1.size
			{
				matrixSuperman[a][b] = adjMatrix[a][b]; //matrix2 will have exactly same value as adjacency matrix has
			}
		}

		while(min != 10) //while minimum is not 10
		{
			min = 10; //but assigning minimum value from the beginning

			for(j = 0; j < matrixBatman[0].length; j++) 
			{
				for(int k = 0; k < matrixBatman[0].length; k++)
				{
					if(matrixSuperman[j][k] < min && matrixSuperman[j][k] != 0) //if a certain value for matrix2 is less than min value and is not zero, then the minimum will be that value
					{
						min = matrixSuperman[j][k];
						ge = new GraphEdge(j, k, matrixSuperman[j][k]); //graph edge will store that value
					}
				}
			}

			i = ge.startVertex; //startVertex
			j = ge.endVertex; //endVertex

			sortedEdge.add(ge); //ge will be stored into the a-th space of sortedEdge

			matrixSuperman[i][j] = 0; //to the beginning
			matrixSuperman[j][i] = 0; //to the beginning
		}

		while(sortedEdge.isEmpty() == false) //while sorted edge is full
		{
			ge = sortedEdge.remove(0); //removing the first index

			i = ge.startVertex; //will again store startVertex
			j = ge.endVertex; //will again store endVertex

			if(unionFindInt.findSet(i) != unionFindInt.findSet(j)) //if found union from i and j doesn't match
			{
				unionFindInt.union(i, j);

				matrixBatman[i][j] = adjMatrix[i][j]; 
				matrixBatman[j][i] = adjMatrix[i][j];

				weight += adjMatrix[i][j]; //weight increases by the value of adjMatrix[i][j]
			}
		}

		return matrixBatman;
	}

	public GraphVertex[] minimumSpanningTree(GraphVertex[] adjList)
	{
		return null;
	}

	public double getTreeWeight()
	{
		return weight;
	}

	public static void main(String[] args)
	{
		Kruskal kruskal = new Kruskal();

		int n = 10; //starting from 10
		int count = 0; //count initialized to 0
		double avg = 0; //average initialized to 0
	
		kruskal.initialize(n);
		kruskal.minimumSpanningTree(kruskal.adjMatrix);
		avg += kruskal.getTreeWeight();
		count++;
	
		for(int i = 0; i < 10; i++)
		{
			System.out.println(kruskal.x[i] + ", " + kruskal.y[i]);
		}

		// From here just running n += 10 times for plotting graph that is required for this homework
		while(count < 101)
		{
			count = 0;
			avg = 0;

			while(count < 100)
			{
				kruskal.initialize(n);
				kruskal.minimumSpanningTree(kruskal.adjMatrix);

				avg += kruskal.getTreeWeight();
				count++;
			}
		}

		avg = avg / 100;

		//System.out.println(avg);

		n += 10;
	}
}

class UnionFindInt
{
	int[] sets;

	public void createSingleSet(int n)
	{
		sets[n]= n;
	}

	public void initialize(int numVertices) //initializing sets
	{
		sets = new int[numVertices];
		
		for(int i = 0; i < numVertices; i++)
		{
			createSingleSet(i); //create a single set when initialized
		}
	}

	public void union(int a, int b)
	{
		int track = 0;

		if(sets[a] < sets[b])
		{
			track = sets[b];

			for(int i = 0; i < sets.length; i++)
			{
				if(sets[i] == track)
				{
					sets[i] = sets[a];
				}
			}
		}
		else
		{
			track = sets[a];

			for(int i = 0; i < sets.length; i++)
			{
				if(sets[i] == track)
				{
					sets[i] = sets[b];
				}
			}
		}
	}

	public int findSet(int a) //this method will return a in a set.
	{
		return sets[a];
	}
}
