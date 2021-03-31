package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bl.Util;
import dao.CustomerDAO;
import entity.Customer;

public class CustomerService extends Util implements CustomerDAO {
	
	Connection connection = getConnection();

	@Override
	public void add(Customer customer) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		String sql="INSERT INTO CUSTOMER (FIRST_NAME,LAST_NAME) VALUES(?,?)";
		
		try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, customer.getFirst_name());
            preparedStatement.setString(2, customer.getLast_name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

	@Override
	public List<Customer> getAll() throws SQLException {
		 List<Customer> customerList = new ArrayList<>();

	        String sql = "SELECT ID, FIRST_NAME,LAST_NAME FROM CUSTOMER";

	        Statement statement = null;
	        try {
	            statement = connection.createStatement();

	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	            	Customer customer = new Customer();
	            	customer.setId(resultSet.getLong("ID"));
	            	customer.setFirst_name(resultSet.getString("FIRST_NAME"));
	            	customer.setLast_name(resultSet.getString("LAST_NAME"));

	            	customerList.add(customer);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	        return customerList;
	    }

	@Override
	public Customer getById(Long id) throws SQLException {
		 PreparedStatement preparedStatement = null;

	        String sql = "SELECT ID, FIRST_NAME,LAST_NAME FROM CUSTOMER WHERE ID=?";

	        Customer customer = new Customer();
	        try {
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setLong(1, id);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            customer.setId(resultSet.getLong("ID"));
	            customer.setFirst_name(resultSet.getString("FIRST_NAME"));
	            customer.setLast_name(resultSet.getString("LAST_NAME"));
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        }
	        return customer;
	}

	@Override
	public void update(Customer customer) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "UPDATE CUSTOMER SET FIRST_NAME=?,LAST_NAME=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, customer.getFirst_name());
            preparedStatement.setString(2, customer.getLast_name());
            preparedStatement.setLong(3, customer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
		
	}

	@Override
	public void remove(Customer customer) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM CUSTOMER WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, customer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
		
	}

}
