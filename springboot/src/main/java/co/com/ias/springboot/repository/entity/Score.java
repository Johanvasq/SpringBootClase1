package co.com.ias.springboot.repository.entity;

import co.com.ias.springboot.dto.ScoreDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.io.Serializable;

    @Entity
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer qualification;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "student",referencedColumnName = "identification", nullable = false)
    private Student student;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="course",referencedColumnName = "id", nullable=false)
    private Course course;

    public Score() {
    }

    public Score(Integer id, Integer qualification, Student student, Course course) {
        this.id = id;
        this.qualification = qualification;
        this.student = student;
        this.course = course;
    }

    public Score(ScoreDTO scoreDTO){
        this.id = scoreDTO.getId() != null ? scoreDTO.getId() : null;
        this.qualification = scoreDTO.getQualification();
        this.student = scoreDTO.getStudent() != null ? new Student(scoreDTO.getStudent()) : null;
        this.course = scoreDTO.getCourse() != null ? new Course(scoreDTO.getCourse()) : null;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
