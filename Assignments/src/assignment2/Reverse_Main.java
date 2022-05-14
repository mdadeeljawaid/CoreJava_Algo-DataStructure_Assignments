package assignment2;

public class Reverse_Main{
	//function to reverse the string
	public static void reverse(StringBuffer str){
		// Creating a stack of capacity
		// equal to length of string
		int n = str.length();
		Reverse_Stack obj = new Reverse_Stack(n);

		// Pushing all characters of string
		// to stack
		int i;
		for (i = 0; i < n; i++)
			obj.push(str.charAt(i));

		// Pop all characters of string
		// and put them back to str
		for (i = 0; i < n; i++)
		{
			char ch = obj.pop();
			str.setCharAt(i,ch);
		}
	}

	//driver function
	public static void main(String args[])
	{
		//create a new string
		StringBuffer s= new StringBuffer("EXPERIMENT");

		//call reverse method
		reverse(s);

		//print the reversed string
		System.out.println("Reversed string of EXPERIMENT is : " + s);
	}
}