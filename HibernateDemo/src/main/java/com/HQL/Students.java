package com.HQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {
    @Id
    private int id;
    private String name;  
    private int age;
    private String address;
    private int marks;

    public Students() {
        super();
    }

    public Students(int id, String name, int age, String address, int marks) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.marks = marks;
    }

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

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Students [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", marks=" + marks + "]";
    }
}
