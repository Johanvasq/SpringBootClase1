package co.com.ias.springboot.repository.entity;

import co.com.ias.springboot.dto.CourseDTO;
import co.com.ias.springboot.dto.TeacherDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
//@Table(name = "TEACHER")
public class Teacher implements Serializable {

    @Id private Integer identification;
    @Column(name = "FIRST_NAME", nullable = false) private String name;
    @Column(name = "LAST_NAME", nullable = false) private String lastName;
    @Column(name = "AGE") private Integer age;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(Integer identification, String name, String lastName, Integer age, List<Course> courses) {
        this.identification = identification;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.courses = courses;
    }

    public Teacher(TeacherDTO teacher) {
        this.identification = teacher.getIdentification();
        this.name = teacher.getName();
        this.lastName = teacher.getLastName();
        this.age = teacher.getAge();
        if(teacher.getCourses() != null){
            this.courses = teacher.getCourses()
                    .stream()
                    .map(Course::new)
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
