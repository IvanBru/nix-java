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

      } catch (SQLException e) {
          e.printStackTrace();
      }
		
		}
	  }
