package com.team.bean;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private String username;
	private String password;
	private int classId;
	private int degreeId;
	private Date createTime;
	
	private Cla cla;
	private Professional Professional;
	private Dept dept;
	private Degree degree;
	
	public Professional getProfessional() {
		return Professional;
	}
	public void setProfessional(Professional professional) {
		Professional = professional;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Cla getCla() {
		return cla;
	}
	public void setCla(Cla cla) {
		this.cla = cla;
	}
	public long getId() {
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public long getDegreeId() {
		return degreeId;
	}
	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
