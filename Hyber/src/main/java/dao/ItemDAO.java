package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Item;

public interface ItemDAO {
	
	//create
    void add(Item item) throws SQLException;

    //read
    List<Item> getAll() throws SQLException;

    Item getById(Long id) throws SQLException;

    //update
    void update(Item item) throws SQLException;

    //delete
    void remove(Item item) throws SQLException;

}
