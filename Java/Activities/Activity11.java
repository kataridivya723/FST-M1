package activities;

import java.util.HashMap;

public class Activity11 {

	public static void main(String[] args) {
		HashMap<Integer, String> colours = new HashMap<Integer, String>();
	
		colours.put(1, "white");
		colours.put(2, "black");
		colours.put(3, "green");
		colours.put(4, "purple");
		colours.put(5, "gray");
		colours.put(6, "violet");
		
		System.out.println("All Colors in the HashMap Originally: "+colours);
		colours.remove(4);
		System.out.println("After removing purple from the HashMap: "+colours);
		
		if(colours.containsValue("green"))
		{
			System.out.println("green exists in HashMap");
		}
		else
		{
			System.out.println("green is not in the HashMap");
		}
		
		System.out.println("Number of pairs in the HashMap: "+colours.size());
	}

}
