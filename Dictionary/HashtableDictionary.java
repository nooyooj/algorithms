import edu.gwu.algtest.*;
import java.util.*;
import java.lang.*;

public class HashtableDictionary implements StringDictionaryAlgorithm
{

	public String getName(){return "HashtableDictionary by Jooyoon Byun";}
	public void setPropertyExtractor(int algID,edu.gwu.util.PropertyExtractor prop){}

	public void clear()
	{
		ht.clear(); //clears the hashtable
	}
	
	static Hashtable<String, String> ht = new Hashtable<String, String>(); //creating a hashtable globally so I can use this in any methods
	
	public boolean insert(String key) //inserting key into hashtable
	{
		boolean result = false; //initialize result with false

		if(!ht.contains(key)) //if the hashtable doesn't have key in the table
		{
			ht.put(key, key); //the it means we can put key string into the table
			result = true; //result becomes true because we have to return true when we added a key
		}

		else //otherwise
		{
			result = false; //if hashtable already has that key, then don't add
		}
		
		return result; //returning result
	}

	public boolean delete(String key) //delete method will delete string from the hashtable
	{
		boolean result = false; //initializing result with false

		if(ht.contains(key)) //if the table contains the key, then it means there is a key that can be deleted.
		{
			result = true; //therefore, result becomes true
			ht.remove(key); //then it removed the key from table
		}

		else //otherwise
		{
			result = false; //there is no key that can be removed, so result becomes false
		}

		return result; //returning result
	}

	public boolean contains(String key) //contain method will return true if table contains key and false if table doesn't
	{
		boolean result = false; //result initialized to false

		if(ht.contains(key)) //if table contains key
		{
			result = true; //then true
		}

		else //if table doesn't
		{
			result = false; //result becomes false
		}

		return result; //returning result
	}

	public String[] toSortedArray() //sorting the array, but not required for this assignment
	{
		ArrayList<String> al = new ArrayList<String>(ht.values());	
		String[] result = new String[al.size()];
		result = al.toArray(result);

		return result;
	}

	public static void main(String[] args)
	{
		HashtableDictionary dict = new HashtableDictionary();

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

