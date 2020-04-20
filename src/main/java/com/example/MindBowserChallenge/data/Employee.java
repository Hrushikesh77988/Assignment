package com.example.MindBowserChallenge.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


	
	

@Entity
@Table
public class Employee implements Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private long id;
	    
	    
	 

		@Column(name = "firstName")
	    private  String firstName;
		
		@Column(name = "lastName")
	    private  String lastName;
	   
		@Column(name = "emailAddress")
	    private  String emailAddress;

		@Column(name = "dob")
	    private  String dob;
	   
		@Column(name = "address")
	    private String address;

	    @Column(name = "mobile")
	    private String mobile;
	   
	    @Column(name = "city")
	    private String city;
	    
	    
	  

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
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

	

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
	    
	    

		
	    
	
	  /**
	 * 
	 */
	

	    

	  
	    
	    
	    
		

}
