package com.handmade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tbluser")
public class User {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "user_id")
    private Integer userId;
    
    @Column(name = "password")
    private String password;
    @Column(name = "company")
    private String company;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    
    @Column(name = "username")
    private String userName;

    @Column(name = "phone")
    private String phone;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "country")
    private String country;
    @Column(name = "postal")
    private String postal;


	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "tbluserrolemap", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<UserRole> roles;

    @Column(name = "is_active")
    private Integer isActive;

    public User(){
        this("new", "PASSWORD", "new", "new", "",  1, "", "", "", "", "", "");
    }

    public User(String userName, String password, String firstName, String lastName){
        this(userName, password, firstName, lastName, "", 1, "", "", "", "", "", "");
    }

    public User(String userName, String password, String firstName, String lastName, Integer isActive){
        this(userName, password, firstName, lastName, "",  isActive, "", "", "", "", "", "");
    }

    public User(String userName, String password, String firstName, String lastName, String email, Integer isActive,
         String company, String phone, String address1, String address2, String country, String postal
         ){
        this.setUserName(userName);
        this.setEmail(email);
        this.setPassword(new BCryptPasswordEncoder().encode(password));
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setActive(isActive);
        this.setCompany(company);
        this.setPhone(phone);
        this.setAddress1(address1);
        this.setAddress2(address2);
        this.setCountry(country);
        this.setPostal(postal);
    }
    
    

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public Integer isActive() {
		return isActive;
	}

	public void setActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getFullName(){
        return this.firstName + this.lastName;
    }

	public Collection<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<UserRole> roles) {
		this.roles = roles;
	}
}
	

