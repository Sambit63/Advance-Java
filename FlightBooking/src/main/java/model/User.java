package model;

import java.math.BigInteger;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;    
    private String role;  // "user" or "admin"
    private int age;
    private String phone;

    

	// Constructors
    public User() {}

    public User(int id, String name, String email, String password, String role,int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.age=age;
    }

    public User(String name, String email, String password, String role,int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.age=age;
    }

	// Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

