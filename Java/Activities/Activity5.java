package activities;

public class Activity5 {

	public static void main(String[] args) {
		String title="The title of the Novel is : Yandamoori";
		Book newNovel=new MyBook();
		newNovel.setTitle(title);
		System.out.println(newNovel.getTitle());
	}

}


abstract class Book
{
	String title;
	abstract void setTitle(String s) ;
	String getTitle()
	{
		return title;
	}
}

 class MyBook extends Book
{
	 public void setTitle(String s)
	 {
		 title=s;
	 }
}