package impl;

import dao.OrderLineDAO;
import entity.OrderLine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import businessLogic.HibernateUtil;
import businessLogic.SessionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderLineImpl extends SessionUtil implements OrderLineDAO {

    public void add(OrderLine orderLine) throws SQLException {
        
        openTransactionSession();

        Session session = getSession();
        session.save(orderLine);

        closeTransactionSesstion();
    }

    public List<OrderLine> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ORDER_LINE";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(OrderLine.class);
        List<OrderLine> orderLineList = query.list();

        closeTransactionSesstion();

        return orderLineList;
    }

    public OrderLine getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ORDER_LINE WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(OrderLine.class);
        query.setParameter("id", id);

        OrderLine orderLine = (OrderLine) query.getSingleResult();

        closeTransactionSesstion();

        return orderLine;
    }

    public void update(OrderLine orderLine) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(orderLine);

        closeTransactionSesstion();
    }

    public void remove(OrderLine orderLine) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(orderLine);

        closeTransactionSesstion();
    }

}
