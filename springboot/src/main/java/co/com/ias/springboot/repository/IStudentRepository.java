package co.com.ias.springboot.repository;

import co.com.ias.springboot.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
