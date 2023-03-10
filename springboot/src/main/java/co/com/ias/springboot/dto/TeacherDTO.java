package co.com.ias.springboot.dto;

import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.repository.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherDTO {

    @Min(value = 0, message = "Identification is mandatory")
    private Integer identification;

    @Pattern(regexp = "[a-zA-Z ]*", message = "Name must contain only letters and spaces")
    @NotEmpty(message = "Name is mandatory")
    private String name;

    @Pattern(regexp = "[a-zA-Z ]*", message = "Last name must contain only letters and spaces")
    @NotEmpty(message = "Last name is mandatory")
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
        this.age = teacher.getAge() != null ? teacher.getAge() : null;
        this.courses = teacher.getCourses() != null ? teacher.getCourses()
                .stream()
                .map(CourseDTO::toDTO)
                .collect(Collectors.toList()) : null;
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

    public static TeacherDTO toDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setIdentification(teacher.getIdentification());
        dto.setName(teacher.getName());
        dto.setLastName(teacher.getLastName());
        dto.setAge(teacher.getAge()!= null? teacher.getAge() : null);
        return dto;
    }
}
