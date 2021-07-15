package CRUD.apirest;

import CRUD.apirest.model.Contact;
import CRUD.apirest.repository.ContactRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;


import java.util.stream.LongStream;

@SpringBootApplication
@EntityScan
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}
@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			//repository.deleteAll();
			//LongStream.range(1, 11)
			//		.mapToObj(i -> {
			//			Contact c = new Contact();
			//			c.setName("Contact " + i);
			//			c.setEmail("contact" + i + "@email.com");
			//			c.setPhone("(111) 111-1111");
			//			return c;
			//		})
			//		.map(v -> repository.save(v))
			//		.forEach(System.out::println);
		};
	}
}


