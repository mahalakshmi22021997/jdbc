package com.capgemini.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.businesss.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionManager.createConnection();
		String SQL = "insert into customer values(?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
		preparedStatement.setInt(1, customer.getId());
		preparedStatement.setString(2, customer.getName());
		preparedStatement.setString(3, customer.getCity());
		preparedStatement.setDouble(4, customer.getOutStandingAmount());
		int r = preparedStatement.executeUpdate();
		if (r > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeCustomer(int customerId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.createConnection();
		String SQL="delete from customer where c_id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(SQL);
		preparedStatement.setInt(1, customerId);
		int r=preparedStatement.executeUpdate();
		if(r>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionManager.createConnection();
		String SQL = "update customer set c_name=?,c_city=?,c_amt=? where c_id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(SQL);
	
		preparedStatement.setInt(4, customer.getId());
		preparedStatement.setString(1, customer.getName());
		preparedStatement.setString(2, customer.getCity());
		preparedStatement.setDouble(3, customer.getOutStandingAmount());
		int r = preparedStatement.executeUpdate();
		if (r > 0) {
			
			return true;
		}
		return false;
	}

	@Override
	public Customer findCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.createConnection();
		String SQL="select * from customer ";
		PreparedStatement preparedStatement=connection.prepareStatement(SQL);
		ResultSet rs=preparedStatement.executeQuery(SQL);
		List<Customer> customers=new ArrayList<>();
		while(rs.next()){
			int id=rs.getInt(1); //column index
			String name=rs.getString(2);
			String city=rs.getString(3);
			double amt=rs.getDouble(4);
			Customer customer=new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setCity(city);
			customer.setOutStandingAmount(amt);
			customers.add(customer);
		
		}
		preparedStatement.close();
		rs.close();
		connection.close();
		
		return customers;
	}

}
