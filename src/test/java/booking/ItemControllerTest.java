package booking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.LinkedList;
import java.util.Optional;
import com.salemworx.booking.controller.ItemController;
import com.salemworx.booking.domain.Item;
import com.salemworx.booking.service.ItemService;

//@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@MockBean
	private ItemService itemService;
	
	@Autowired
	MockMvc mockMvc;
	
//	@Test
	void listItems_notEmpty() throws Exception{
		
		Item item1= new Item();
		item1.setItemId(1L);
		item1.setItemName("Table 01");
		
		Item item2= new Item();
		item2.setItemId(2L);
		item2.setItemName("Table 02");
		
		var itemList= new LinkedList<Item>();
		itemList.add(item1);
		itemList.add(item2);
		
		when(itemService.listItems()).thenReturn(Optional.ofNullable(itemList));
		
	  	RequestBuilder request= MockMvcRequestBuilders.get("/api/v1/items").accept(MediaType.APPLICATION_JSON);
	  	MvcResult result= mockMvc.perform(request).andExpect(status().isOk())
	  	.andExpect(content().json("[{itemId: '01',itemName: 'table 01'},{itemId: '02',itemName: 'table 02'}]"))
	  	.andReturn();
	}

}
