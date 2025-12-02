package activities;


public class Activity1 {
	public static void main(String[] args)
	{
		Car TataCar=new Car("Blue","Manual",2014);
		TataCar.displaycharacteristics();
	
		System.out.println("Is Car Moving:"+TataCar.isMoving);
		
	
		TataCar.accelerate();
		System.out.println("Is Car Moving:"+TataCar.isMoving);
		
		TataCar.brake();
        System.out.println("Is Car Moving:"+TataCar.isMoving);
		
		
	}
	
}
		