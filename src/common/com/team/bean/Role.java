package com.team.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * create by yifeng
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -4281136339724921124L;

    private Long id;
    private String name;
    private String nameZh;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameZh() {
		return nameZh;
	}
	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

}
