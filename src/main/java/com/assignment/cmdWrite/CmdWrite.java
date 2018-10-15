package com.assignment.cmdWrite;

import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CmdWrite {

	public void writeToFile(List<String> contents, FileWriter out) throws Exception{
		String id,fname,lname,gender,DOB;
		boolean isMarried=false;
		gender="";
		
		int length1=contents.get(1).length();
		int length2=contents.get(2).length();
		id=contents.get(0);
		lname=contents.get(1).substring(0,1).toUpperCase()+contents.get(1).substring(1,length1).toLowerCase();
		fname=contents.get(2).substring(0,1).toUpperCase()+contents.get(2).substring(1,length2).toLowerCase();
		
		
		SimpleDateFormat simple2 = new SimpleDateFormat("dd/MM/YYYY");
		
		
		Date date= dateFormat(contents.get(3));
		
		DOB=simple2.format(date);
				
		if(contents.get(4).toLowerCase().equals("married")) {
			isMarried=true;
		}
		if(contents.get(4).toLowerCase().equals("yes")) {
			isMarried=true;
		}
		
		if(contents.get(5).toLowerCase().equals("male")) {
			gender="M";
		}
		else if(contents.get(5).toLowerCase().equals("female"))  {
			gender="F";
		}
		
		out.write("insert into customers(id, first_name, last_name, gender, date_of_birth, marital_status) values("+id+", '"+fname+"','"+lname+"','"+gender+"','"+DOB+"','"+isMarried+"');"+"\n");
		
	}
	
	static List<String> formatStrings=Arrays.asList("yyyy-MM-dd","dd MMM yyyy");
	
	public Date dateFormat(String dateString) {
		
		for(String formatString:formatStrings) {
			try
			{
				return new SimpleDateFormat(formatString).parse(dateString);
			}
			catch(ParseException e) {
				
			}
			
		}
		return null;
		
	}
}
