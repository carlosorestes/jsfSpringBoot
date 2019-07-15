package com.easy.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class DayOfWeekResolverForm {

	private int year;
	private int month;
	private int dayOfMonth;
	private String input1;

	private String dayOfWeek;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getInput1() {
		return input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}

	@Override
	public String toString() {
		return "DayOfWeekResolverForm [year=" + year + ", month=" + month + ", dayOfMonth=" + dayOfMonth + ", input1="
				+ input1 + ", dayOfWeek=" + dayOfWeek + "]";
	}

	
}
