package activities;

class CustomException extends Exception
{
	 private String message=null;
	 public CustomException(String message)
	 {
		 this.message=message;
	 }
	 @Override
	public String getMessage()
	{
	 return message;
	}
}

public class Activity8 {

	public static void main(String[] args) {
		try {
		Activity8.exceptionTest("will print to console"); 
		
		Activity8.exceptionTest(null);
		Activity8.exceptionTest("will not print anything on console");
		}
		catch(CustomException mae){
			System.out.println("Inside catch Block: "+mae.getMessage());
		}
	}
		
		private static void exceptionTest(String str) throws CustomException {
			if(str== null)
			{
				throw new CustomException("String value is null");
			}
			else
			{
				System.out.println(str);
			}
				
		}
}