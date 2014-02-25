package dk.mercantec.hot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class ItemMapper implements RowMapper<Item> {
	
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setName(rs.getString("name"));
		item.setId(rs.getInt("id"));
		item.setPrice(rs.getInt("price"));
		item.setBought(rs.getBoolean("is_bought"));
		return item;
	}
}
