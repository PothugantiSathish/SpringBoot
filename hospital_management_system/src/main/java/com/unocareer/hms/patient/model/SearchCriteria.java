package com.unocareer.hms.patient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="searchcriteriaa")
public class SearchCriteria {
	
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="patientcontactnumber")
	private String patientContactNumber;
	private String patientRegistrationNumber;
	private String patientBillNumber;
	

	public String getPatientRegistrationNumber() {
		return patientRegistrationNumber;
	}

	public void setPatientRegistrationNumber(String patientRegistrationNumber) {
		this.patientRegistrationNumber = patientRegistrationNumber;
	}

	public String getPatientBillNumber() {
		return patientBillNumber;
	}

	public void setPatientBillNumber(String patientBillNumber) {
		this.patientBillNumber = patientBillNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientContactNumber() {
		return patientContactNumber;
	}

	public void setPatientContactNumber(String patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}
	
	

}
