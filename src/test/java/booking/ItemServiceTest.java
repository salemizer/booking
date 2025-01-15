package booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.salemworx.booking.service.ItemServiceImpl;
import com.salemworx.booking.domain.Item;
import com.salemworx.booking.repository.ItemRepository;
import java.util.List;

import java.util.LinkedList;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

	@Mock
	private ItemRepository itemRepo;
	
	@InjectMocks
	private ItemServiceImpl itemService;
	
	// BeforeEach and AfterEach methods cannot be static
	@BeforeEach
	 void printMeBefore() {
		System.out.println("*** before the test!");
	}
	
	//BeforeAll and AfterAll methods must be static
	@AfterAll
	static void printMeAfterAllTests() {
		System.out.println("*** tests are all finished! thank you");
	}
	
	@Test
	void listItems_notEmpty() {
		Item item1= new Item();
		item1.setItemId(1L);
		item1.setItemName("Table 01");
		
		Item item2= new Item();
		item2.setItemId(2L);
		item2.setItemName("Table 02");
		
		var itemList= new LinkedList<Item>();
		itemList.add(item1);
		itemList.add(item2);
		
		when(itemRepo.listItems()).thenReturn(Optional.ofNullable(itemList));
		List<Item> resultList= itemService.listItems().get();
		assertEquals(1L, resultList.get(0).getItemId());
		assertEquals(2L, resultList.get(1).getItemId());
	}

}
