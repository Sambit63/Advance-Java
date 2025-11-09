package springboot.crud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.crud.entity.Designation;
import springboot.crud.repository.DesignationRepository;
@Service
public class DesignationService {
	@Autowired
	DesignationRepository desigRepo;
	
	public List<Designation> getAll()
	{
		return desigRepo.findAll();
	}
}
