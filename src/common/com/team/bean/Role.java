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

}
