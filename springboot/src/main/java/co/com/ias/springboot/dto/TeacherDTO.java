package co.com.ias.springboot.dto;

import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.repository.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherDTO {

    private Integer identification;
    private String name;
    private String lastName;
    private Integer age;

    private List<CourseDTO> courses;

    public TeacherDTO(Integer identification, String name, String lastName, Integer age, List<CourseDTO> courses) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.courses = courses;
    }

    public TeacherDTO() {
    }

    public TeacherDTO(Teacher teacher) {
        this.identification = teacher.getIdentification();
        this.name = teacher.getName();
        this.lastName = teacher.getLastName();
        this.age = teacher.getAge();
        if (teacher.getCourses() != null){
            this.courses = teacher.getCourses()
                    .stream()
                    .map(CourseDTO::new)
                    .collect(Collectors.toList());
        }else {
            this.courses = null;
        }
    }

    public Integer getIdentification() {
        return identification;
    }

    public void setIdentification(Integer identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}
