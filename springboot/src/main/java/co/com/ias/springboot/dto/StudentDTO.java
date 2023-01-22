package co.com.ias.springboot.dto;


import co.com.ias.springboot.repository.entity.Student;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import java.time.LocalDate;

public class StudentDTO {

    @Min(value = 0, message = "Identification of student is required")
    private Integer identification;

    @NotEmpty(message = "Name of student is required")
    @Pattern(regexp = "[a-zA-Z ]*", message = "Name must contain only letters and spaces")
    private String name;

    @Pattern(regexp = "[a-zA-Z ]*", message = "Last name must contain only letters and spaces")
    @NotEmpty(message = "Last name of student is required")
    private String lastName;

    @NotEmpty(message = "Birth date of student is required")
    @Pattern(regexp = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$",
            message = "Invalid date format, valid format is YYYY-MM-DD")
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
    public static StudentDTO toDTOStudents(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setIdentification(student.getIdentification());
        dto.setName(student.getName());
        dto.setLastName(student.getLastName());
        dto.setBirthDate(student.getBirthDate());
        return dto;
    }

}
