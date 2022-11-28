package com.corejava.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class praparedstatement {

	public static Connection createConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    
    String url = "jdbc:mysql://localhost:3306/city";
    String username= "root";
    String password = "root";
    
    Connection con = DriverManager.getConnection(url,username,password);
    
    return con;
    
	}
	
	public static void  insertRecord() throws ClassNotFoundException, SQLException  {
		
		String query = "insert into city (No,City_Name,State,Code) values (?,?,?,?)";
		
		Connection con = createConnection();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter City Name  :  ");
		String City_Name = sc.nextLine();
		
		System.out.print("Enter State Name :  ");
		String State = sc.nextLine();
		
		System.out.print("Enter City No    :  ");
		float No = sc.nextFloat();
		
		System.out.print("Enter State Code :  ");
		float Code = sc.nextFloat();
		
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setFloat(1, No);
		stmt.setString(2, City_Name);
		stmt.setString(3, State);
		stmt.setFloat(4, Code);
		
		int num = stmt.executeUpdate();
		System.out.println("Data Added Succesfully");
		System.out.println(num+"rows are affected");
	

	}
	
	public static void UpdateRecord() throws ClassNotFoundException, SQLException {
		
	String query = "update city set No=? where Code=?";
	
	Connection con = createConnection();
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter NO   : ");
	float No = sc.nextFloat();
	
    System.out.print("Enter Code : ");
    float Code = sc.nextFloat();
    
    PreparedStatement pstm = con.prepareStatement(query);
    pstm.setFloat(1, No);
    pstm.setFloat(2, Code);
    
    int num = pstm.executeUpdate();
    System.out.println("  Update Succesfully  ");
    System.out.println(num + "row are affected ");
	}	
	
	public static void DeleteRecord() throws ClassNotFoundException, SQLException {
		String query = "delete from city where No=?";
		
		Connection con = createConnection();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter No for delete Row ");
		float No = sc.nextFloat();
		
		PreparedStatement ptm = con.prepareStatement(query);
		ptm.setFloat(1, No);
		
		int num = ptm.executeUpdate();
		System.out.println("Delete Row Succesufully");
		System.out.println(num +"  Rows Are Affected");
		
	}
	public static void FetchAllRecord() throws ClassNotFoundException, SQLException {
		String query = "select * from city";
		Connection con = createConnection();
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(" No          :  "+rs.getInt("No"));
			System.out.println(" City_Name   :  "+rs.getString("City_Name"));
			System.out.println(" State       :  "+rs.getString("State"));
			System.out.println(" Code        :  "+rs.getString("Code"));
			System.out.println("-------------------------");
			
		}
		
		stm.close();
		con.close();
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
}
