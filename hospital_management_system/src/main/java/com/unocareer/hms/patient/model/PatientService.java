package com.unocareer.hms.patient.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private MyRepository myRepository;

    public List<PatientModel> findPatientsByContactNumberJoining(String contactNumber) {
        return myRepository.findPatientsByContactNumberJoining(contactNumber);
    }
}
