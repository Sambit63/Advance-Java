package demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.springboot.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer>{

}
