package com.te.restapplication.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class AdminBean implements Serializable{

	private Integer id;
	private String password;
}
