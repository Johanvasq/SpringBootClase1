package co.com.ias.springboot.repository.entity;

import co.com.ias.springboot.dto.CourseDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Entity
//@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;
    @ManyToOne
    @JoinColumn(name = "TEACHER_IDENTIFICATION", nullable = false)
    private Teacher teacher;
    @Column(name = "SCHEDULE", nullable = false) private String schedule;
    @Column(name = "ISSUE", nullable = false) private String issue;


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
        this.students = course.getStudents()
                .stream()
                .map(Student::new)
                .collect(Collectors.toList());
        this.teacher = new Teacher(course.getTeacher());
        this.schedule = course.getSchedule();
        this.issue = course.getIssue();

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
}
