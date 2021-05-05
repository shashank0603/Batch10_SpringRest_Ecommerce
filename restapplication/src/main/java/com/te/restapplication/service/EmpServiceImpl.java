package com.te.restapplication.service;

import java.util.List;

import com.te.restapplication.bean.EmpBean;

public interface EmpServiceImpl {

	public boolean addemployee(EmpBean infoBean);

	public boolean deleteEmployee(int empId);

	public boolean updateEmployee(EmpBean infoBean);

	public EmpBean getEmployee(int empId);

	public List<EmpBean> getAllEmployees();
}
