package com.corejava.preparedstatement;

import java.sql.SQLException;
import java.util.Scanner;

public class main extends  ConnectionProvider {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	while(true) {
		System.out.println();
		System.out.println("----------------Student Management System----------------");
		System.out.println("             1  : List of data ");
		System.out.println("             2  : Add New Data");
		System.out.println("             3  : Updare Person name");
		System.out.println("             4  : Delete the record");
		System.out.println("             5  : Exit");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Any key  :  ");
		int ch =sc.nextInt();
		System.out.println();
		
		
	if(ch==1) {
		FetchAllRecords();
	} else if (ch==2){
		insertRecord();
	}else if (ch==3) {
		updateRecord();
	}else if (ch==4) {
	   deleteRecord();
	}else if (ch==5) {
		break;
	}
	
	
		}
	
	}
}
