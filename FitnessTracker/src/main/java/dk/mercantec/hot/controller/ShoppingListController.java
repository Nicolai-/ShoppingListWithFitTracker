package dk.mercantec.hot.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dk.mercantec.hot.model.Item;
import dk.mercantec.hot.model.ItemJDBCTemplate;

@Controller
@SessionAttributes("name")
public class ShoppingListController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"Beans.xml");
	ItemJDBCTemplate itemJDBCTemplate = (ItemJDBCTemplate) context
			.getBean("itemJDBCTemplate");

	@RequestMapping(value = "/shoppingList", method = RequestMethod.GET)
	public String getShoppingList(Model model) {		
	
		List<Item> items = itemJDBCTemplate.getShoppingListItems();
		model.addAttribute("items", items);
		return "shoppingList";
	}
	
	
	
	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public String addNewItem(Model model) {
		
		Item item = new Item();
		model.addAttribute("item", item);
		
		return "addItem";		
	}
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addNewItem(@ModelAttribute("item") Item item) {
		
		itemJDBCTemplate.createItem(item.getName(), item.getPrice());
		
		return "redirect:shoppingList.html";		
	}

}
