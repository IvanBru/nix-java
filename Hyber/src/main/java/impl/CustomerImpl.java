package impl;

import dao.CustomerDAO;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import businessLogic.HibernateUtil;
import businessLogic.SessionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl extends SessionUtil implements CustomerDAO {

    public void add(Customer customer) throws SQLException {
        
        openTransactionSession();

        Session session = getSession();
        session.save(customer);

        closeTransactionSesstion();
    }

    public List<Customer> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM CUSTOMER";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Customer.class);
        List<Customer> customerList = query.list();

        closeTransactionSesstion();

        return customerList;
    }

    public Customer getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM CUSTOMER WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Customer.class);
        query.setParameter("id", id);

        Customer customer = (Customer) query.getSingleResult();

        closeTransactionSesstion();

        return customer;
    }

    public void update(Customer customer) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(customer);

        closeTransactionSesstion();
    }

    public void remove(Customer customer) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(customer);

        closeTransactionSesstion();
    }

}
