package com.unocareer.hms.patient.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<PatientModel, Integer> {
	
	 @Query(value = "SELECT pm. * FROM patients pm, searchcriteriaa sc WHERE sc.patientcontactnumber = pm.contact_number", nativeQuery = true)
	    List<PatientModel> findPatientsByContactNumberJoining(String contactNumber);

}

