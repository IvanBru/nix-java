package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bl.Util;
import dao.OrderLineDAO;
import entity.Item;
import entity.OrderLine;

public class OrderLineService extends Util implements OrderLineDAO {
	
	Connection connection = getConnection();

	@Override
	public void add(OrderLine order_line) throws SQLException {
	PreparedStatement preparedStatement = null;
			
			String sql="INSERT INTO ORDER_LINE (ID_ITEM,ID_CUSTOMER) VALUES(?,?,?)";
		
		try {
	        preparedStatement = connection.prepareStatement(sql);
	
	        preparedStatement.setLong(1, order_line.getId_item());
	        preparedStatement.setLong(2, order_line.getId_order());
	        preparedStatement.setLong(3, order_line.getQuantity());
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
	public List<OrderLine> getAll() throws SQLException {
		List<OrderLine> orderLineList = new ArrayList<>();

        String sql = "SELECT ID, ID_ITEM,ID_ORDER,QUANTITY FROM ORDER_LINE";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
            	OrderLine order_line = new OrderLine();
            	order_line.setId(resultSet.getLong("ID"));
            	order_line.setId_item(resultSet.getLong("ID_ITEM"));
            	order_line.setId_order(resultSet.getLong("ID_ORDER"));
            	order_line.setQuantity(resultSet.getLong("QUANTITY"));

                orderLineList.add(order_line);
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
        return orderLineList;
	}

	@Override
	public OrderLine getById(Long id) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, ID_ITEM,ID_ORDER,QUANTITY FROM ORDER_LINE WHERE ID=?";

        OrderLine order_line = new OrderLine();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            order_line.setId(resultSet.getLong("ID"));
            order_line.setId_item(resultSet.getLong("ID_ITEM"));
            order_line.setId_order(resultSet.getLong("ID_ORDER"));
            order_line.setQuantity(resultSet.getLong("QUANTITY"));

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
        return order_line;
	}

	@Override
	public void update(OrderLine order_line) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "UPDATE ORDER_LINE SET ID_ITEM=?,ID_ORDER=?,QUANTITY=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, order_line.getId_item());
            preparedStatement.setLong(2, order_line.getId_order());
            preparedStatement.setLong(3, order_line.getQuantity());
            preparedStatement.setLong(1, order_line.getId());

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
	public void remove(OrderLine order_line) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ORDER_LINE WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, order_line.getId());

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
