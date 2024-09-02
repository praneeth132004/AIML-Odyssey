package com.aiml_odyssey.AIML_Odyssey.Entities;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String level;
	private String phoneno;
	private String password;
	public User() {}
	public User(String name,String email,String level, String phoneno, String password) {
		this.name=name;
		this.email=email;
		this.level=level;
		this.phoneno=phoneno;
		this.password=password;
	}
	
	public Long getId() {
        return id;
    }
	public void setName(String name) {
		this.name=name;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setlevel(String level) {
		this.level=level;
	}
	public void setphoneno(String phoneno) {
		this.phoneno=phoneno;
	}
	public void setpassword(String password) {
		this.password=password;
	}
	
	public String getName() {
	   return name;
	}
	public String getEmail() {
		return email;
	}
	public String getlevel() {
		return level;
	}
	public String getphoneno() {
	    return phoneno;
	}
	public String getpassword() {
		return password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + name + ", Email=" + email + ", level=" + level + ", phoneno=" + phoneno
				+ ", password=" + password + "]";
	}

	
	
}

