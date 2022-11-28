package com.corejava.preparedstatement;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionProvider {
	



	public static Connection createConnection () throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/data";
		String username = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url,username,password);
		
		return con;
	}

	

	public static void insertRecord() throws ClassNotFoundException, SQLException {
		
		
		String query = "insert into  data (name,city,marks,id) values (?,?,?,?)";
		Connection con= createConnection();
		
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name   : ");
		String name = sc.nextLine();
		
		System.out.print("Enter city   : ");
		String city = sc.nextLine();
		
		System.out.print("Enter marks  : ");
		float marks = sc.nextFloat();
		
		
		System.out.print("Enter id     : ");
		float id = sc.nextFloat();
		
		
	
		
		PreparedStatement stm = con.prepareStatement(query);
		stm.setString(1, name);
		stm.setString(2, city);
		stm.setFloat(3, marks);
		stm.setFloat(4, id);
	
		int num = stm.executeUpdate();
	
		
		System.out.println("student data succesfully added ..");
		System.out.println(num+ "rows are affected..");
		con.close();
		stm.close();
		
	}
	public static void updateRecord() throws ClassNotFoundException, SQLException {
		String query = "update data set name=? where id=? ";
		Connection con = createConnection();
		
		Scanner sc = new Scanner(System.in) ;
		
		System.out.print("Enter  name         :  ");
		String name = sc.nextLine();
		
		System.out.print("Enter Student Id    :  ");
		float id = sc.nextFloat();
		
		PreparedStatement stm = con.prepareStatement(query);
		stm.setString(1, name);
		stm.setFloat(2, id);
		 
		int num = stm.executeUpdate();
		System.out.println("student data succesfully upadate");
		System.out.println(num+"rows are affected");
	
		
}
	public static void deleteRecord() throws ClassNotFoundException, SQLException {
		String query = "delete from data where marks= ?";
		Connection con = createConnection();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter marks  : ");
		float marks = sc.nextFloat();
		
		PreparedStatement stm = con.prepareStatement(query);
		stm.setFloat(1, marks);
		
		int num = stm.executeUpdate();
		System.out.println("Student data succesfully delated ");
		System.out.println(num+ "rows are affected");
	}
	public static void FetchAllRecords() throws ClassNotFoundException, SQLException {
		String query = "select * from data";
		
		Connection con = createConnection();
		
		Statement stm = con.createStatement();
		ResultSet res = stm.executeQuery(query);
		
		while (res.next()) {
			System.out.println("Person name is  : " + res.getString("name"));
			System.out.println("Enter marks     : "+ res.getInt("marks"));
			System.out.println("Enter city      : "+ res.getString("city"));
			System.out.println("Enter id        : "+ res.getInt("id"));
			System.out.println("------------------------------------------------------");
		}
		stm.close();
		res.close();
	}
	
	

}
