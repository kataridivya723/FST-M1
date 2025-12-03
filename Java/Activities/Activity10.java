package activities;

import java.util.HashSet;

public class Activity10{
	public static void main(String args[])
	{
		HashSet<String> hs= new HashSet<String>();
		hs.add("Orange");
		hs.add("kiwi");
		hs.add("papaya");
		hs.add("grapes");
		hs.add("guava");
		hs.add("apple");
		System.out.println("Original items in the HashSet:"+hs);
		
		System.out.println("Size of the HashSet: "+hs.size());
		
		System.out.println("Removing apple from the List:"+hs.remove("apple"));
		
		if(hs.remove("Tomato"))
		{
			System.out.println("Tomoto is removed from the HashSet");
		}
		else
		{
			System.out.println("Tomato is not present in HashSet");
		}
		
		System.out.println("Checking if guava present in the HashSet: "+hs.contains("guava"));
		
		System.out.println("Final Updated HashSet:"+hs);
		
		
		
	}
}