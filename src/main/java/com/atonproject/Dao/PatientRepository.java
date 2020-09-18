package com.atonproject.Dao;

import com.atonproject.Entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    public Patient findByFirstName(String firstName);
    public void deleteByFirstName(String firstName);
    public List<Patient> findByActiveTrue();
    public List<Patient> findByActiveFalse();
}