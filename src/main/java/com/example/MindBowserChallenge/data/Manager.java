package com.example.MindBowserChallenge.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



	
	

@Entity
@Table
public class Manager implements Serializable {

	
	
	
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
	    	
	    @Column(name = "password")
	    private String password;
	    
	    
	    @Column(name = "confirmpassword")
	    private String confirmpassword;
	    

	    @Column(name = "dateofBirth")
	    private String dateofBirth;
	    
	   
		@Column(name = "address")
	    private String address;

	    @Column(name = "email")
	    private String email;
	   
	    @Column(name = "company")
	    private String company;
	    
	    
	    
	    
	/*
	 * @OneToMany(mappedBy="employee") private List<Employee> employeelist;
	 * 
	 * 
	 * 
	 * public List<Employee> getEmployeelist() { return employeelist; }
	 * 
	 * public void setEmployeelist(List<Employee> employeelist) { this.employeelist
	 * = employeelist; }
	 */
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmpassword() {
			return confirmpassword;
		}

		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}

		public String getDateofBirth() {
			return dateofBirth;
		}

		public void setDateofBirth(String dateofBirth) {
			this.dateofBirth = dateofBirth;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}
	   
	    
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="candidateId") private Candidate candidate;
	 */
	    

	  
	    
	    
	    
		

}
