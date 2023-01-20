package co.com.ias.springboot.repository;

import co.com.ias.springboot.repository.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Integer> {

    public Course findByIssue(String Issue);
}
