package activities;

public class Car {

		String colour;
		String transmission;
		int make;
		int tyres;
		int doors;
		boolean isMoving=false;
		
		
	// Car Constructor
		public Car(String colour,String transmission,int make)
		{
			this.colour=colour;
			this.transmission=transmission;
			this.make=make;
			this.tyres=4;
			this.doors=4;
		}
	
	public void displaycharacteristics()
	{
		System.out.println("Colour of the car : "+this.colour);
		System.out.println("Transmisssion     : "+this.transmission);
		System.out.println("Make of the car   : "+this.make);
		System.out.println("Number of tyres   : "+this.tyres);
		System.out.println("Number of doors   : "+this.doors);
	}
	public void accelerate()
	{
		System.out.println("Car is moving forward!");
		this.isMoving=true;
	}
	public void brake()
	{
		System.out.println("Car has stopped!");
		this.isMoving=false;
	
	}
}


