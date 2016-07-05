package jingwen.maven.example.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jingwen.maven.example.model.Person;
import jingwen.maven.example.services.TestService;


@Scope("prototype")
@Controller
public class TestController{
	
	@Autowired
	private TestService testService;
	
	public List<Person> personList = null;
	
	public TestService getTestService() {
		return testService;
	}
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	/**
	  * GET请求(不带参数)
	  */
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public @ResponseBody Person getPerson() {
		
		Person person = new Person();
		person = testService.getPerson();
		
		return person;
    }
	
	@RequestMapping(value="/person", method=RequestMethod.GET)
	public @ResponseBody List<Person> getPersonList() {
		
		List<Person> personlist = new ArrayList<Person>();
		personlist = testService.getPersonList();
		
		return personlist;
    }
	
	/**
	  * GET请求(带参数)
	  */
	@RequestMapping(value="/person/{id}", method=RequestMethod.GET)
    public @ResponseBody Person getPersonById(@PathVariable("id")int id) throws Exception {
  
		Person person = new Person();
		person = testService.getPersonById(id);
		
        return person;
    }
	
	/**
	 * 新增用户
	 * @param {"id":"6","name":"newUser","sex":"man"}
	 */
	@RequestMapping(value="/person", method=RequestMethod.POST)
	public @ResponseBody List<Person> addPerson(@RequestBody Person person) {
				
		testService.addPerson(person.getId(), person.getName(), person.getSex());
		List<Person> personlist = new ArrayList<Person>();
		personlist = testService.getPersonList();

        return personlist;
	}
	
	/**
	 * 更新用户
	 * @param Person person
	 */
	@RequestMapping(value="/person", method=RequestMethod.PUT)
	public @ResponseBody List<Person> updateUser(@RequestBody Person person) {
		
		testService.updatePerson(person);
		List<Person> personlist = new ArrayList<Person>();
		personlist = testService.getPersonList();
		
		return personlist;
	}
	
	/**
	 * 删除用户
	 * @param "id":"6"
	 */
	@RequestMapping(value="/person/{id}", method=RequestMethod.DELETE)
	public @ResponseBody List<Person> deleteUser(@PathVariable("id") Integer id){
		
		testService.deletePerson(id);
		List<Person> personlist = new ArrayList<Person>();
		personlist = testService.getPersonList();
		
		return personlist;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.PATCH)
    public @ResponseBody
    List<Person> listPerson(@RequestParam(value = "name", required = false, defaultValue = "") String name) {

        List<Person> personlist = new ArrayList<Person>();

        Person person = new Person();
        person.setId(101);
        person.setName("张三");
        person.setSex("男");
        personlist.add(person);

        Person person2 = new Person();
        person2.setId(102);
        person2.setName("李四");
        person2.setSex("女");
        personlist.add(person2);

        Person person3 = new Person();
        person3.setId(103);
        person3.setName("王五");
        person3.setSex("男");
        personlist.add(person3);

        return personlist;
    }
}