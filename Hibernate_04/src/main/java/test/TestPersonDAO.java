package test;

import java.sql.Date;
import java.util.List;

import dao.PersonDAO;
import model.Person;

public class TestPersonDAO {
	public static void main(String[] args) {
		PersonDAO personDAO = new PersonDAO();
		
		List<Person> list = personDAO.selectAll();
		for(Person person: list) {
			System.out.println(person.toString());
		}
	}
}
