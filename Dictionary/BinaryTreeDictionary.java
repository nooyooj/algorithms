import edu.gwu.algtest.*;
import java.util.*;
import java.lang.*;

public class BinaryTreeDictionary implements StringDictionaryAlgorithm
{
	private TreeNode root;
	
	public String getName(){return "BinaryTreeDictionary";}
	public void setPropertyExtractor(int algID,edu.gwu.util.PropertyExtractor prop){}

    public BinaryTreeDictionary()
    {
        root = null; //initialize the Binary Tree, starting off with root is null
    }

    public void clear()
	{
	    root = null; //when we clear the tree, root becomes null meaning it is empty
	}
	
	private void insert(TreeNode root, TreeNode node, String key) //insert method will insert key into the tree recursively
	{
		TreeNode nodeLeft = new TreeNode(); //creating nodeLeft that will store key that will be stored into left of the node
		TreeNode nodeRight = new TreeNode(); //creating nodeRight that will store key that will be stored into right of the node

	    if (root.left == null) //if left value of root is empty
		{
	        node.left = nodeLeft; //it means nodeLeft will become left of the node
			nodeLeft.key = key; //key that is passed in as parameter will be stored into left of the node
			root.left = node; //it means left of the root is node
	        node.parent = root; //parent becomes root because it just added a key into the node
	    }

		else if(root.left != null) //if there is something in the left of root
		{
			insert(root.left, node, key); //recursive occurs
		}

	    else if (root.right == null) //if right of root is empty
		{
			node.right = nodeRight; //it will store nodeRight into right of node
			nodeRight.key = key; //storing value into nodeRight
	        root.right = node; //because root.right was null, so we insert node into root.right
	        node.parent = root; //parent becomes root
	    }

	    else if(root.right != null) //if null
	    {
	        insert(root.right, node,key); //recursive occurs
	    }
	}
	
	public boolean insert(String key)
	{
	    if(contains(key) == true) //if key is already in the tree
		{
            return false; //then we can't add any value. So, return false
        }

		else //otherwise
        {
            TreeNode node = new TreeNode(); //we create a node
            
			node.key = key; //once we created node, that node's key will be the key that is passed in as parameter
            
            if(root == null) //if root is empty
            {
                root = node; //root becomes node because there has to be something in root
            }
        
			else //if root is not empty
            {
                insert(root, node, key); //we insert
            }
            
			return true;
        }
	}


    private void delete(TreeNode node, String key) //delete will delete things in the tree
    {
        if(node != null) //if node is not empty it means we can delete
        {
            if(node.key.equals(key)) // match on the node itself
            {
				System.out.println("test3");
    
				TreeNode nParent = node.parent; //creating parent
                
                if(node.left == null && node.right == null) //the case where left and right are both empty
                {
                    if(nParent.left == node) //but then, if left parent is empty
                    {
                        nParent.left = null; //set parent to null
                    }
                 
				 	else //if it is not
                    {
                        nParent.right = null; //set right to null
                    }
                    
                    node = null; //otherwise, node itself is null
                }

                else if(node.left != null && node.right == null) //the case where left has value but right doesn't
                {
                    TreeNode current = node.left; //so we go to the left and current becomes left
                   
					if(nParent == null) //if parent is null
					{
							
					}

                    if(nParent.left == node) //if left matches with node it means left parent has to be current that stores node.left above
                    {
                        nParent.left = current; //current to left parent
                        current.parent = nParent; //parent becomes current parent because we already added
                    }
                
					else //otherwise
                    {
                        nParent.right = current; //current to right parent
                        current.parent = nParent;
                    }
                    
                    node = null; //otherwise, node is null
                }

                else if(node.left == null && node.right != null) //the case where left is empty but there is something in right
                {
                    TreeNode current2 = node.right; //current2 has node.right
                    
                    if(nParent.right == node) //I did inversely as I did in the above case
                    {
                        nParent.right = current2; //like above case, if right parent matches with node then current is right parent
                        current2.parent = nParent; //like above case, parent will be stored into current parent
                    }
                    
                    else //otherwise
                    {
                        nParent.left = current2; //oppositely current will be stored into left parent
                        current2.parent = nParent;
                    }
                }
            }

            else //or
            {
                delete(node.left, key); //we just delete left noderecursively
                delete(node.right, key); //we just delete right node recursively
            }
        }
    }

    /*
    Method delete should delete the the given string if 
    it's already in the data structure. 
    Return false if it's not there.
    */
    
	public boolean delete(String key)
	{
		boolean canDelete = contains(key); //check if we can delete
		
		if(!canDelete) // if not contains
		{ 
			return false; //return false meaning we can't delete
		}

		if(root.key.equals(key)) //if root string equals key
		{
			root = root.left; //move root downward	
		}

        // otherwise we proceed ahead
        delete(root, key); // search through the tree beginning at root
        
		return true;
	}

    private boolean contains(TreeNode node, String key)
    {
        if(node == null) //if node is empty
		{
			return false; //then return false
		}

		if(node!=null) //if node is not null
        {
            if(node.key.equals(key)) //match on the node itself
            {
                return true; //if matches return true
            }

            else //if not,
            {
                if(contains(node.left, key) || contains(node.right, key)) //we recursively check if nodes are acceptable
				{
                    return true; //if one of them are available, then true
				}
            }
        }
		
        return false; //if any of above statements doesn't satisfy, we return false
    }
    
	public boolean contains(String key) //contains method checks if the tree contains the key
	{
		boolean result = contains(root, key); //go to the recursive contains above

		return result; //return result
	}

	public String[] toSortedArray()
	{
		return null; //this method is not required for this assignment
	}

	public static void main(String[] args)
	{
		BinaryTreeDictionary dict = new BinaryTreeDictionary();

		dict.insert("hello");
		dict.insert("my");
		dict.insert("name");
		dict.insert("is");
		dict.insert("eric");

		if(dict.contains("hello"))
		{
			System.out.println("contains hello = true");
		}

		else
		{
			System.out.println("contains hello = false");
		}

		if(dict.contains("hllo"))
		{
			System.out.println("contains hllo = true");
		}

		else
		{
			System.out.println("contains hllo = false");
		}

		if(dict.contains("my"))
		{
			System.out.println("contains my = true");
		}

		else
		{
			System.out.println("contains my = false");
		}

		if(dict.contains("name"))
		{
			System.out.println("contains name = true");
		}

		else
		{
			System.out.println("contains name = false");
		}

		if(dict.contains("is"))
		{
			System.out.println("contains is = true");
		}

		else
		{
			System.out.println("contains is = false");
		}

		if(dict.contains("eric"))
		{
			System.out.println("contains eric = true");
		}

		else
		{
			System.out.println("contains eric = false");
		}

		if(dict.contains("erii"))
		{
			System.out.println("contains erii = true");
		}

		else
		{
			System.out.println("contains erii = false");
		}

		dict.delete("hello");
		
		System.out.println("after deleting hello");

		if(dict.contains("hello"))
		{
			System.out.println("contains hello = true");
		}

		else
		{
			System.out.println("contains hello = false");
		}
	}
}

