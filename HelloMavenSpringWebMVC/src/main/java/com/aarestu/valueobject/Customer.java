package com.aarestu.valueobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

	private Long empId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;

	public Customer() {
	}
	
	// @JsonCreator
	//public Customer(@JsonProperty("empId")long empId, @JsonProperty("firstName")String firstName, @JsonProperty("lastName")String lastName, @JsonProperty("email")String email, @JsonProperty("mobile")String mobile) {
	 public Customer(long empId, String firstName, String lastName, String email, String mobile) {
		 super();
		 this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long id) {
		this.empId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [empId=" + empId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", mobile="
				+ mobile + "]";
	}






}