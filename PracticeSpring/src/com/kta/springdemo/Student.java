package com.kta.springdemo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.kta.springdemo.validation.CourseCode;

public class Student {

	@NotNull(message="put your damn firstname!")
	@Size(min=3,message="I said NAME!")
	private String firstName;
	
	@NotNull(message="put your damn lastname!")
	@Size(min=3,message="I said NAME!")
	private String lastName;
	
	@NotNull(message="put your damn Pass!")
	@Min(value=0, message="must be greater than 0 or equal to 0")
	@Max(value=10, message="must be less than 10 or equal to 10")	
	private Integer freePasses;
	
	@NotNull(message="put your damn Postal Code!")
	@Pattern( regexp = "^[a-zA-Z0-9]{5}", message="only 5 chars/digits!")
	private String postalCode;
	
	@CourseCode(value="NSLK", message="must start with NSLK")
	private String courseCode;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public Student() {
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
	
	
}
