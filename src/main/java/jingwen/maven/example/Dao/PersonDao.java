package jingwen.maven.example.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jingwen.maven.example.model.Person;

@Repository
public class PersonDao {
	
	public PersonDao() {
		this.personList = setPersonList();
	}
	
	private List<Person> personList = new ArrayList<Person>();
	
	public List<Person> getPersonList() {
		return personList;
	}
	
	public List<Person> setPersonList() {
		
		for (int i = 1; i < 6; i++) {
			
			Person person = new Person();
			person.setId(i);
			person.setName("荆文" + i);
			person.setSex("男");
			personList.add(person);
		}
		
		return personList;
	}
	
	public Person getPerson() {
		Person person = new Person();
		person.setId(1);
		person.setName("jingwen");
		person.setSex("Man");
		return person;
	}
	
	public Person getPersonById(int id) {
		
		Person person = new Person();
		
		for (Person personFor :personList) {
			if (personFor.getId() == id) {
				person.setId(personFor.getId());
				person.setName(personFor.getName());
				person.setSex(personFor.getSex());
			}
		}
		
		return person;
	}
	
	public void addPerson(int id, String name, String sex) {
		
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setSex(sex);
		
		personList.add(person);
		
	}
	
	public void updatePerson(Person tperson) {
		
		int tempId = tperson.getId();
		for (Person person : personList) {
			if (tempId == person.getId()) {
				person.setName(tperson.getName());
				person.setSex(tperson.getSex());
			}
		}
		
	}
	
	public void deletePerson(int id) {
		
		for (int i = personList.size() - 1; i >= 0; i--) {
			if (personList.get(i).getId() == id) {
				personList.remove(i);
			}
		}
	}
}
