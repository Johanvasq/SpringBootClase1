package co.com.ias.springboot.dto;

import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.repository.entity.Student;

import javax.persistence.*;

public class ScoreDTO {
    @Id
    private Integer id;

    private Integer qualification;

    private StudentDTO studentDTO;

    private CourseDTO courseDTO;

    public ScoreDTO() {
    }

    public ScoreDTO(Integer id, Integer qualification, StudentDTO studentDTO, CourseDTO courseDTO) {
        this.id = id;
        this.qualification = qualification;
        this.studentDTO = studentDTO;
        this.courseDTO = courseDTO;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    public StudentDTO getStudent() {
        return studentDTO;
    }

    public void setStudent(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public CourseDTO getCourse() {
        return courseDTO;
    }

    public void setCourse(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }
}
