package dk.mercantec.hot.model;

import java.util.List;

import javax.sql.DataSource;

public interface ItemDAO {
	
	public void setDataSource(DataSource ds);

	public void createItem(String itemName);

	public void createItem(String itemName, int price);
	
	public void deleteItem(int itemId);
	
	public Item getItem(int itemId);
	
	public void resetAllBought();
	
	public void setItemBought(int itemId);
	
	public void updateItemPrice(int itemId, int price);
	
	public List<Item> getShoppingListItems();
	 
}
