package com.te.restapplication.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@Table(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employee")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("employee_info")
//@JsonIdentityInfo(property = " ")
public class EmpBean implements Serializable {

	@Id
	@Column
	private Integer empId;
	@Column
	private String empName;
	@Column
	private Long mob_No;
	@Column
	private String password;

}
