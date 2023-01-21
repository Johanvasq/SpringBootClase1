package co.com.ias.springboot.dto;

import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.repository.entity.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDate;

public class StudentDTO {

    private Integer identification;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private Integer age;

    private CourseDTO course;

    public StudentDTO() {

    }

    public StudentDTO(Integer identification, String name, String lastName, LocalDate birthDate, Integer age, CourseDTO course) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = age;
        this.course = course;
    }

    public StudentDTO(Student student) {
        this.identification = student.getIdentification();
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.birthDate = student.getBirthDate();
        this.age = student.getAge();
        this.course = student.getCourse() != null ? CourseDTO.toDTO(student.getCourse()) : null;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public static StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setIdentification(student.getIdentification());
        dto.setName(student.getName());
        dto.setLastName(student.getLastName());
        dto.setBirthDate(student.getBirthDate());
        dto.setAge(student.getAge());
        return dto;
    }
}
