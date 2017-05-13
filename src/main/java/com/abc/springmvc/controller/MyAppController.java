package com.abc.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springmvc.model.Student;


@RestController
public class MyAppController {
	
	List<Student> list = new ArrayList<Student>();

	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	@RequestMapping(value="/student/getAllStudents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value="/student/deleteStudent", consumes = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@RequestBody Student student){
		System.out.println("student:"+student);
		for(int i=0;i<list.size();i++){
			Student ss = list.get(i);
			if(ss.getId().equals(student.getId())){
				list.remove(i);
			}
		}
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/student/addStudent", method=RequestMethod.POST)
	public ResponseEntity<Void> addStudent(Student student){
		System.out.println("student:"+student);
		list.add(student);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	//Test
	@RequestMapping(value ="/student/updateStudent", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateStudent(@RequestBody Student student){
		for(Student s:list){
			System.out.println("student:"+student);
			if(s.getId().equals(student.getId())){
				s.setCity(student.getCity());
				s.setName(student.getName());
			}
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostConstruct
	private void populateList(){
		Student s1 = new Student("SDF101", "Raja", "Brisbane");
		Student s2 = new Student("SDF102", "Veni", "Sydney");
		list.add(s1);list.add(s2);
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public Student getOne(@PathVariable("id") String id){
//		return (Student)list.stream().filter(o->o.getId().equals(id)).collect(Collectors.toList()).get(0);
		for(Student s:list){
			if(id.equals(s.getId())){
				return s;
			}
		}
	  return null;	
	}

}
