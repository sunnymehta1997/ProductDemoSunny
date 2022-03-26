package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.exception.RecordNotFoundExeption;
import com.example.demo.repo.DoctorRepo;
import com.example.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	DoctorRepo doctorRepository;
	@Override
	public List<Doctor> getAllDoctorDetails() {
		
		return doctorRepository.findAll();
		

	}
	@Override
	public Doctor getDoctorById(Long docId) {
		Optional<Doctor> d= doctorRepository.findById(docId);
		if(d.isPresent()) {
			return d.get();
		}
		throw new RecordNotFoundExeption("No record found by Id");
	}
	@Override
	public Doctor saveDoctorDetails(Doctor d) {
		
		return doctorRepository.save(d);
	}
	@Override
	public void deleteDoctorById(Long id) {
		doctorRepository.deleteById(id);;
	}
	@Override
	public Doctor updateDoctorById(Doctor d) {
		
		return doctorRepository.save(d);
	}

}
