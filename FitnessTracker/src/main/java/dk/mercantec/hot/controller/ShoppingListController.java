package dk.mercantec.hot.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dk.mercantec.hot.model.Item;
import dk.mercantec.hot.model.ItemJDBCTemplate;

@Controller
public class ShoppingListController {
	
	
	@RequestMapping(value = "/shoppingList")
	public String getShoppingList(Model model)
	{
	    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	    ItemJDBCTemplate itemJDBCTemplate = (ItemJDBCTemplate)context.getBean("itemJDBCTemplate");
	       
		List<Item> items = itemJDBCTemplate.getShoppingListItems();
		model.addAttribute("items", items);
		return "shoppingList";		
	}

}
