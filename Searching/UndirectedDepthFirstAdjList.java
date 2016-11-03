import edu.gwu.algtest.*;
import edu.gwu.util.*;
import edu.gwu.geometry.*;
import java.util.*;
import edu.gwu.*;

public class UndirectedDepthFirstAdjList implements UndirectedGraphSearchAlgorithm
{
	private int numVertices; //declaring number of vertices
	private int numEdges; //declaring number of edges
	private boolean isWeighted; //declaring isWeighted
	private LinkedList<GraphEdge>[] adjList; //declaring linkedList adjList that will store vertex numbers
	private int[] visitOrder; //declaring visitOrder array that will store the array so I can calculate if the array is visited
  	private int[] cycle;
	private int cCount;
 	private int visitCount;
 	private int[] cOrder;
  	private int[] cLabels;
	private int currentCLabel;

	private int numConnectedComponents;

  	public void initialize(int numVertices, boolean isWeighted) //method 1
	{
	    adjList = new LinkedList[numVertices];

	    for(int i = 0; i < numVertices; i++)
		{
	      	adjList[i] = new LinkedList();
	    }

    	visitOrder = new int[numVertices];
    	cOrder = new int[numVertices];
    	cLabels = new int[numVertices];
    	cCount = -1;
    	visitCount = -1;
    	numEdges = 0;
 
 		numConnectedComponents = 0;

 		for(int i = 0; i < visitOrder.length; i++)
		{
 			visitOrder[i] = -1;
		    cOrder[i] = -1;
		    cLabels[i] = -1;
    	}
  	}

  	public void insertUndirectedEdge(int startVertex, int endVertex, double weight) //method 2
	{
		//System.out.println("----------insertUndirectedEdge()----------");
		//System.out.println("startVertex = " + startVertex);
		//System.out.println("endVertex = " + endVertex);
		//System.out.println("weight = " + weight);

	    GraphEdge e = new GraphEdge(startVertex, endVertex, weight); //creating GraphEdge instance to add edge
	    adjList[startVertex].addLast(e); //adding edge to last at starting vertex

	    GraphEdge e2 = new GraphEdge(endVertex, startVertex, weight); //creating GraphEdge instance to add second egde
	    adjList[endVertex].addLast(e2); //eding second edge to last at end vertex

	    numEdges++; //numEdges increases because pair of edge increased
  	}

	public int[] depthFirstVisitOrder() //method 3
	{
		//System.out.println("----------depthFirstVisitOrder()----------");
		int touchCount = 0; //touchCount will count touch count
	
		for(int i = 0; i < visitOrder.length; i++) //looping through the size of visited order
		{
			//System.out.println("visitOrder = " + visitOrder[i]); 
			if(visitOrder[i] < 0) //if visitOrder is less than 0 it means 
			{
				numConnectedComponents += 1;
				depthFirstRecursive(i, touchCount);
				touchCount++;
			}
		}

		return visitOrder;
	}

	public void depthFirstRecursive(int index, int touch) //method 3-1
	{
		//System.out.println("----------depthFirstRecursive()----------");
		visitCount++;
		visitOrder[index] = visitCount;
		cLabels[index] = touch;
		
		if(adjList[index] != null)
		{
			ListIterator<GraphEdge> itr = adjList[index].listIterator();
		
			while(itr.hasNext())
			{
				GraphEdge e = itr.next();
				if(visitOrder[e.endVertex] < 0)
				{
					depthFirstRecursive(e.endVertex, touch);
				}
			}
		}
		
		cCount++;
		cOrder[index] = cCount;
	}

	public int[] depthFirstCompletionOrder() //method 4
	{
		//System.out.println("----------depthFirstCompletionOrder()----------");

		return cOrder;
	}
	
	public int[] componentLabels() //method 5
	{
		//System.out.println("----------componentLabels()----------");

		return cLabels;
	}

	public boolean existsCycle() //method 6
	{
		//System.out.println("----------existsCycle()----------");

		cycle = new int[visitOrder.length];

		for(int i = 0; i < visitOrder.length; i++) //looping throu visitOrder numbers
		{
			cycle[i] = -1; //resetting to -1 to make it not visited
		}

		return recursiveExistsCycle(0); //passing 0 as argument because we start from the beginning
	}

	private boolean recursiveExistsCycle(int startIndex) 
	{
		//System.out.println("Recursive cycle call... " + startIndex);
		for(int i = 0; i < adjList[startIndex].size(); i++) //loop on the full adjacency
		{
			int current = adjList[startIndex].get(i).endVertex; 
			
			//System.out.println("Now at current : " + current);

			if(cycle[current] == -1) //not yet visited
			{
				//System.out.println(current + " not yet visited");
				cycle[current] = 1; //visited
				recursiveExistsCycle(current); //recurse on it
			}
			else //already visited
			{
				//System.out.println(current + " already visited. Cycle found.");
				return true; //cycle found
			}
		}
		return false; //cycle not found
	}

	public int numConnectedComponents()
	{
		depthFirstVisitOrder();
		return numConnectedComponents;
	}

	public GraphEdge[] articulationEdges(){return null;}
	public int[] articulationVertices(){return null;}
	public int[] breadthFirstVisitOrder(){return null;}
	public boolean existsOddCycle(){return false;}
	public java.lang.String getName(){return "UndirectedDepthFirstAdjList";}
	public void setPropertyExtractor(int algID,edu.gwu.util.PropertyExtractor prop){}

	public static boolean randomCoinFlip(double p)
	{
		if(UniformRandom.uniform() < p)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args)
	{
		UndirectedDepthFirstAdjList dfs = new UndirectedDepthFirstAdjList();
		
		dfs.initialize(5, false);
		
		dfs.insertUndirectedEdge(0, 1, 1);
		dfs.insertUndirectedEdge(1, 3, 1);
		dfs.insertUndirectedEdge(2, 3, 1);

		int[] test = dfs.depthFirstVisitOrder();

		System.out.print("Visit Order: ");
		for(int i = 0; i < test.length; i++)
		{
			System.out.print(test[i] + " ");
		}
		System.out.println();

		test = dfs.depthFirstCompletionOrder();

		System.out.print("Completion Order: ");
		for(int i = 0; i < test.length; i++)
		{
			System.out.print(test[i] + " ");
		}
		System.out.println();

		//----------part 3 testings begin here----------//
		int vertices = 10;
		//int vertices = 20;
		int n = 1000;
		double largeP = 0.05;
		double[] averageVertices = new double[vertices];

		double smallP = 0.01;
	
		dfs.initialize(10, false); //10 vertices

		for(int i = 0; i < dfs.adjList.length; i++)
		{
			for(int j = 0; j < dfs.adjList.length; j++)
			{
				if(i != j)
				{
					if(randomCoinFlip(0.1) == true)
					{
						dfs.insertUndirectedEdge(i, j, 0);
					}
				}
			}
		}

		for(int i = 0; i < dfs.adjList.length; i++) 
		{
			for(int j = 0; j < dfs.adjList.length; j++) 
			{
				if(i != j) 
				{
					if(randomCoinFlip(0.2) == true) 
					{
						dfs.insertUndirectedEdge(i, j, 0);
					}
				}
			}
		}

		for(int i = 0; i < dfs.adjList.length; i++)
		{
			for(int j = 0; j < dfs.adjList.length; j++)
			{
				if(i != j)
				{
					if(randomCoinFlip(0.3) == true)
					{
						dfs.insertUndirectedEdge(i, j, 0);
					}
				}
			}
		}

		dfs.initialize(20, false); //20 vertices

		for(int i = 0; i < dfs.adjList.length; i++) 
		{
			for(int j = 0; j < dfs.adjList.length; j++) 
			{
				if(i != j) 
				{
					if(randomCoinFlip(0.1) == true) 
					{
						dfs.insertUndirectedEdge(i, j, 0);
					}
				}
			}
		}	

		for(int i = 0; i < dfs.adjList.length; i++) 
		{
			for(int j = 0; j < dfs.adjList.length; j++) 
			{
				if(i != j) 
				{
					if(randomCoinFlip(0.2) == true)
					{
						dfs.insertUndirectedEdge(i, j, 0);
					}
				}
			}
		}
		
		for(int i = 0; i < dfs.adjList.length; i++) 
		{
			for(int j = 0; j < dfs.adjList.length; j++) 
			{
				if(i != j) 
				{
					if(randomCoinFlip(0.3) == true) 
					{
						dfs.insertUndirectedEdge(i, j, 0);
					}
				}
			}
		}
	}
}
