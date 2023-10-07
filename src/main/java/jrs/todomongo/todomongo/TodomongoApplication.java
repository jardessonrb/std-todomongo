package jrs.todomongo.todomongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class TodomongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodomongoApplication.class, args);
	}

}
