package com.example.springproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springproject.dto.PatientDto;
import com.example.springproject.repository.PatientRepository;

@Component
public class PatientDao {
	
	@Autowired
	PatientRepository repository;
	
	
	public String insertData(PatientDto dto)
	{
		repository.save(dto);
		return "insert successfully";
	}

	public PatientDto fetchbyid(int id)
	{
		Optional<PatientDto> op = repository.findById(id);
		if(op.isPresent())
		{
		PatientDto data = op.get();
		return data;
		}
		else {
			return null;
		}
	}
	
	public List<PatientDto> fetchall()
	{
		List<PatientDto> list = repository.findAll();
		if(list.isEmpty())
		{
			return null;
		}
		else
			return list;
	}
	
	public String deletePatientbyid(int id)
	{
		 Optional<PatientDto> op = repository.findById(id);
		 if(op.isPresent())
		 {
			 repository.deleteById(id);
			 return "data deleted";
		 }
		 else {
			 return "no such data";
		 }
	}
	
	public String update(PatientDto dto)
	{
		int id=dto.getId();
		Optional<PatientDto> pd = repository.findById(id);
		if(pd.isPresent())
		{
			repository.save(dto);
			return "updated successfully";
		}
		else {
			return "no such data";
		}
	}
	
	
	
	
}
