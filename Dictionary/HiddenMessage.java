import java.util.*;
import java.lang.*;
public class HiddenMessage 
{
	static char[] ptext; 
	static char[] pmessage; 
	
	public static void main(String[] args)
	{
		HiddenMessage message = new HiddenMessage();

		System.out.println("-----------------------------------");
		System.out.println("Test 1:");
		char[] testText1 = {'a'};
		char[] testMessage1 = {'a'};
		message.preProcessText(testText1);
		message.findHiddenMessage(testMessage1);
		System.out.println("-----------------------------------");

		System.out.println("-----------------------------------");
		System.out.println("Test 2:");
		char[] testText2 = {'a', 'b', 'c', 'd'};
		char[] testMessage2 = {'a', 'b', 'c', 'd'};
		message.preProcessText(testText2);
		message.findHiddenMessage(testMessage2);
		System.out.println("-----------------------------------");

		System.out.println("-----------------------------------");
		System.out.println("Test 3:");
		char[] testText3 = {'a', 'b', 'c', 'd'};
		char[] testMessage3 = {'a', 'b', 'd'};
		message.preProcessText(testText3);
		message.findHiddenMessage(testMessage3);
		System.out.println("-----------------------------------");
	
		System.out.println("-----------------------------------");
		System.out.println("Test 4:");
		char[] testText4 = {'q', 'h', 'e', 'h', 'w', 'e', 'r', 't', 'l', 'y', 'l', 'l', 'o'};
		char[] testMessage4 = {'h', 'e', 'l', 'l', 'o'};
		message.preProcessText(testText4);
		message.findHiddenMessage(testMessage4);
		System.out.println("-----------------------------------");

		System.out.println("-----------------------------------");
		System.out.println("Test 5:");
		char[] testText5 = {'x', 'a', 'x', 'c', 'x', 'b', 'x', 'a', 'x', 'x', 'b', 'x', 'c', 'x', 'x', 'x', 'x'};
		char[] testMessage5 = {'a', 'b', 'c'};
		message.preProcessText(testText5);
		message.findHiddenMessage(testMessage5);
		System.out.println("-----------------------------------");

		System.out.println("-----------------------------------");
		System.out.println("Test 6:");
		char[] testText6 = {'x', 'c', 'x', 'b', 'x', 'x', 'a', 'b', 'x', 'x'};
		char[] testMessage6 = {'a', 'b', 'c'};
		message.preProcessText(testText6);
		message.findHiddenMessage(testMessage6);
		System.out.println("-----------------------------------");
	}
	
	public void preProcessText(char[] text) 
	{
		if(text == null) 
		{
			System.out.print("text is empty");
		}

		ptext = new char[text.length]; 

		for(int i = 0; i < text.length; i++) 
		{
			ptext[i] = text[i]; 
		}
	}

	public int[] findHiddenMessage(char[] message) 
	{
		if(message == null) 
		{
			return null; 
		}
		
		System.out.println();
		System.out.print("ptext: ");
		for(int ti = 0; ti < ptext.length; ti++)
		{
			System.out.print(ptext[ti]);
		}
		System.out.println();
		System.out.println();

		pmessage = new char[message.length]; 

		for(int mi = 0; mi < message.length; mi++) 
		{
			pmessage[mi] = message[mi]; 
		}
		
		int[] num = new int[message.length]; 
		
		System.out.print("pmessage: ");
		for(int p = 0; p < pmessage.length; p++)
		{
			System.out.print(pmessage[p]);
		}
		System.out.println();
		System.out.println();

		/*---------------------------------------------------------------------------------*/
		boolean isFound = false; 

		int index = 0; 
		for(int i = 0; i < pmessage.length; i++) 
		{
			isFound = false;
			
			for(int j = index; j < ptext.length && isFound == false; j++) 
			{
				if(pmessage[i] == ptext[j]) 
				{
					System.out.println("message at " + i + " matches with text at " + j); 
					num[i] = j; 
					
					isFound = true; 
				}
				
				index++; 
			}

			if(isFound == false) 
			{
				return null; 
			}
		}
		/*---------------------------------------------------------------------------------*/

		return num;
	}
}


