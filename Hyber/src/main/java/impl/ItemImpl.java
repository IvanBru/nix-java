package impl;

import dao.ItemDAO;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import businessLogic.HibernateUtil;
import businessLogic.SessionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemImpl extends SessionUtil implements ItemDAO {

    public void add(Item item) throws SQLException {
        
        openTransactionSession();

        Session session = getSession();
        session.save(item);

        closeTransactionSesstion();
    }

    public List<Item> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ITEM";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Item.class);
        List<Item> itemList = query.list();

        closeTransactionSesstion();

        return itemList;
    }

    public Item getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ITEM WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Item.class);
        query.setParameter("id", id);

        Item item = (Item) query.getSingleResult();

        closeTransactionSesstion();

        return item;
    }

    public void update(Item item) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(item);

        closeTransactionSesstion();
    }

    public void remove(Item item) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(item);

        closeTransactionSesstion();
    }

}
