package co.com.ias.springboot.repository;

import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

    Course findByIssue(String Issue);

}
