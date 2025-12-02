package activities;



//Interface 1
interface BicycleParts
{
	public int tyres=2;
	public int maxSpeed=25;
}

//Interface 2
interface BicycleOperations
{
	public void applyBrake(int Decrement);
	public void speedUp(int Increment);
}

//Implementing 2 interfaces
class Bicycle implements BicycleParts,BicycleOperations
{
	public int gears;
	public int currentSpeed;
	public Bicycle(int gears, int currentSpeed)
	{
		this.gears=gears;
		this.currentSpeed=currentSpeed;
	}
	public void applyBrake(int Decrement)
	{	currentSpeed -= Decrement;
		System.out.println("current speed of Bicycle: "+currentSpeed);
		
		//System.out.println("current speed after break: "+currentSpeed);
	}
	public void speedUp(int Increment)
	{
		currentSpeed += Increment;
		System.out.println("current speed of Bicycle: "+currentSpeed);
		
		//System.out.println("current speed after break: "+currentSpeed);
		
	}
	public String bicycleDesc()
	{
		return("No.of gears are: "+gears+"\nSpeed of bycycle: "+maxSpeed);
	}
	
	}


class MountainBike extends Bicycle
{
	public int seatHeight;
	public MountainBike(int gears, int currentSpeed, int startHeight)
	{
		super(gears,currentSpeed);
		seatHeight=startHeight;
		
	}
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	public String bicycleDesc()
	{
		return (super.bicycleDesc()+"\nSeat Height is "+seatHeight);
	}
	
}

public class Activity7 {

	public static void main(String[] args) {
    MountainBike mb = new MountainBike(3, 0, 25);
    System.out.println(mb.bicycleDesc());
    mb.speedUp(20);
    mb.applyBrake(5);
}
}