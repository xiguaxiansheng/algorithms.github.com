package com.zjj.homework3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Date {
	
	private int month;
	private int day;
	private int year;
	
	//接收日期格式5/22/1939
	public Date(String date) {
		String[] fields = date.split("/");
		month = Integer.parseInt(fields[0]);
		day = Integer.parseInt(fields[1]);
		year = Integer.parseInt(fields[2]);
	}
	
	

	@Override
	public String toString() {
		return String.format("%2d/%2d/%4d",month,day,year);
	}


	public static Date[] readDates(String s) {
		String[] dates = s.split(" ");
		Queue<Date> q = new Queue<Date>(); 

		for(int i = 0;i < dates.length;i++) 
			q.enqueue(new Date(dates[i]));
		
		Date[] results = new Date[dates.length];
		
		for(int j = 0;j < dates.length;j++)
			results[j] = q.dequeue();
		
		return results;
	}

	public static void main(String[] args) {

		String s = "5/22/2017 12/20/1314 4/1/1996";
		Date[] results = Date.readDates(s);
		for(int i = 0;i < results.length;i++)
			StdOut.println(results[i]);

	}

}
