package date;

public class Date {
	public int dd;
	public int mm;
	public int yyyy;
	
	private static int limits_noleap[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	private static int limits_leap[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};
	
	private final int MAX_MONTH = 12;
	
	public Date(int dd, int mm, int yyyy) {
			if(mm <= MAX_MONTH && mm > 0){
				if(isLeapYear(yyyy)){
					if( dd <= limits_leap[mm]){
						this.dd = dd;
						this.mm = mm;
						this.yyyy = yyyy;
					}
				}
				else{
					if( dd <= limits_noleap[mm]){
						this.dd = dd;
						this.mm = mm;
						this.yyyy = yyyy;
					}
				}
			}
			else{
				System.out.println("wrong date");
				this.dd = 0;
				this.mm = 0;
				this.yyyy = 0;
			}
		}
	
	private boolean isLeapYear(int year)
	{
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? true : false;
	}
	
	private int[] checkLeapLimits(int year){
		return( isLeapYear(year) ?  limits_leap : limits_noleap);
	}
	
	public String toString()
	{
		return(this.dd + " / " + this.mm + " / " + this.yyyy);
	}
	
	public Date nextDate(Date dat)
	{
		int[] limits = checkLeapLimits(dat.yyyy);
		if(dat.dd < limits[dat.mm])
		{
			Date next = new Date(dat.dd+1, dat.mm, dat.yyyy);
			return(next);
		}
		else if(dat.dd == limits[dat.mm] && dat.mm < 12)
		{
			Date next = new Date(1, dat.mm+1, dat.yyyy);
			return(next);
		}
		else {
			Date next = new Date(1, 1, dat.yyyy+1);
			return(next);
		}
	}
	
	public Date prevDate(Date dat)
	{
		int[] limits = checkLeapLimits(dat.yyyy);
		if(dat.dd == 1)
		{
			Date next = new Date(limits[dat.mm-1], dat.mm-1, dat.yyyy);
			return(next);
		}
		else if(dat.dd == 1 && dat.mm ==1 )
		{
			Date next = new Date(31, 12, dat.yyyy-1);
			return(next);
		}
		else {
			Date next = new Date(dat.dd-1, dat.mm, dat.yyyy);
			return(next);
		}
	}
	
	public Date nextAfterDays(Date d ,int n){
		for(int i=0; i<n; i++){
			Date nextdate= nextDate(d);
			d=nextdate;
		}
		return(d);
	}
	
	public Date prevBeforeDays(Date d ,int n){
		for(int i=0; i<n; i++){
			Date prevdate= prevDate(d);
			d=prevdate;
		}
		return(d);
	}
}
	
	

