package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bl.Util;
import dao.OrderDAO;
import entity.Item;
import entity.Order;

public class OrderService extends Util implements OrderDAO{
	
	Connection connection = getConnection();

	@Override
	public void add(Order order) throws SQLException {
	PreparedStatement preparedStatement = null;
			
			String sql="INSERT INTO ORDER (ID_CUSTOMER,DATE) VALUES(?,?)";
			
			try {
	            preparedStatement = connection.prepareStatement(sql);
	
	            preparedStatement.setLong(1, order.getId_customer());
	            preparedStatement.setDate(2, order.getDate());
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
	public List<Order> getAll() throws SQLException {
		List<Order> orderList = new ArrayList<>();

        String sql = "SELECT ID, ID_CUSTOMER,DATE FROM ORDER";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
            	Order order = new Order();
            	order.setId(resultSet.getLong("ID"));
            	order.setId_customer(resultSet.getLong("ID_CUSTOMER"));
            	order.setDate(resultSet.getDate("Date"));

                orderList.add(order);
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
        return orderList;
	}

	@Override
	public Order getById(Long id) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, NAME FROM ITEM WHERE ID=?";

        Order order = new Order();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            order.setId(resultSet.getLong("ID"));
        	order.setId_customer(resultSet.getLong("ID_CUSTOMER"));
        	order.setDate(resultSet.getDate("Date"));

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
        return order;
	}

	@Override
	public void update(Order order) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "UPDATE ORDER SET ID_CUSTOMER=?,DATE=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            
            preparedStatement.setLong(1, order.getId_customer());
            preparedStatement.setDate(2, order.getDate());
            preparedStatement.setLong(3, order.getId());

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
	public void remove(Order order) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ORDER WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, order.getId());

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
