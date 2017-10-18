package com.aarestu.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aarestu.spring.dao.CustomerDAO;
import com.aarestu.valueobject.Customer;



@RestController
public class CustomerRestController {

	
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Customer>> getCustomers() {
		
		  HttpHeaders headers = new HttpHeaders();
		  List<Customer> employees = customerDAO.list();

		  if (employees == null) {
		   return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
		  }
		  headers.add("Number Of Records Found", String.valueOf(employees.size()));
		  return new ResponseEntity<List<Customer>>(employees, headers, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {

		Customer customer = customerDAO.get(id);
		if (customer == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST/*, produces = "application/json", consumes = "application/json"*/)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
System.out.println("inside POST");
		 HttpHeaders headers = new HttpHeaders();
		  if (customer == null) {
		   return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		  }
		  System.out.println("customer:"+customer);
		  customerDAO.create(customer);
		  headers.add("Employee Created  - ", String.valueOf(customer.getEmpId()));
		  return new ResponseEntity<Customer>(customer, headers, HttpStatus.CREATED);
	}
	

	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {

		if (null == customerDAO.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

		customer = customerDAO.update(id, customer);

		if (null == customer) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(customer, HttpStatus.OK);
	}

}