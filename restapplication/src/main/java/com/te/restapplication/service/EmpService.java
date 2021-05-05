package com.te.restapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.restapplication.bean.EmpBean;
import com.te.restapplication.dao.EmpDaoImpl;



@Service(value = "service1")
public class EmpService implements EmpServiceImpl {

	@Autowired
	EmpDaoImpl dao;

	@Override
	public boolean addemployee(EmpBean infoBean) {
		if (infoBean.getEmpId() < 1) {
			return false;
		} else {
			return dao.addemployee(infoBean);
		}
	}

	@Override
	public boolean deleteEmployee(int empId) {
		if (empId < 1) {
			return false;
		} else {
			return dao.deleteEmployee(empId);
		}
	}

	@Override
	public boolean updateEmployee(EmpBean infoBean) {
		if (infoBean.getEmpId() < 1) {
			return false;
		} else {
			return dao.updateEmployee(infoBean);
		}
	}

	@Override
	public EmpBean getEmployee(int empId) {

		return null;
	}

	@Override
	public List<EmpBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}

/*
 * }// end od update
 * 
 * public EmployeeInfoBean getEmployee(int empId) { if (empId < 1) { throw new
 * EmployeeException("Invalid Employee ID"); } EmployeeInfoBean infoBean =
 * dao.getEmployee(empId); if (infoBean == null) { throw new
 * EmployeeException("Employee ID Not Found"); } return infoBean; }
 */
