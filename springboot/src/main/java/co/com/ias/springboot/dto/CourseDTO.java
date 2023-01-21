package co.com.ias.springboot.dto;

import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.repository.entity.Student;
import co.com.ias.springboot.repository.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDTO{

    private Integer id;

    private List<StudentDTO> students;

    private TeacherDTO teacher;
    private String schedule;
    private String issue;


    public CourseDTO() {
    }

    public CourseDTO(Integer id, List<StudentDTO> students, TeacherDTO teacher, String schedule, String issue) {
        this.id = id;
        this.students = students;
        this.teacher = teacher;
        this.schedule = schedule;
        this.issue = issue;
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.students = course.getStudents() != null ? course.getStudents()
                .stream()
                .map(StudentDTO::toDTO)
                .collect(Collectors.toList()) : null;
        this.teacher = TeacherDTO.toDTO(course.getTeacher());
        this.schedule = course.getSchedule();
        this.issue = course.getIssue();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Integer getId() {
        return id;
    }

    public List<StudentDTO> getStudents() {
        return students;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getIssue() {
        return issue;
    }


    // Convertir a curso

    public static CourseDTO toDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setIssue(course.getIssue());
        dto.setSchedule(course.getSchedule());
        return dto;
    }


    public Object toEntity(Object object) {
        return null;
    }




}
