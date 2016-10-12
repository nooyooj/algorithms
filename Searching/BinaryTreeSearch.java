import java.util.*;

class TreeNode extends ComparableKeyValuePair
{
	TreeNode left;
	TreeNode right;
	TreeNode parent;
}

class ComparableKeyValuePair
{
	Comparable key;
	Object value;

	ComparableKeyValuePair()
	{
		this.key = null;
		this.value = null;
	}

	ComparableKeyValuePair(Comparable comparable, Object object)
	{
		this.key = comparable;
		this.value = object;
	}
}

public class BinaryTreeSearch 
{
	public TreeNode root; 

	public void initialize(int maxSize) 
	{
		root = null;
	}

	public Object insert(Comparable key, Object value) 
	{
		if (root == null) 
		{
            root = new TreeNode(); 
			root.key = key; 
			root.value = value;

		 	return root.value; 
		}

		else 
		{
			return insertRecursive(root, key, value); 
		}
	}

	public Object insertRecursive(TreeNode node, Comparable key, Object value)
	{
		int index = key.compareTo(node.key); 
	
		TreeNode nodeLeft = new TreeNode(); 
		TreeNode nodeRight = new TreeNode(); 

		if(index < 0) 
		{
			if(node.left == null) 
			{
				node.left = nodeLeft; 
				nodeLeft.key = key;
				nodeLeft.value = value;
			}

			else
			{
				insertRecursive(node.left, key, value); //otherwise, recurse again
			}
		}
		
		if(index > 0) 
		{
			if(node.right == null) 
			{
				node.right = nodeRight; 
				nodeRight.key = key;
				nodeRight.value = value;
			}

			else
			{
				insertRecursive(node.right, key, value); 
			}
		}
		
		return value; 
	}
	
	public ComparableKeyValuePair search(Comparable key)
	{
		ComparableKeyValuePair result = new ComparableKeyValuePair(); 
		
		if(root == null) 
		{
			return null;
		}
		
		result = searchRecursive(root, key, result); 
		
		if(result.key == null) 
		{
			return null;
		}
	
		return result; 
	}

	public ComparableKeyValuePair searchRecursive(TreeNode node, Comparable key, ComparableKeyValuePair result)
	{
		if(node.left != null) 
		{
			searchRecursive(node.left, key, result);
		}
		
		int index = key.compareTo(node.key); 

		if(index == 0) 
		{
			result.key = node.key;
			result.value = node.value;
		}
	
		if(node.right != null) 
		{
			searchRecursive(node.right, key, result);
		}
		
		return result; 
	}

	public ComparableKeyValuePair minimum() 
	{	
		if(root == null) 
		{
			return null;
		}
			
		ComparableKeyValuePair minNode = new ComparableKeyValuePair(); 
		
		if(root.left == null) 
		{
			minNode.key = root.key; 
			minNode.value = root.value; 
		}
		
		if(root.left != null) 
		{
			minNode = minimumRecursive(root.left, minNode); 
		}

		return minNode; 
	}
	
	public ComparableKeyValuePair minimumRecursive(TreeNode node, ComparableKeyValuePair minNode)
	{
		if(node.left == null) 
	    {    
		    minNode.key = node.key; 
		    minNode.value = node.value; 
		}
		
		if(node.left != null) 
		{
			minimumRecursive(node.left, minNode); 
		}

		return minNode; 
	}
	
	public ComparableKeyValuePair maximum() 
	{
		if(root == null) 
		{
			return null;
		}
		
		ComparableKeyValuePair maxNode = new ComparableKeyValuePair(); 
		
		if (root.right == null)	
		{
			maxNode.key = root.key; 
			maxNode.value = root.value; 
		}
		
		if (root.right != null) 
		{
			maxNode = maximumRecursive(root.right, maxNode); 
		}

		return maxNode; 
	}
	
	public ComparableKeyValuePair maximumRecursive(TreeNode node, ComparableKeyValuePair maxNode)
	{
		if (node.right != null) 
		{
			maximumRecursive(node.right, maxNode); 
		}
		
		if (node.right == null) 
		{
			maxNode.key = node.key; 
			maxNode.value = node.value; 
		}
		
		return maxNode; 
	}
	
	public Enumeration getKeys()
	{
		Key keys = new Key();
		return keys;
	}
	
	public Enumeration getValues() 
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


