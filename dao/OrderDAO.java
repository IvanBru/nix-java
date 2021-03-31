package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Order;

public interface OrderDAO {
	
	//create
    void add(Order order) throws SQLException;

    //read
    List<Order> getAll() throws SQLException;

    Order getById(Long id) throws SQLException;

    //update
    void update(Order order) throws SQLException;

    //delete
    void remove(Order order) throws SQLException;


}
