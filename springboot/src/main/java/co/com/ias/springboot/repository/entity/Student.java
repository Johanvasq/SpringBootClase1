package co.com.ias.springboot.repository.entity;

import co.com.ias.springboot.dto.StudentDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Student {

    @Id private Integer identification;
    @Column(name = "FIRST_NAME", nullable = false) private String name;
    @Column(name = "LAST_NAME", nullable = false) private String lastName;
    @Column(name = "BIRTH_DATE", nullable = false) private LocalDate birthDate;
    @Column(name = "AGE", nullable = false) private Integer age;
    @ManyToOne() private Course course;

    public Student(Integer identification, String name, String lastName, LocalDate birthDate, Course course) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.age = calculateAge();
        this.course = course;
    }

    public Student(StudentDTO studentDTO) {
        this.identification = studentDTO.getIdentification();
        this.name = studentDTO.getName();
        this.lastName = studentDTO.getLastName();
        this.birthDate = studentDTO.getBirthDate();
        this.age = studentDTO.getAge();
        this.course = new Course(studentDTO.getCourse());
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer calculateAge(){
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }


}
