package com.ajay.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("employeeController")
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
// Create a new Employee	
	@PostMapping("/create")
	public Employee create(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

// Get all Employees
	@GetMapping("/list")
	public List<Employee> getEmployeeList(){
	 return	employeeService.listOfEmployeeData();
	}

// Get Employee by id
	@GetMapping("/id")
	public Optional<Employee> getEmployeeById(@RequestParam long id) {
		return	employeeService.getEmployeeById(id);
	}
	
// Update a existing Employee(all attributes)
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployeeData(employee);
	}
	
// Delete an employee.(preferred soft delete)
	@DeleteMapping("/delete")
	public boolean deleteEmployeeById(@RequestParam long id) {
		return employeeService.deleteEmployeeById(id);
	}

}
