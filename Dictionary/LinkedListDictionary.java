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

public class LinkedListDictionary 
{
	public void clear()
	{
		ll.clear(); 
	}
	
	static LinkedList<String> ll = new LinkedList<String>(); 
	
	public boolean insert(String key)
	{
		boolean result = false;

		if(!ll.contains(key)) 
		{
			ll.add(key); 
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

		if(ll.contains(key)) 
		{
			result = true;
		
			ll.remove(key);
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

		if(ll.contains(key)) 
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
		LinkedListDictionary dict = new LinkedListDictionary();

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

		System.out.println("checking \"hello\" in linked list...");
		if(dict.contains("hello"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"hell\" in linked list...");
		if(dict.contains("hell"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
		
		System.out.println("checking \"hllo\" in linked list...");
		if(dict.contains("hllo"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"my\" in linked list...");
		if(dict.contains("my"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"name\" in linked list...");
		if(dict.contains("name"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"is\" in linked list...");
		if(dict.contains("is"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"eric\" in linked list...");
		if(dict.contains("eric"))
		{
			System.out.println("true");
		}

		else
		{
			System.out.println("false");
		}

		System.out.println("checking \"Jooyoon\" in linked list...");
		if(dict.contains("Jooyoon"))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}

		System.out.println();
		
		System.out.println("deleting \"hello\" from linked list...");
		dict.delete("hello");
	
		System.out.println();
		System.out.println("checking \"hello\" in linked list...");
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



