package dao;

import java.sql.SQLException;
import java.util.List;

import entity.OrderLine;

public interface OrderLineDAO {
	
	//create
    void add(OrderLine orderLine) throws SQLException;

    //read
    List<OrderLine> getAll() throws SQLException;

    OrderLine getById(Long id) throws SQLException;

    //update
    void update(OrderLine orderLine) throws SQLException;

    //delete
    void remove(OrderLine orderLine) throws SQLException;

}
