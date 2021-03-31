package dao;

import java.sql.SQLException;
import java.util.List;

import entity.OrderLine;

public interface OrderLineDAO {
	
	//create
    void add(OrderLine order_line) throws SQLException;

    //read
    List<OrderLine> getAll() throws SQLException;

    OrderLine getById(Long id) throws SQLException;

    //update
    void update(OrderLine order_line) throws SQLException;

    //delete
    void remove(OrderLine order_line) throws SQLException;


}
