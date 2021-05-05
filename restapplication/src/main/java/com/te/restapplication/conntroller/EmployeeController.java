package com.te.restapplication.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.restapplication.bean.EmpBean;
import com.te.restapplication.bean.EmpResponse;
import com.te.restapplication.service.EmpServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private EmpServiceImpl service;

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EmpResponse getEmployee(int empId) {
		EmpResponse response = new EmpResponse();
		EmpBean bean = service.getEmployee(empId);
		if (bean != null) {
			response.setBean(bean);
			response.setMsg("Success");
			response.setStatuscode(200);
		} else {
			response.setStatuscode(404);
			response.setMsg("Failure , Data Not Found");
		}
		return response;
	}
	
	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmpResponse addemployee(@RequestBody EmpBean infoBean) {
		EmpResponse response = new EmpResponse();

		if (service.addemployee(infoBean)) {
			response.setStatuscode(200);
			response.setMsg("success , Added the record");
		} else {
			response.setStatuscode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}// end of addEmp
	
	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmpResponse updateEmpData(@RequestBody EmpBean infoBean) {
		EmpResponse response = new EmpResponse();

		if (service.updateEmployee(infoBean)) {
			response.setStatuscode(200);
			response.setMsg("success , Updated the record");
		} else {
			response.setStatuscode(400);
			response.setMsg("Failure , Could not update the record");
		}
		return response;
	} // update

	
	@DeleteMapping(path = "/delete/{empId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmpResponse deleteEmpData(@PathVariable(name = "empId")int id ) {
		EmpResponse response = new EmpResponse();

		if (service.deleteEmployee(id)) {
			response.setStatuscode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatuscode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}


}
