package com.atonproject.Service;

import com.atonproject.Dao.PatientRepository;
import com.atonproject.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    //create patient method
    public Patient createPatient(Patient p){
        return patientRepository.save(p);
    }

    //get all patient method
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    //get all active patient method
    public List<Patient> getAllActivePatients(){
        return patientRepository.findByActiveTrue();
    }

    //get all inactive patient method
    public List<Patient> getAllInactivePatients(){
        return patientRepository.findByActiveFalse();
    }

    //update patient information method
    public Patient updatePatient(String firstName, Patient p){
        Patient oldPatient = patientRepository.findByFirstName(firstName);
        patientRepository.deleteByFirstName(oldPatient.getFirstName());
        return patientRepository.save(p);

    }

    //delete patient by first name method
    public void deletePatient(String firstName){
        Patient p1 = patientRepository.findByFirstName(firstName);
        p1.setActive(false);
        patientRepository.save(p1);
    }

}
