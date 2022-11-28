package com.corejava.preparedstatement;

import java.sql.SQLException;
import java.util.Scanner;

public class Main3 extends praparedstatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	
	
	while ( true) {
		System.out.println("------Enter New Data--------");
	
		
		System.out.println();
		Scanner sc = new Scanner(System.in);
		float ch = sc.nextFloat();
		
		if(ch==1) {
				praparedstatement.insertRecord();
				
		}else if (ch==2){
			
		  UpdateRecord();
		}else if (ch==3) {
			DeleteRecord();
		}else if (ch==4) {
			FetchAllRecord();
		}else if (ch==5) {
			break;
		}
	
}
	}
}