package co.com.ias.springboot.service;

import co.com.ias.springboot.dto.CourseDTO;
import co.com.ias.springboot.dto.StudentDTO;

import java.util.List;

public interface ICourseService {
    void save(CourseDTO courseDTO);

    void update(CourseDTO courseDTO);

    CourseDTO findById(Integer id);

    List<CourseDTO> findAll();

    void delete(Integer id);
}
