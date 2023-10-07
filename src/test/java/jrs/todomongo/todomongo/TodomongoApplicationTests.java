package jrs.todomongo.todomongo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles(profiles = {"test"})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TodomongoApplicationTests {

	// @Test
	// void contextLoads() {
	// }

}
