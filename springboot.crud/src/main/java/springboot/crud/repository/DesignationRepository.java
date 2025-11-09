package springboot.crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.crud.entity.Designation;
@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer>{

}
