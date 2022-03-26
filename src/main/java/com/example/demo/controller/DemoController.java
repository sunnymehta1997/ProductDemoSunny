package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DemoService;

@RestController
@RequestMapping("/hms")
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@GetMapping(path="/hello")
	public ResponseEntity<String> getEmployee(@RequestParam String name){
		return new ResponseEntity<String>("hello "+name, HttpStatus.OK);
		
	}
	
	@GetMapping(path="/findAllDoctors")
	public ResponseEntity<List<Doctor>> findAllDoctor(){
		List<Doctor> doctors = demoService.getAllDoctorDetails();
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
		
	}
	@GetMapping(path="/findDoctorById")
	public ResponseEntity<Doctor> findDoctorById(@RequestParam Long id){
		Doctor d= demoService.getDoctorById(id);
		return new ResponseEntity<Doctor>(d, HttpStatus.OK);
		
	}
	
	@PostMapping(path="/doctor")
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		Doctor d= demoService.saveDoctorDetails(doctor);
		return new ResponseEntity<Doctor>(d, HttpStatus.OK);
		
	}

}
