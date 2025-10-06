package com.OneTOOne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {
	@Id
	private int eid;
	private String fuel;
	private  int cc;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public Engine(int eid, String fuel, int cc) {
		super();
		this.eid = eid;
		this.fuel = fuel;
		this.cc = cc;
	}
	public Engine() {
		super();
	}
	
}
