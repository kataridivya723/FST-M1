package activities;

public class Activity4 {

	public static void main(String[] args)
	{
		int arr[] = {38,2,59,20,6,11};
		System.out.print("Original Array: ");
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i]+" ");
		int temp=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j]<arr[i])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					
				}
			}
		}
		
		System.out.print("\nSorted Array: ");
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i]+ " ");

	}
	
	

}
