package co.com.ias.springboot.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer calificacion;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "STUDENT_IDENTIFICATION", nullable = false)
    private Student student;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="COURSE_ID", nullable=false)
    private Course course;

    public Score() {
    }

    public Score(Integer id, Integer calificacion, Student student, Course course) {
        this.id = id;
        this.calificacion = calificacion;
        this.student = student;
        this.course = course;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
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
