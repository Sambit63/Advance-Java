package com.OneTOOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
	@Id
	private int id;
	private String name;
	private int price;
	@OneToOne
	private Engine engine;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Car() {
		
	}
	public Car(int id, String name, int price, Engine engine) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.engine = engine;
	}
	
}
