package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bl.Util;
import dao.ItemDAO;
import entity.Item;

public class ItemService extends Util implements ItemDAO {
	
	Connection connection = getConnection();

	@Override
	public void add(Item item) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		String sql="INSERT INTO ITEM (NAME) VALUES(?)";
		
		try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, item.getName());
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
	public List<Item> getAll() throws SQLException {
		 List<Item> itemList = new ArrayList<>();

	        String sql = "SELECT ID, NAME FROM ITEM";

	        Statement statement = null;
	        try {
	            statement = connection.createStatement();

	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                Item item = new Item();
	                item.setId(resultSet.getLong("ID"));
	                item.setName(resultSet.getString("NAME"));

	                itemList.add(item);
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
	        return itemList;
	    }

	@Override
	public Item getById(Long id) throws SQLException {
		 PreparedStatement preparedStatement = null;

	        String sql = "SELECT ID, NAME FROM ITEM WHERE ID=?";

	        Item item = new Item();
	        try {
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setLong(1, id);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            item.setId(resultSet.getLong("ID"));
	            item.setName(resultSet.getString("NAME"));

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
	        return item;
	}

	@Override
	public void update(Item item) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "UPDATE ITEM SET NAME=? WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, item.getName());
            preparedStatement.setLong(2, item.getId());

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
	public void remove(Item item) throws SQLException {
		PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM ITEM WHERE ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, item.getId());

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
