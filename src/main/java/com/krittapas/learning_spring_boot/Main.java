package com.krittapas.learning_spring_boot;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.krittapas.learning_spring_boot.entity.Person;
import com.krittapas.learning_spring_boot.repository.PersonDAO;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonDAO dao) {
		return runner -> {
			// saveData(dao);
			// deleteData(dao);
			// getData(dao);
			// getAllData(dao);
			// updateData(dao);
		};
	}

	public void saveData(PersonDAO dao) {
		try {
			Person obj1 = new Person("Krit", "Kaew");
			dao.save(obj1);
			System.out.println("Data Saved!");
		} catch (Exception e) {
			System.out.println("Error Indsert!");
		}
	}

	public void deleteData(PersonDAO dao) {
		try {
			dao.delete(1);
			System.out.println("Data Deleted!");
		} catch (Exception e) {
			System.out.println("Data not found!");
		}
	}

	public void getData(PersonDAO dao) {
		try {
			System.out.println(dao.get(5));
		} catch (Exception e) {
			System.out.println("Data not found!");
		}
	}

	public void getAllData(PersonDAO dao) {
		try {
			List<Person> list = dao.getAll();
			for (Person person : list) {
				System.out.println(person);
			}
		} catch (Exception e) {
			System.out.print("Data not found!");
		}
	}

	public void updateData(PersonDAO dao) {
		try {
			Person myPerson = dao.get(1);
			myPerson.setfName("Krittapas001");
			myPerson.setLName("Kaew001");
			dao.update(myPerson);
			System.out.println("Data Updated!");
		} catch (Exception e) {
			System.out.println("Data not found!");
		}
	}
}
