package domain;


import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

import businessLogic.HibernateUtil;
import entity.Customer;
import entity.Item;
import entity.Order;
import entity.OrderLine;
import impl.CustomerImpl;
import impl.ItemImpl;
import impl.OrderImpl;
import impl.OrderLineImpl;

public class Domain {

    public static void main(String[] args) throws SQLException {
    	
    	ItemImpl itemImpl=new ItemImpl();
    	Item item = new Item();
    	
    	item.setName("Banana");
    	item.setPrice(100D);
    	itemImpl.add(item);
    	System.out.print(itemImpl.getById(1L));
    	System.out.print(itemImpl.getAll());
    	
    	
    	CustomerImpl customerImpl=new CustomerImpl();
    	Customer customer = new Customer();
    	
    	customer.setFirst_name("Oleg");
    	customer.setLast_name("Olegov");
    	
    	
    	customerImpl.add(customer);
    	System.out.print(customerImpl.getById(1L));
    	System.out.print(customerImpl.getAll());
    	
		
		OrderImpl orderImpl=new OrderImpl();
		Order order = new Order();
		 
		order.setCustomer(customerImpl.getById(1L)); 
		
		Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.MAY, 4);

        order.setDate(new Date(calendar.getTime().getTime()));
		 
		order.setStatus(false);
		 
		 
		orderImpl.add(order);
		System.out.print(orderImpl.getById(1L));
		System.out.print(orderImpl.getAll());
		
		
		OrderLineImpl orderLineImpl=new OrderLineImpl();
		OrderLine orderLine = new OrderLine();
    	
		orderLine.setItem(itemImpl.getById(1L));
		orderLine.setOrder(orderImpl.getById(1L));
		orderLine.setCount(10);
    	
    	
    	orderLineImpl.add(orderLine);
    	System.out.print(orderLineImpl.getById(1L));
    	System.out.print(orderLineImpl.getAll());
		 
    	
    	
    	
    	
    	
    	
    	HibernateUtil.shutdown();
    }

}
