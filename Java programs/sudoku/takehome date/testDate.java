package date;

public class testDate {
	public static void main(String[] args)
	{
		int k=7;
		Date d=new Date(30,4,2023);
		System.out.println("Date: "+d.toString());
		d.getDayOfWeek(d);
		System.out.println("Next date: "+ d.nextDate(d).toString());
		System.out.println("Previous date: "+d.prevDate(d).toString());
		System.out.println("Date after "+k+" days: "+d.nextAfterDays(d, k).toString());
		System.out.println("Date before "+ k +" days: "+d.prevBeforeDays(d, k).toString());
	}

}
