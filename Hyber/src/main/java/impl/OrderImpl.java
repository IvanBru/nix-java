package impl;

import dao.OrderDAO;
import entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import businessLogic.HibernateUtil;
import businessLogic.SessionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl extends SessionUtil implements OrderDAO {

    public void add(Order order) throws SQLException {
        
        openTransactionSession();

        Session session = getSession();
        session.save(order);

        closeTransactionSesstion();
    }

    public List<Order> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ORDERS";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Order.class);
        List<Order> orderList = query.list();

        closeTransactionSesstion();

        return orderList;
    }

    public Order getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ORDERS WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Order.class);
        query.setParameter("id", id);

        Order order = (Order) query.getSingleResult();

        closeTransactionSesstion();

        return order;
    }

    public void update(Order order) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(order);

        closeTransactionSesstion();
    }

    public void remove(Order order) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(order);

        closeTransactionSesstion();
    }

}
