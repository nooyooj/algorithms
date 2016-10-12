import java.util.*;
import java.lang.*;

class TrieNode extends TrieComparableKeyValuePair
{
	TrieNode left;
	TrieNode right;
	TrieNode parent;
}

interface TrieComparable extends Comparable
{
	public int getBit(int var);
	public String getBitString();
}

class TrieComparableKeyValuePair
{
	TrieComparable key;
	Object value;

	TrieComparableKeyValuePair()
	{
		this.key = null;
		this.value = null;
	}

	TrieComparableKeyValuePair(TrieComparable trieComparable, Object object)
	{
		this.key = trieComparable;
		this.value = object;
	}
}

class TrieNodeList extends TrieComparableKeyValuePair 
{
	public ArrayList<TrieNodeList> children; 
	
	public TrieNodeList parent;

	public TrieNodeList()
	{
		this.children = new ArrayList<TrieNodeList>(); 
	}
}

public class TrieDictionary 
{
	private TrieNodeList root; 
	
    public TrieDictionary() 
    {
		root = new TrieNodeList();
		root.value = "";
    }

    public void clear() 
	{
	    root = new TrieNodeList();
		root.value = "";
	}
	
	public boolean insert(String key) 
	{
		if(contains(key) == true) 
		{
			return false;
		}

		else 
		{
			String text = ""; 

			TrieNodeList currParent = root; 

			for(char c: key.toCharArray()) 
			{
				text += c; 

				TrieNodeList currNode = new TrieNodeList(); 
				
				currNode.value = text; 
				
				boolean exists = false; 

				for(TrieNodeList t : currParent.children) 
				{
					if(t.value.equals(text)) 
					{
						exists = true; 
						currParent = t; 
						break;
					}
				}

				if(!exists) 
				{
					currNode.parent = currParent; 
					currParent.children.add(currNode); 
					int last = currParent.children.size() - 1; 
					currParent = currParent.children.get(last); 
				}
			}

			return true;
		}
	}
    
	public boolean delete(String key)
	{
		if(contains(key) == false)
		{
			return false; 
		}

		else 
		{
			String text = ""; 

			TrieNodeList current = root; 

			for(char c : key.toCharArray())
			{
				text += c; 

				for(TrieNodeList t : current.children) 
				{
					if(t.value.equals(text))
					{
						current = t; 
						break;
					}
				}

			}

			while(current != root) 
			{
				TrieNodeList currParent = current.parent;
					
				int index = 0;
				
				boolean rollOver = false;

				for(TrieNodeList t : currParent.children)
				{
					if(t.value.equals(current.value)) 
					{
						currParent.children.remove(index);
						current = currParent;

						if(currParent.children.size() > 0) 
						{
							rollOver = true;
						}
						
						break; 
					}
					
					index++; 
				}

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

		for(char c : key.toCharArray()) 
		{
			text += c; 
			
			boolean exists = false; 

			for(TrieNodeList t : current.children) 
			{
				if(t.value.equals(text)) 
				{
					exists = true; 
					current = t; 
					break;
				}
			}

			if(!exists) 
			{
				return false; 
			}
		}
		
		return true; 
	}

	public static void main(String[] args)
	{
		TrieDictionary dict = new TrieDictionary();

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

		System.out.println("checking \"hello\" in trie dictionary...");
		if(dict.contains("hello"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"hell\" in trie...");
		if(dict.contains("hell"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		System.out.println("checking \"hel\" in trie...");
		if(dict.contains("hel"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"my\" in trie...");
		if(dict.contains("my"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"name\" in trie...");
		if(dict.contains("name"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"nam\" in trie...");
		if(dict.contains("nam"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"eric\" in trie...");
		if(dict.contains("eric"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"Jooyoon\" in trie...");
		if(dict.contains("Jooyoon"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"Jooy\" in trie...");
		if(dict.contains("Jooy"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println();
		
		System.out.println("deleting \"hello\" from trie...");
		dict.delete("hello");
	
		System.out.println();
		System.out.println("checking \"hello\" in trie…");
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

