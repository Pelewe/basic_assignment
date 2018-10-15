package com.assignment;

import java.io.File;

import com.assignment.cmdRead.*;


public class Assignment {
	
	public static void main(String[] arg) {
		//READ INPUTS
		
		String Filename=arg[0];
		int firstId=Integer.parseInt(arg[1]);
		
		
		CmdRead read=new CmdRead();
		File file=read.readFile(Filename,firstId);
		
		System.out.print(file);
		
	}

}
