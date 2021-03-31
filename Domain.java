import java.sql.DriverManager;
import java.sql.*;
import java.util.List;

import bl.Util;
import entity.Item;
import service.ItemService;

public class Domain {
	public static void main(String[] args) {
		ItemService itemService = new ItemService();	
		
		Item item = new Item();
        item.setName("Potato");
		
        try {
          itemService.add(item);

          /*List<Item> addressList = itemService.getAll();
          List<Employee> employeeList = employeeService.getAll();
          for (Employee e : employeeList) {
              System.out.println(e);
          }*/

      } catch (SQLException e) {
          e.printStackTrace();
      }
		
		}
	  }
