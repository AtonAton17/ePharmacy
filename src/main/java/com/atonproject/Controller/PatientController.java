package com.atonproject.Controller;

import com.atonproject.Entity.Patient;
import com.atonproject.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value="/addPatient", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Patient createPatient(@RequestBody Patient p){
        return patientService.createPatient(p);
    }
    @RequestMapping(value="/allPatients",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> viewAllPatients(){
        return patientService.getAllPatients();
    }

    @RequestMapping(value="/activePatients",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> viewAllActivePatients(){
        return patientService.getAllActivePatients();
    }

    @RequestMapping(value="/inactivePatients",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> viewAllInactivePatients(){
        return patientService.getAllInactivePatients();
    }

    @RequestMapping(value="/updatePatient/{firstName}", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Patient updatePatient(@RequestBody Patient p, @PathVariable("firstName") String fname){
        return patientService.updatePatient(fname, p);

    }

    @RequestMapping(value="/deletePatient/{firstName}", method= RequestMethod.PUT)
    public String deletePatient(@PathVariable("firstName") String firstName){
        patientService.deletePatient(firstName);
        return "Patient has been deleted";
    }

}
