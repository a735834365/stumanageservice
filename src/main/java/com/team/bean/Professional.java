package com.team.bean;

public class Professional {
	private long id;
	private String name;
	private long parentId;
	private long manageId;
//	private Dept dept;
//	
//	
//	public Dept getDept() {
//		return dept;
//	}
//	public void setDept(Dept dept) {
//		this.dept = dept;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public long getManageId() {
		return manageId;
	}
	public void setManageId(long manageId) {
		this.manageId = manageId;
	}
	
}
