package co.com.ias.springboot.repository;

import co.com.ias.springboot.repository.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<Teacher, Integer> {
}
