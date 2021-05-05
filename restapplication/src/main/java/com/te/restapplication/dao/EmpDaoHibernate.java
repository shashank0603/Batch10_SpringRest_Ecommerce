package com.te.restapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.te.restapplication.bean.EmpBean;

@Repository
public class EmpDaoHibernate implements EmpDaoImpl {

	@PersistenceUnit
	private EntityManagerFactory managerFactory;

	@Override
	public boolean addemployee(EmpBean infoBean) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(infoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();

		return isAdded;
	}// End of addEmployee()

	@Override
	public boolean deleteEmployee(int empId) {
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isDeleted = false;
		EmpBean infoBean = manager.find(EmpBean.class, empId);
		if (infoBean != null) {
			try {
				transaction.begin();
				manager.remove(infoBean);
				transaction.commit();
				isDeleted = true;
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
				isDeleted = false;
			}
			manager.close();
		}

		return isDeleted;
	}

	@Override
	public boolean updateEmployee(EmpBean infoBean) {
		boolean isUpdated = false;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			EmpBean bean = manager.find(EmpBean.class, infoBean.getEmpId());

			if (infoBean.getEmpName() != null && !infoBean.getEmpName().isEmpty()) {
				bean.setEmpName(infoBean.getEmpName());
			}
			if (infoBean.getPassword() != null && !infoBean.getPassword().isEmpty()) {
				bean.setPassword(infoBean.getPassword());
			}
			transaction.commit();

			isUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		manager.close();
		return isUpdated;
	}// End of updateEmployee()

	@Override
	public EmpBean getEmployee(int empId) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("springdb");
		EntityManager manager = managerFactory.createEntityManager();
		EmpBean bean = manager.find(EmpBean.class, empId);
		return bean;
	}

	@Override
	public List<EmpBean> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
