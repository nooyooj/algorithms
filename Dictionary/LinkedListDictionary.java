import edu.gwu.algtest.*;
import java.util.*;
import java.lang.*;

public class LinkedListDictionary implements StringDictionaryAlgorithm
{
	public String getName(){return "LinkedListDictionary by Jooyoon Byun";}
	public void setPropertyExtractor(int algID,edu.gwu.util.PropertyExtractor prop){}

	public void clear()
	{
		ll.clear(); //clear() method will clear the LinkedList
	}
	
	static LinkedList<String> ll = new LinkedList<String>(); //creating linkedlist that will be used globally
	
	public boolean insert(String key) //beginning of the insert method that will insert the key that is passed in as parameter
	{
		boolean result = false; //initiate the result as false

		if(!ll.contains(key)) //if the linkedlist ll doesn't contain "key", it means there is no such word in ll.
		{
			ll.add(key); //then we have to add a key into the linkedlist.
			result = true; //true because we added the string into the linkedList above, so this becomes true
		}

		else //if ll already contains that word, then, return false
		{
			result = false; //return false
		}
		
		return result; //returns the result either true or false
	}

	public boolean delete(String key) //delete method will delete the string from the linked list
	{
		boolean result = false; //initiate this with false because we haven't checked something yet

		if(ll.contains(key)) //if ll contains the string meaning if there is a key matches in a string in a linked list
		{
			result = true; //it means we can remove it. Therefore, true.
		
			ll.remove(key); //remove the key
		}

		else //if there is no word, it means we can't delete.
		{
			result = false; //so result becomes false
		}

		return result; //return the result
	}

	public boolean contains(String key) //contains method will check if the key is in the linkedlist
	{
		boolean result = false; //initiate with false

		if(ll.contains(key)) //if the linkedlist contains the key
		{
			result = true; //then return true
		}

		else //if not,
		{
			result = false; //return false
		}

		return result; //return the result. This result will be called in delete and insert methods above.
	}

	public String[] toSortedArray() //sorting the array. The assignment doesn't require toSortedArray() but I did this for fun
	{
		String[] result = ll.toArray(new String[ll.size()]);
	
		Arrays.sort(result);

		return result;
	}

	public static void main(String[] args)
	{
		LinkedListDictionary dict = new LinkedListDictionary();

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

