package com.ajay.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("employeeService")
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		log.info("start saving employee data");
		return employeeRepository.save(employee);
	}

	public List<Employee> listOfEmployeeData() {
		log.info("start getting list of employee data");
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(long id) {
		log.info("start getting employee data by id");
		return employeeRepository.findById(id);
	}

	public Employee updateEmployeeData(Employee employee) {
		log.info("starting method to update emplyee data");
		
		Employee employ = employeeRepository.findById(employee.getId()).orElse(null);
		
		employ.setFirstName(employee.getFirstName());
		employ.setLastName(employee.getLastName());
		employ.setEmail(employee.getEmail());
		employ.setAge(employee.getAge());
		employ.setGender(employee.getGender());
		employ.setAddress(employee.getAddress());
		
		return employeeRepository.save(employ);
	}

	public boolean deleteEmployeeById(long id) {
		log.info("start deleting employee data");
		try {
			employeeRepository.deleteById(id);
		}catch (Exception ex) {
			return false;
		}
		return true;
	}
	
	

}
