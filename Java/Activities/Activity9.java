package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		ArrayList<String> myList= new ArrayList<String>();
		myList.add("Green");
		myList.add("White");
		myList.add("Pink");
		myList.add("Blue");
		myList.add("Violet");
		
		myList.add(4, "Red");
		myList.add(1, "Yellow");
		
		System.out.println("Printing all the List: "+myList);
	
//		for(String s: myList)
//	{			
//			System.out.println(s);
//	}
		System.out.println("3rd name in the list is: "+myList.get(2));
		System.out.println("Is Purple present in the list:"+myList.contains("Purple"));
		System.out.println("Size of the ArrayList: "+myList.size());
		myList.remove(5);
		System.out.println("New Size of the ArrayList:"+myList.size());
		
		
	}

}