import java.util.*;
import java.lang.*;

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
public class BinaryTreeDictionary 
{
	private TreeNode root;
	
    public BinaryTreeDictionary()
    {
        root = null; 
    }

    public void clear()
	{
	    root = null; 
	}
	
	private void insert(TreeNode root, TreeNode node, String key) 
	{
		TreeNode nodeLeft = new TreeNode(); 
		TreeNode nodeRight = new TreeNode(); 

	    if(root.left == null) 
		{
	        node.left = nodeLeft; 
			nodeLeft.key = key; 
			root.left = node; 
	        node.parent = root; 
	    }

		else if(root.left != null) 
		{
			insert(root.left, node, key); 
		}

	    else if(root.right == null) 
		{
			node.right = nodeRight; 
			nodeRight.key = key; 
	        root.right = node; 
	        node.parent = root; 
	    }

	    else if(root.right != null) 
	    {
	        insert(root.right, node,key); 
	    }
	}
	
	public boolean insert(String key)
	{
	    if(contains(key) == true) 
		{
            return false; 
        }

		else 
        {
            TreeNode node = new TreeNode(); 
            
			node.key = key; 
            
            if(root == null) 
            {
                root = node; 
            }
        
			else 
            {
                insert(root, node, key); 
            }
            
			return true;
        }
	}

    private void delete(TreeNode node, String key)
    {
        if(node != null) 
        {
            if(node.key.equals(key)) 
            {
				TreeNode nParent = node.parent; 
                
                if(node.left == null && node.right == null) 
                {
                    if(nParent.left == node) 
                    {
                        nParent.left = null; 
                    }
                 
				 	else 
                    {
                        nParent.right = null; 
                    }
                    
                    node = null; 
                }

                else if(node.left != null && node.right == null) 
                {
                    TreeNode current = node.left; 
                   
					if(nParent == null) 
					{
							
					}

                    if(nParent.left == node) 
                    {
                        nParent.left = current; 
                        current.parent = nParent; 
                    }
                
					else 
                    {
                        nParent.right = current; 
                        current.parent = nParent;
                    }
                    
                    node = null; 
                }

                else if(node.left == null && node.right != null) 
                {
                    TreeNode current2 = node.right; 
                    
                    if(nParent.right == node) 
                    {
                        nParent.right = current2; 
                        current2.parent = nParent; 
                    }
                    
                    else 
                    {
                        nParent.left = current2; 
                        current2.parent = nParent;
                    }
                }
            }

            else 
            {
                delete(node.left, key); 
                delete(node.right, key); 
            }
        }
    }

	public boolean delete(String key)
	{
		boolean canDelete = contains(key); 
		
		if(!canDelete) 
		{ 
			return false; 
		}

		if(root.key.equals(key)) 
		{
			root = root.left; 
		}

        delete(root, key); 
        
		return true;
	}

    private boolean contains(TreeNode node, String key)
    {
        if(node == null) 
		{
			return false; 
		}

		if(node!=null) 
        {
            if(node.key.equals(key)) 
            {
                return true; 
            }

            else 
            {
                if(contains(node.left, key) || contains(node.right, key)) 
				{
                    return true; 
				}
            }
        }
		
        return false; 
    }
    
	public boolean contains(String key) 
	{
		boolean result = contains(root, key); 

		return result; 
	}

	public static void main(String[] args)
	{
		BinaryTreeDictionary dict = new BinaryTreeDictionary();

		System.out.println();
		dict.insert("hello");
		System.out.println("inserting \"hello\"...");
		dict.insert("my");
		System.out.println("inserting \"my\"...");
		dict.insert("name");
		System.out.println("inserting \"name\"...");
		dict.insert("is");
		System.out.println("inserting \"is\"...");
		dict.insert("Jooyoon");
		System.out.println("inserting \"Jooyoon\"...");
		System.out.println();

		System.out.println("checking \"hello\" in binary tree...");
		if(dict.contains("hello"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"hell\" in binary tree...");
		if(dict.contains("hell"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		System.out.println("checking \"hllo\" in binary tree...");
		if(dict.contains("hllo"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"my\" in binary tree...");
		if(dict.contains("my"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"name\" in binary tree...");
		if(dict.contains("name"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"is\" in binary tree...");
		if(dict.contains("is"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"eric\" in binary tree...");
		if(dict.contains("eric"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"Jooyoon\" in binary tree...");
		if(dict.contains("Jooyoon"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println();
		
		System.out.println("deleting \"hello\" from binary tree...");
		dict.delete("hello");
	
		System.out.println();
		System.out.println("checking \"hello\" in binary tree...");
		if(dict.contains("hello"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println();
	}
}

