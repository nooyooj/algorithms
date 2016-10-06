import edu.gwu.algtest.*;
import java.util.*;

public class BinarySearch implements OrderedSearchAlgorithm 
{
	public TreeNode root; //I used TreeNode because BinarySearch is about root and tree

	public String getName()
	{
		return "BinarySearch by Jooyoon Byun";
	}

	public void setPropertyExtractor(int algID,edu.gwu.util.PropertyExtractor prop)
	{
		//empty
	}

	public void initialize(int maxSize) //initializing root with null because it should be empty at first
	{
		root = null;
	}

	public int getCurrentSize() //not used method but was required because of interfaces
	{
		return 0;
	}

	public Object insert(Comparable key, Object value) //this inserts to run based on the key
	{
		if (root == null) //if root is empty
		{
            root = new TreeNode(); //create a new Object called TreeNode
			root.key = key; 
			root.value = value;

		 	return root.value; //returned root.value because key was passed in as argument and is performed, so associated value had to be returned.
		}

		else //if there are already some roots
		{
			return insertRecursive(root, key, value); //recursion begins
		}
	}

	public Object insertRecursive(TreeNode node, Comparable key, Object value)
	{
		int index = key.compareTo(node.key); //index is initialized to key that is compared itself.
	
		TreeNode nodeLeft = new TreeNode(); //left node object
		TreeNode nodeRight = new TreeNode(); //right node object

		if(index < 0) //while the key index is less than 0
		{
			if(node.left == null) //and if left of the node is empty
			{
				node.left = nodeLeft; //create a root of nodeLeft which is created above to store the data
				nodeLeft.key = key;
				nodeLeft.value = value;
			}

			else
			{
				insertRecursive(node.left, key, value); //otherwise, recurse again
			}
		}
		
		if(index > 0) //if index is greater than 0, this means we have to look at the data from the right
		{
			if(node.right == null) //if right of the node is empty
			{
				node.right = nodeRight; //then we create a root of nodeRight which is created to store the data
				nodeRight.key = key;
				nodeRight.value = value;
			}

			else
			{
				insertRecursive(node.right, key, value); //otherwise, recurse again
			}
		}
		
		return value; //return value and objects calculated above works fine 
	}
	
	public ComparableKeyValuePair search(Comparable key)
	{
		ComparableKeyValuePair result = new ComparableKeyValuePair(); //result object will contain key and value
		
		if(root == null) //if root is empty, then null
		{
			return null;
		}
		
		result = searchRecursive(root, key, result); //this goes into the recursive because it has to keep searching for the nodes
		
		if(result.key == null) //if key is empty, then null. Test null case.
		{
			return null;
		}
	
		return result; //return the result of the search, key and value.
	}

	public ComparableKeyValuePair searchRecursive(TreeNode node, Comparable key, ComparableKeyValuePair result)
	{
		if(node.left != null) //if left of the node is not null, it means we can keep searching for the nodes, so we recurse again.
		{
			searchRecursive(node.left, key, result);
		}
		
		int index = key.compareTo(node.key); //index is initialized to key that is compar    ed itself.

		if(index == 0) //if index key is 0, then we just store that data into there
		{
			result.key = node.key;
			result.value = node.value;
		}
	
		if(node.right != null) //as I did for left, do the same thing for right node
		{
			searchRecursive(node.right, key, result);
		}
		
		return result; //returns ComparableKeyValuePair.
	}

	public ComparableKeyValuePair minimum() //find the key-value pair with least key
	{	
		if(root == null) //null test
		{
			return null;
		}
			
		ComparableKeyValuePair minNode = new ComparableKeyValuePair(); //create a minNode
		
		if(root.left == null) //null means left node doesn't have any data
		{
			minNode.key = root.key; //then remains the same
			minNode.value = root.value; //then remains the same
		}
		
		if(root.left != null) //if there are data in the node
		{
			minNode = minimumRecursive(root.left, minNode); //we store the data by recursing
		}

		return minNode; //return minimum
	}
	
	public ComparableKeyValuePair minimumRecursive(TreeNode node, ComparableKeyValuePair minNode)
	{
		if(node.left == null) //test null
	    {    
		    minNode.key = node.key; //if null then same value
		    minNode.value = node.value; //if null, then same value
		}
		
		if(node.left != null) //if there is data in the left node
		{
			minimumRecursive(node.left, minNode); //we keep recursing
		}

		return minNode; //returns minNode
	}
	
	public ComparableKeyValuePair maximum() //return the key-value pair with largest key
	{
		if(root == null) //null test
		{
			return null;
		}
		
		ComparableKeyValuePair maxNode = new ComparableKeyValuePair(); //create a maxNode
		
		if (root.right == null)	//null here means right node doesn't have any data
		{
			maxNode.key = root.key; //then same value
			maxNode.value = root.value; //then same value
		}
		
		if (root.right != null) //if right node has data
		{
			maxNode = maximumRecursive(root.right, maxNode); //we recurse
		}

		return maxNode; //returns maximum
	}
	
	public ComparableKeyValuePair maximumRecursive(TreeNode node, ComparableKeyValuePair maxNode)
	{
		if (node.right != null) //test null
		{
			maximumRecursive(node.right, maxNode); //if this is not null we recurse
		}
		
		if (node.right == null) //test null
		{
			maxNode.key = node.key; //if null then same value
			maxNode.value = node.value; //if null then same value
		}
		
		return maxNode; //maximum
	}
	
	public Object delete(Comparable key)
	{
		return null;
	}

	public Comparable successor (Comparable key)
	{
		return null;
	}

	public Comparable predecessor (Comparable key)
	{
		return null;
	}

	public Enumeration getKeys() //just to return keys
	{
		Key keys = new Key();
		return keys;
	}
	
	public Enumeration getValues() //just to return values
	{
		Value values = new Value();
		return values;
	}
}

class Key implements Enumeration
{
	public boolean hasMoreElements()
	{
		return false;
	}
	
	public Comparable nextElement()
	{
		return null;
	}
}

class Value implements Enumeration
{
	public boolean hasMoreElements()
	{
		return false;
	}
	
	public Object nextElement()
	{
		return null;
	}	
}
