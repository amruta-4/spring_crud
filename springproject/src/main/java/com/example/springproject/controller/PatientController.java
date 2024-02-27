package com.example.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.springproject.dao.PatientDao;
import com.example.springproject.dto.PatientDto;

@Controller
public class PatientController {
	
	@Autowired
	PatientDao dao;
	
	
	@RequestMapping("/inserthtml")
	public String insertHtml()
	{
		return "insert.html";
	}
	
	@ResponseBody
	@PostMapping("/insert")
	public String insertData(@ModelAttribute PatientDto dto)
	{
		System.out.println(dto);
		return dao.insertData(dto);
	}

		
	
	@GetMapping("/fetchbyid")
	public ModelAndView fetchPatientById(@RequestParam int id,ModelAndView view)
	{
		PatientDto data = dao.fetchbyid(id);
		view.addObject("o", data);
		view.setViewName("fetchbyid.html");
		return view;
	}
	
	
	@GetMapping("/fetchall")
	public String fetchall(ModelMap map)
	{
		List<PatientDto> list = dao.fetchall();
		map.put("object", list);
		return "fetchall.html";
	}
	
	
	

	
	@ResponseBody
	@RequestMapping("/deletebyid")
	public String deletePatientById(@RequestParam int id)
	{
		return dao.deletePatientbyid(id);
	}

	@RequestMapping("/updatehtml")
	public String update()
	{
		return "update.html";
	}
	
	@PutMapping("/update")
	public String updatePatient(@ModelAttribute PatientDto dto)
	{
		return dao.update(dto);
	}
	
	
	

//	
	
}
