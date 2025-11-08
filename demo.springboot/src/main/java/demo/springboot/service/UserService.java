package demo.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springboot.entity.User;
import demo.springboot.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repo;
	
	public List<User> getAll()
	{
		return repo.findAll();
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
}
