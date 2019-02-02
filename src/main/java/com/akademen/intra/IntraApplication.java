package com.akademen.intra;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import com.akademen.intra.com.akademen.intra.domain.Person;
import com.akademen.intra.com.akademen.intra.domain.PersonRepository;
import com.akademen.intra.com.akademen.intra.domain.Transaction;
import com.akademen.intra.com.akademen.intra.domain.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IntraApplication {
	private static final Logger logger = LoggerFactory.getLogger(IntraApplication.class);

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	public static void main(String[] args) {
		SpringApplication.run(IntraApplication.class, args);
		logger.info("this is a test");
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {

			Person person1 = new Person(UUID.randomUUID().toString(), "pekka", "Tester", "2B",
				null, null, null, null, null, null, "pekka@test.akademen.com",
				null, null, 0, 0, "$2a$10$Uj8rZ1IkQTYucjNbWHd8IOeCGqY6nawIaHA9duFOGzhCNns04F43S",
				LocalDateTime.now(), null);
			person1.setCreatedBy(person1); // Special case for first person
			Person person2 = new Person(UUID.randomUUID().toString(), "Alfons", "Tester", "2B",
				null, null, null, null, null, null, "alfons@test.akademen.com",
				null, null, 0, 0, "$2a$10$Uj8rZ1IkQTYucjNbWHd8IO2TPY2gTThrmY7O2G.4mbUkjzqW42Cqi",
				LocalDateTime.now(), person1);
			Person person3 = new Person(UUID.randomUUID().toString(), "Bert", "Tester", "2B",
				null, null, null, null, null, null, "bert@test.akademen.com",
				null, null, 0, 0, "$2a$10$Uj8rZ1IkQTYucjNbWHd8IO0vhA87iieVFqS/wBOK0OaHlIpkO1pzS",
				LocalDateTime.now(), person1);
			Person person4 = new Person(UUID.randomUUID().toString(), "Carl", "Tester", "2B",
				null, null, null, null, null, null, "carl@test.akademen.com",
				null, null, 0, 0, "$2a$10$Uj8rZ1IkQTYucjNbWHd8IO7/4wFH6jWHLfDS1ZPNzORr3zzzJL/se",
				LocalDateTime.now(), person1);
			Person person5 = new Person(UUID.randomUUID().toString(), "David", "Tester", "2B",
				null, null, null, null, null, null, "carl@test.akademen.com",
				null, null, 0, 0, "$2a$10$Uj8rZ1IkQTYucjNbWHd8IOPk80TEbPYN6/0jg/pQicreteh3DAmf6",
				LocalDateTime.now(), person1);
			Person person6 = new Person(UUID.randomUUID().toString(), "Edward", "Tester", "2B",
				null, null, null, null, null, null, "edward@test.akademen.com",
				null, null, 0, 0, "$2a$10$Uj8rZ1IkQTYucjNbWHd8IOGb42DHidJbT2M.4mPZ.01TMfjbZlQ/q",
				LocalDateTime.now(), person1);

			personRepository.save(person1);
			personRepository.save(person2);
			personRepository.save(person3);
			personRepository.save(person4);
			personRepository.save(person5);
			personRepository.save(person6);

			Transaction transaction1 = new Transaction(UUID.randomUUID().toString(), person2, null, LocalDateTime.now(), 34.00, "Kräftiskeikka", LocalDateTime.now(), person1);
			Transaction transaction2 = new Transaction(UUID.randomUUID().toString(), person2, null, LocalDateTime.now(), 24.00, "Begravning", LocalDateTime.now(), person1);
			Transaction transaction3 = new Transaction(UUID.randomUUID().toString(), person3, null, LocalDateTime.now(), 10.00, "Dubbelkvartettkeikka", LocalDateTime.now(), person1);
			Transaction transaction4 = new Transaction(UUID.randomUUID().toString(), person4, null, LocalDateTime.now(), 15.00, "Kräftiskeikka", LocalDateTime.now(), person1);

			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction3);
			transactionRepository.save(transaction4);
		};
	}
}

