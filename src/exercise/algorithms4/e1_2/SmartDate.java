package exercise.algorithms4.e1_2;

public class SmartDate {

	private final int year;
	private final int month;
	private final int day;
	
	public SmartDate(int year, int month, int day) throws Exception{
		if(year < 1970){
			throw new Exception("year should greater than 1970.");
		}
		if(month < 1 || month > 12){
			throw new Exception("month should between 1 and 12.");
		}
		int lastDay = 0;
		if(month == 2){
			if(isLeapYear(year)){
				lastDay = 29;
			}else{
				lastDay = 28;
			}
		}else if(month == 8){
			lastDay = 31;
		}else{
			if(month % 2 == 1){
				lastDay = 31;
			}else{
				lastDay = 30;
			}
		}
		if(day < 1 || day > lastDay){
			throw new Exception("day should between 1 and " + lastDay + ".");
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int year(){
		return this.year;
	}
	public int month(){
		return this.month;
	}
	public int day(){
		return this.day;
	}
	/**
	 * ²ÌÀÕ£¨Zeller£©¹«Ê½ w=y+[y/4]+[c/4]-2c+[26(m+1)/10]+d-1
	 * @return w % 7
	 */
	public int dayOfTeWeek(){
		int c = year / 100;
		int y = year % 100;
		int m = month;
		if(m == 1){
			m = 13;
		}
		if(m == 2){
			m = 14;
		}
		int w = y + y / 4 + c / 4 - 2 * c + 26 * (m + 1) / 10 + day - 1;
		while(w < 0){
			w = w + 7;
		}
		return w % 7 ; //== 0 ? 7 : w % 7;
	}
	
	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}

	private boolean isLeapYear(int year){
		return (year % 100 == 0 ? year % 400 == 0 : year % 4 == 0 );
	}
}
