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
public class HashtableDictionary
{
	public void clear()
	{
		ht.clear(); 
	}
	
	static Hashtable<String, String> ht = new Hashtable<String, String>(); 
	
	public boolean insert(String key) 
	{
		boolean result = false; 

		if(!ht.contains(key)) 
		{
			ht.put(key, key); 
			result = true; 
		}

		else 
		{
			result = false; 
		}
		
		return result; 
	}

	public boolean delete(String key) 
	{
		boolean result = false; 

		if(ht.contains(key))
		{
			result = true; 
			ht.remove(key); 
		}

		else 
		{
			result = false; 
		}

		return result; 
	}

	public boolean contains(String key) 
	{
		boolean result = false; 

		if(ht.contains(key))
		{
			result = true; 
		}

		else 
		{
			result = false; 
		}

		return result; 
	}

	public static void main(String[] args)
	{
		HashtableDictionary dict = new HashtableDictionary();

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

		System.out.println("checking \"hello\" in hashtable...");
		if(dict.contains("hello"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"hell\" in hashtable...");
		if(dict.contains("hell"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		System.out.println("checking \"hllo\" in hashtable...");
		if(dict.contains("hllo"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"my\" in hashtable...");
		if(dict.contains("my"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"name\" in hashtable...");
		if(dict.contains("name"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"is\" in hashtable...");
		if(dict.contains("is"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"eric\" in hashtable...");
		if(dict.contains("eric"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"Jooyoon\" in hashtable...");
		if(dict.contains("Jooyoon"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println();
		
		System.out.println("deleting \"hello\" from hashtable...");
		dict.delete("hello");
	
		System.out.println();
		System.out.println("checking \"hello\" in hashtable...");
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


