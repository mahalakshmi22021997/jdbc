package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String dbURL="jdbc:mysql://localhost:3306/demodb";
		String username="root";
		String password="pass";
		Connection connection=DriverManager.getConnection(dbURL,username,password);
		return connection;
	}
	public static void insertRecord() throws ClassNotFoundException, SQLException{
		System.out.println("connected successfully");
		String SQL="insert into Customer values(?,?,?,?)"; //parameterized query
		int inp_id=0;
		String inp_name=" ";
		String 	inp_city=" ";
		double inp_add=0.0;
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter id: ");
		inp_id=scanner.nextInt();
		System.out.print("Enter name:");
		inp_name=scanner.next();
		System.out.print("Enter city :");
		inp_city=scanner.next();
		System.out.print("Enter outstanding amount: ");
		inp_add=scanner.nextDouble();
		Connection connection = createConnection();
		PreparedStatement statement=connection.prepareStatement(SQL);
		statement.setInt(1, inp_id);
		statement.setString(2, inp_name);
		statement.setString(3, inp_city);
		statement.setDouble(4, inp_add);
		int r=statement.executeUpdate();
		System.out.println(r+"rows inserted");
		statement.close();
		connection.close();
		
	}
	public static void updateRecord() throws ClassNotFoundException, SQLException{
		System.out.println("connected successfully");
		System.out.print("Enter the id you want to update: ");
		Scanner scanner=new Scanner(System.in);
		int upd_id=scanner.nextInt();
		String SQL="update  Customer set c_amt=c_amt+? where c_id=?";
		System.out.print("Enter the amount you want to update: ");
		double upd_amt = scanner.nextDouble();
		Connection connection = createConnection();
		PreparedStatement statement=connection.prepareStatement(SQL);
		statement.setDouble(1, upd_amt); //1 means 
		statement.setInt(2, upd_id);
		int r=statement.executeUpdate();
		System.out.println(r+"rows updated");
		statement.close();
		connection.close();
		
	}
	public static void deleteRecord() throws ClassNotFoundException, SQLException{
		System.out.println("connected successfully");
		String SQL="delete from Customer  where c_id=?";
		System.out.print("Enter id you want to delete: ");
		Scanner scanner=new Scanner(System.in);
		int del_id = scanner.nextInt();
		Connection connection = createConnection();
		PreparedStatement statement=connection.prepareStatement(SQL);
		statement.setInt(1, del_id);
		int r=statement.executeUpdate();
		System.out.println(r+"rows deleted");
		statement.close();
		connection.close();
		
	}
	public static void displayAllRecords() throws ClassNotFoundException, SQLException{
		Connection connection = createConnection();
		String SQL="select * from Customer";
		Statement statement=connection.createStatement();
		statement.executeQuery(SQL);
		ResultSet rs=statement.executeQuery(SQL);
		while(rs.next()){  //return boolean value
		
		System.out.print(rs.getInt(1)+"\t"); //COLUMN INDEX
		System.out.print(rs.getString(2)+"\t");
		System.out.print(rs.getString(3)+"\t");
		System.out.println(rs.getDouble(4)+"\t");
		}
		rs.close();
		statement.close();
		connection.close();
	}
	public static void displayOneRecords() throws ClassNotFoundException, SQLException{
		Connection connection = createConnection();
		String SQL="select * from Customer where c_id=3";
		Statement statement=connection.createStatement();
		statement.executeQuery(SQL);
		ResultSet rs=statement.executeQuery(SQL);
		if(rs.next()){
		System.out.print(rs.getInt(1)+"\t"); //COLUMN INDEX
		System.out.print(rs.getString(2)+"\t");
		System.out.print(rs.getString(3)+"\t");
		System.out.println(rs.getDouble(4)+"\t");
		}
		rs.close();
		statement.close();
		connection.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		// TODO Auto-generated method stub
		//insertRecord();
		deleteRecord();
		//updateRecord();
	
	}

}
