package co.com.ias.springboot.service.implement;

import co.com.ias.springboot.dto.CourseDTO;
import co.com.ias.springboot.dto.StudentDTO;
import co.com.ias.springboot.repository.ICourseRepository;
import co.com.ias.springboot.repository.entity.Course;
import co.com.ias.springboot.service.ICourseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository repository;

    public CourseServiceImpl(ICourseRepository repository) {
        this.repository = repository;
    }
    @Override
    public void save(CourseDTO courseDTO) {
        Optional<Course> course = Optional.ofNullable(repository.findByIssue(courseDTO.getIssue()));
        if(course.isEmpty()){
            repository.save(new Course(courseDTO));
        }
    }

    @Override
    public void update(CourseDTO courseDTO) {

        Optional<Course> course = repository.findById(courseDTO.getId());
        if (course.isPresent()) {
            repository.save(new Course(courseDTO));
        }
    }

    @Override
    public CourseDTO findById(Integer id) {
        Optional<Course> course = repository.findById(id);
        return course.map(CourseDTO::new).orElse(null);
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = repository.findAll();
        return courses.stream()
                .map(CourseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Optional<Course> course = repository.findById(id);
        if (course.isPresent()) {
            repository.deleteById(id);
        }
    }

    @Override
    public List<StudentDTO> findStudentsByCursoId(Integer id) {
        Optional<Course> course = repository.findById(id);
        return course.map(value -> value.getStudents().stream()
                .map(StudentDTO::toDTOStudents)
                .collect(Collectors.toList())).orElse(null);

    }
}
