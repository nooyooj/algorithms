import edu.gwu.algtest.*;
import java.util.*;
import java.lang.*;

class TrieNodeList extends TrieComparableKeyValuePair //I copy and pasted TrieNode class from algtest.jar file and changed name to TrieNodeList because I am trying to use LIST to hold multiple child nodes.
{
	public ArrayList<TrieNodeList> children; //adding different definition from TrieNode for TrieNodeList
	
	public TrieNodeList parent;

	public TrieNodeList()
	{
		this.children = new ArrayList<TrieNodeList>(); //creating a list
	}
}

public class TrieDictionary implements StringDictionaryAlgorithm //our main class begins
{
	private TrieNodeList root; //creating root
	
	public String getName(){return "TrieDictionary";}
	public void setPropertyExtractor(int algID,edu.gwu.util.PropertyExtractor prop){}

    public TrieDictionary() //just a constructor that initializes our trie
    {
		root = new TrieNodeList();
		root.value = "";
    }

    /*
    Method clear should clear all strings from the data structure.
    */
    
    public void clear() //clear clears everything and brings back to the original empty root
	{
	    root = new TrieNodeList();
		root.value = "";
	}
	
	
	public boolean insert(String key) //insert method begins
	{
		if(contains(key) == true) //if contains(key) is true, it means it already contains the string that is passed in as parameter. Therefore, we just return false
		{
			return false;
		}

		else //if contains(key) is false, it means we have to insert it because it is not already there
		{
			String text = ""; //text initialized to empty

			TrieNodeList currParent = root; //current parent is root because it is empty at beginning

			for(char c: key.toCharArray()) //looping through each character in the string
			{
				text += c; //text that is declared outside this for-loop will store the character at certain position

				TrieNodeList currNode = new TrieNodeList(); //make the current node to add on Trie
				
				currNode.value = text; //text will become the current node's value
				
				boolean exists = false; //also, question is that if it already exists or not? so I created boolean exists to ask if it exists or not

				for(TrieNodeList t : currParent.children) //currentParent.children is our arraylist
				{
					if(t.value.equals(text)) //check at each value
					{
						exists = true; //because contains methods need to work with the TrieNodeList objects, we manually loop on the arraylist
						currParent = t; //currentParent will become this t because that is the Trie sequence
						break;
					}
				}

				if(!exists) //if character doesn't exists
				{
					currNode.parent = currParent; //current parent will be transferred to currNode parent
					currParent.children.add(currNode); 
					int last = currParent.children.size() - 1; //because we added the currNode, this must be stored at the last index of array, which is size - 1
					currParent = currParent.children.get(last); //so for our next iteration, this can become our node we work with
				}
			}

			return true; //otherwise, true
		}
	}


    /*
    Method delete should delete the the given string if 
    it's already in the data structure. 
    Return false if it's not there.
    */
    
	public boolean delete(String key)
	{
		System.out.println("test1");

		if(contains(key) == false) //if the trie doesn't contain key
		{
			return false; //then, return false
		}

		else //if trie contains key
		{
			System.out.println("test2");
			String text = ""; //then it means we can proceed 

			TrieNodeList current = root; //current is root

			for(char c : key.toCharArray())
			{
				text += c; //text will store character

				for(TrieNodeList t : current.children) //again here we will loop on the children and keep matching
				{
					if(t.value.equals(text)) //when we match,
					{
						current = t; //we can use that one as the current for next loop run
						break;
					}
				}

			}
			
			System.out.println("test3");
			//we actually have the exact same logic of iteration for all the methods

			//after we reach leaf node, we start deleting from leaf back up

			while(current != root) 
			{
				System.out.println("test4" + current.value);
			
				TrieNodeList currParent = current.parent;
					
				int index = 0;
				
				boolean rollOver = false;

				for(TrieNodeList t : currParent.children)
				{
					if(t.value.equals(current.value)) //we keep track of the arraylist index
					{
						//current = t; //as we go through, current becomes t if matches
						currParent.children.remove(index); //we can call remove on this t index that we have matched
						current = currParent;

						if(currParent.children.size() > 0) //only when children's size is greater than 0
						{
							rollOver = true; //we can roll over.
						}
						
						break; //if there are still children here " > 0" then we have to stop
					}
					
					index++; //increment by 1
				}

				//so, if there was only 1 child, which we have removed, we can continue. Whenever we hit that, we update rollOver to true.

				if(rollOver)
				{
					break;
				}
			}

			return true;
		}
	}

	public boolean contains(String key)
	{
		String text = "";

		TrieNodeList current = root;

		for(char c : key.toCharArray()) //similar to insert method, I loop through characters of the string and store them into text
		{
			text += c; //text will store character of the string everytime this for loop runs
			
			boolean exists = false; //like in the insert, we set boolean exists = false

			for(TrieNodeList t : current.children) //current.children arraylist
			{
				if(t.value.equals(text)) //if we found
				{
					exists = true; //exists becomes true because we found
					current = t; //current node will become this t
					break;
				}
			}

			if(!exists) //means character doesn't exist
			{
				return false; //therefore, false
			}
		}

		//after loop end
		return true; //if we successfully finish loop processing, with no "return false" inside the loop processing we have matched completely
	}

	public String[] toSortedArray()
	{
		return null;
	}

	public static void main(String[] args)
	{
		TrieDictionary dict = new TrieDictionary();

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

