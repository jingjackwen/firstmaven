package jingwen.maven.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jingwen.maven.example.Dao.PersonDao;
import jingwen.maven.example.model.Person;
@Service
public class TestService {
	
	@Autowired
	private PersonDao personDao;
	
	public Person getPerson() {
		
		return personDao.getPerson();
	}
	
	public Person getPersonById(int id){
		
		return personDao.getPersonById(id);
	}
	
	public void addPerson(int id, String name, String sex) {
		
		personDao.addPerson(id, name, sex);
	}
	
	public List<Person> getPersonList() {
		
		return personDao.getPersonList();
	}
	
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}
	
	public void deletePerson(int id) {
		personDao.deletePerson(id);
	}
	
}
