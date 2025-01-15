package booking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import com.salemworx.booking.repository.ItemRepository;
import com.salemworx.booking.domain.Item;

//@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepo;

//	@Test
	void listItems_notEmpty() {
		List<Item> resultList= itemRepo.listItems().get();
		assertEquals(resultList.size(),3);
	}

}
