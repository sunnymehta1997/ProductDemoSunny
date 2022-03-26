package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Doctor;
import com.example.demo.exception.RecordNotFoundExeption;

public interface DemoService {
	
	public List<Doctor> getAllDoctorDetails();
	public Doctor getDoctorById(Long docId);
	public Doctor saveDoctorDetails(Doctor d);
	public void deleteDoctorById(Long id);
	public Doctor updateDoctorById(Doctor d);

}
