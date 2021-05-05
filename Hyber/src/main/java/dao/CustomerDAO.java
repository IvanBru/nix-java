package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Customer;

public interface CustomerDAO {
	
	//create
    void add(Customer customer) throws SQLException;

    //read
    List<Customer> getAll() throws SQLException;

    Customer getById(Long id) throws SQLException;

    //update
    void update(Customer customer) throws SQLException;

    //delete
    void remove(Customer customer) throws SQLException;

}
