package demo.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.entity.Designation;
import demo.springboot.repository.DesignationRepository;

@Service
public class DesignationService {
	@Autowired
	DesignationRepository desigRepo;
	
	public List<Designation> getAll()
	{
		return desigRepo.findAll();
	}
}
