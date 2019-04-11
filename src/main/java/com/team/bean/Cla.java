package com.team.bean;

public class Cla {
	private long id;
	private String name;
	private long manageId;
	private long parentId;
	private Professional professional;
	
	
	public Professional getProfessional() {
		return professional;
	}
	public void setProfessional(Professional professional) {
		this.professional = professional;
	}
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
	public long getManageId() {
		return manageId;
	}
	public void setManageId(long manageId) {
		this.manageId = manageId;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Cla [id=" + id + ", name=" + name + ", manageId=" + manageId + ", parentId=" + parentId
				+ ", professional=" + professional + "]";
	}
	
	
	
}
