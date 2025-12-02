package activities;

public class Activity3 {

	public static void main(String[] args) {
		double seconds=1000000000;
		
		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;
		
		System.out.println("The Age on Mercury: "+seconds/EarthSeconds/MercurySeconds);
		System.out.println("The Age on Venus: "+seconds/EarthSeconds/VenusSeconds);
		System.out.println("The Age on Earth: "+seconds/EarthSeconds);
		System.out.println("The Age on Mars: "+seconds/EarthSeconds/MarsSeconds);
		
		System.out.println("The Age on Jupiter: "+seconds/EarthSeconds/JupiterSeconds);
		System.out.println("The Age on Saturn: "+seconds/EarthSeconds/SaturnSeconds);
		System.out.println("The Age on Uranus: "+seconds/EarthSeconds/UranusSeconds);
		System.out.println("The Age on Neptune: "+seconds/EarthSeconds/NeptuneSeconds);

	}

}
