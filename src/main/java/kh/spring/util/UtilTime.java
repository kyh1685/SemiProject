package kh.spring.util;

import java.util.Calendar;

public class UtilTime {
	public static String endDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String date = year + "-" + month + "-" + day;
		return date;
	}	
	public static String startDate() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)-1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if(month < 0) {
			year -=1;
			if(month == -1) {
				month = 11;
			}else if(month == 0) {
				month = 12;
			}
		}
		String date = year + "-" + month + "-" + day;
		return date;
	}
	public static String Check(int year, int month, int day) {
		if(year%4 ==0 && (year %100!=0 || year%400==0)){//윤년
			if((month % 2 == 0 && month < 7)||(month % 2 == 1 && month > 7)) {
				if(month == 02) {
					
					if(day == 30) {
						day=01;
						month=03;
					}
				}else { 
					if(day==31) {
						day=01;
						month +=1;
						}
					}
			}else {
				if(day == 32) {
					if(month == 12) {
						day = 01;
						month = 01;
						year +=1;
					}else {
					day=01;
					month +=1;
					}
				}
			}
		}else {//윤년 아님
			if((month % 2 == 0 && month < 7)|| (month % 2 == 1 && month > 7)) {
				if(month == 02) {
					if(day == 29) {
						day=01;
						month=03;
					}
				}else { 
					if(day==31) {
						day=01;
						month +=1;
					}
				}
			}else {
				if(day == 32) {
					if(month == 12) {
						day = 01;
						month = 01;
						year +=1;
					}else {
					day=01;
					month +=1;
					}
				}
			}
		}
		String endDate = year +"-"+ month +"-"+ day;
		return endDate;
	}
}
