package activities;
import java.util.Arrays;

public class Activity2 {
		
	public static boolean checkSumOfTens(int arr[])
	{
	
		//int num=0;
		int sum=0;
		for(int num:arr)
		{
		if(num==10)
		{
			
		sum=sum+10;
		
		}
		

	}return sum==30;
	}
	
	
	public static void main(String[] args) 
	{
		
		int array[]= {10,77,10,54,-11,10};
		System.out.println("Original Array: "+ Arrays.toString(array));
		System.out.println("Result: "+checkSumOfTens(array));
	}
}