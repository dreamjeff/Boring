package micro;

import common.Go;

public class Day_of_Week implements Go {

	@Override
	public void run() {
		// TODO Auto-generated method stub
//https://leetcode.com/discuss/interview-question/398047/
		System.out.print(work("Mon", 8));
		
	}

	private String work(String s, int k) {
		int day = toDay(s);
		day = (day+k)%7;
		return toDayString(day);
	}
	
	private int toDay(String s) {
		switch (s){
		case "Sun": return 0;
		case "Mon": return 1;
		case "Tue": return 2;
		case "Wed": return 3;
		case "Thu": return 4;
		case "Fri": return 5;
		case "Sat": return 6;
		}
		return 0;
	}
	
	private String toDayString(int i) {
		switch (i){
		case 0 : return "Sun";
		case 1 : return "Mon";
		case 2 : return "Tue";
		case 3 : return "Wed";
		case 4 : return "Thu";
		case 5 : return "Fri";
		case 6 : return "Sat";
		}
		return "";
	}
}
