package co.com.ias.springboot.dto;

import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.repository.entity.Score;
import co.com.ias.springboot.repository.entity.Student;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


public class ScoreDTO {
    @Id
    private Integer id;

    @Min(value = 0, message = "The minimum qualification is 0")
    @Max(value = 5, message = "The maximum qualification is 5")
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

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public CourseDTO getCourse() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public static ScoreDTO getDTO(Score score) {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setId(score.getId());
        scoreDTO.setQualification(score.getQualification());
        scoreDTO.setCourseDTO(CourseDTO.toDTO(score.getCourse()));
        scoreDTO.setStudentDTO(StudentDTO.toDTOStudents(score.getStudent()));
        return scoreDTO;
    }
}
