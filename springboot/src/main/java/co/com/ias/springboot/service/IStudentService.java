package co.com.ias.springboot.service;

import co.com.ias.springboot.dto.StudentDTO;
import co.com.ias.springboot.dto.TeacherDTO;

import java.util.List;

public interface IStudentService {
    void save(StudentDTO studentDTO);

    void update(StudentDTO studentDTO);

    StudentDTO findById(Integer id);

    List<StudentDTO> findAll();

    void delete(Integer id);
}
