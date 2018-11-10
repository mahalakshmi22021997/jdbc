package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		String SQL="insert into Customer values(6,'lakki traders','dubai',13000.70)";
		Connection connection = createConnection();
		Statement statement=connection.createStatement();
		int r=statement.executeUpdate(SQL);
		System.out.println(r+"rows inserted");
		statement.close();
		connection.close();
		
	}
	public static void updateRecord() throws ClassNotFoundException, SQLException{
		System.out.println("connected successfully");
		String SQL="update  Customer set c_amt=c_amt+200 where c_id=1";
		Connection connection = createConnection();
		Statement statement=connection.createStatement();
		int r=statement.executeUpdate(SQL);
		System.out.println(r+"rows updated");
		statement.close();
		connection.close();
		
	}
	public static void deleteRecord() throws ClassNotFoundException, SQLException{
		System.out.println("connected successfully");
		String SQL="delete from Customer  where c_id=3";
		Connection connection = createConnection();
		Statement statement=connection.createStatement();
		int r=statement.executeUpdate(SQL);
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
	public static void displayOneRecords(int id) throws ClassNotFoundException, SQLException{
		Connection connection = createConnection();
		String SQL="select * from Customer where c_id="+id;
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
	//	insertRecord();
		//updateRecord();
		//deleteRecord();
		//displayAllRecords();
		displayOneRecords(6);

	}

}
