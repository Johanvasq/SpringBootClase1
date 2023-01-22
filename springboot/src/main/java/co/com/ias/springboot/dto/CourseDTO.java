package co.com.ias.springboot.dto;

import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.repository.entity.Score;
import co.com.ias.springboot.repository.entity.Student;
import co.com.ias.springboot.repository.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDTO{

    private Integer id;

    private List<StudentDTO> students;

    private TeacherDTO teacher;
    @Pattern(regexp = "^([01][0-9]|2[0-3]):[0-5][0-9]-([01][0-9]|2[0-3]):[0-5][0-9]$",
            message = "Invalid time format, valid format is HH:MM-HH:MM")
    @Size(min = 11, max = 14, message = "Schedule must be between 11 and 14 characters")
    private String schedule;

    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Name must not contain special characters")
    @Size(max = 200, message = "Issue field must not exceed 200 characters")
    private String issue;

    private List<ScoreDTO> scoresDto;


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
        this.scoresDto = course.getScores()!= null ? course.getScores()
                .stream()
                .map(ScoreDTO::getDTO)
                .collect(Collectors.toList()): null;
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

    public List<ScoreDTO> getScores() {
        return scoresDto;
    }

    public void setScores(List<ScoreDTO> scoresDto) {
        this.scoresDto = scoresDto;
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
