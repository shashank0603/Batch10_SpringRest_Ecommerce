package com.te.restapplication.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@XmlRootElement(name = "response")
@JsonPropertyOrder({"status","msg"})
@JsonRootName("response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpResponse implements Serializable{

	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statuscode;
	private String msg;
	
	@JsonProperty("employee_info")
	@XmlElement(name = "employee-info") 
	private EmpBean bean;
}
