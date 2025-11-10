package demo.springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import demo.springboot.entity.User;
import demo.springboot.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	UserRepository repo;
	
	public List<User> getAll()
	{
		return repo.getAllDesc();
	}
	
	public User save(User user)
	{
		return repo.save(user);
	}
	
	public User getById(Integer id)
	{
		User user= repo.findById(id).orElse(null);
		return user;
	}

	public void delete(Integer id)
	{
		repo.deleteById(id);
	}
	
//	For Pagination
	public Page<User> getPaginated(int page,int size)
	{
		Pageable pageable=PageRequest.of(page, size);
		return repo.findAll(pageable);
	}
}