package demo.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demo.springboot.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM users u ORDER BY u.id DESC")
	List<User>getAllDesc();
	
//	For Pagination
	@Query("SELECT u FROM users u ORDER BY u.id DESC")
	Page<User> findAll(Pageable pageable);
}
