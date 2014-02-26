package dk.mercantec.hot.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ItemJDBCTemplate implements ItemDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void createItem(String name) {
		String SQL = "INSERT INTO item (name) values (?)";
		
		jdbcTemplateObject.update(SQL, name);
		System.out.println("Created Record Item with: Name = " + name);
	}
	
	public void createItem(String name, int price) {
		String SQL = "INSERT INTO item (name, price) values (?, ?)";
		
		jdbcTemplateObject.update(SQL, name, price);
		System.out.println("Created Record Item with: Name = " + name + " Price = " + price);
	}

	public Item getItem(int itemId) {
		String SQL = "SELECT * FROM item WHERE id= ?";
		
		Item item = jdbcTemplateObject.queryForObject(SQL, new Object[]{itemId}, new ItemMapper());
		return item;		
	}

	public void setItemBought(int itemId) {
		String SQL = "UPDATE item SET is_bought=1 WHERE id= ?";
		
		System.out.println("Updated bought status for item with id: " + itemId);
		jdbcTemplateObject.update(SQL, itemId);
				
	}

	public void updateItemPrice(int itemId, int price) {
		String SQL = "UPDATE item SET pricet=? WHERE id= ?";
		
		System.out.println("Updated price for item with id: " + itemId + " to " + price);
		jdbcTemplateObject.update(SQL, price, itemId);		
	}

	public List<Item> getShoppingListItems() {
		String SQL = "SELECT * FROM item";
		List<Item> items = jdbcTemplateObject.query(SQL, new ItemMapper());
		return items;
	}

	public void deleteItem(int itemId) {
		String SQL = "DELETE FROM item WHERE id= ?";
		jdbcTemplateObject.update(SQL, itemId);
	}

	public void resetAllBought() {
		String SQL = "UPDATE item SET is_bought=NULL";
		jdbcTemplateObject.update(SQL);
	}
	
	
}
