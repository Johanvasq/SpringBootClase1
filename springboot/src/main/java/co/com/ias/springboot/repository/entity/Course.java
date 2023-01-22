package co.com.ias.springboot.repository.entity;

import co.com.ias.springboot.dto.CourseDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
//@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonManagedReference
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "TEACHER_IDENTIFICATION", nullable = false)
    private Teacher teacher;
    @Column(name = "SCHEDULE", nullable = false) private String schedule;
    @Column(name = "ISSUE", nullable = false) private String issue;


    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<Score> scores;

    public Course() {
    }

    public Course(Teacher teacher, String schedule, String issue) {
        this.teacher = teacher;
        this.schedule = schedule;
        this.issue = issue;
    }

    public Course(List<Student> students, Teacher teacher, String schedule, String issue) {
        this.students = students;
        this.teacher = teacher;
        this.schedule = schedule;
        this.issue = issue;
    }

    public Course(CourseDTO course) {
        this.id = course.getId() != null ? course.getId() : null;
        this.students = course.getStudents() != null ? course.getStudents()
                .stream()
                .map(Student::new)
                .collect(Collectors.toList()) : null;
        this.teacher = new Teacher(course.getTeacher());
        this.schedule = course.getSchedule();
        this.issue = course.getIssue();
        this.scores = course.getScores()!= null? course.getScores() : null;

    }

    public Integer getId() {
        return id;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
