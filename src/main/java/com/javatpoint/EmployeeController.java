package com.javatpoint;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.dao.EmployeeDAO;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDAO empDao;	
	
	@RequestMapping("empform")
	public ModelAndView loadForm(){
		return new ModelAndView("empform","command",new Employee());
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute()org.hibernate.Employee emp){
		empDao.save(emp);
		System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());  
		return new ModelAndView("redirect:/viewemp");
	}
	
	@RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        //write the code to get all employees from DAO  
        //here, we are writing manual code of list for easy understanding  
        List<Employee> list=empDao.getEmployee();
        return new ModelAndView("viewemp","list",list);  
    }  
	
	@RequestMapping(value = "/editEmployee/{id}")
	public ModelAndView loadForm(@PathVariable int id){
		Employee emp = empDao.getUserById(id);
		return new ModelAndView("empeditform","command",emp);
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute Employee emp){
		empDao.updateEmployeeById(emp);
		return new ModelAndView("redirect:/viewemp");
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}")
	public ModelAndView deleteEmployee(@PathVariable int id){
		empDao.deleteEmployeeById(id);
		return new ModelAndView("redirect:/viewemp");
	}
	
	
	
}
