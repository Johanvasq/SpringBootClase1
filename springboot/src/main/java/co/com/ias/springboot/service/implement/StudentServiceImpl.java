package co.com.ias.springboot.service.implement;

import co.com.ias.springboot.dto.StudentDTO;
import co.com.ias.springboot.repository.IStudentRepository;
import co.com.ias.springboot.repository.entity.Student;
import co.com.ias.springboot.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository repository;

    public StudentServiceImpl(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(StudentDTO studentDTO) {
        if(!repository.existsById(studentDTO.getIdentification())) {
            repository.save(new Student(studentDTO));
        }
    }

    @Override
    public void update(StudentDTO studentDTO) {
        Optional<Student> student = repository.findById(studentDTO.getIdentification());
        if(student.isPresent()) {
            repository.save(new Student(studentDTO));
        }
    }

    @Override
    public StudentDTO findById(Integer id) {
        Optional<Student> student = repository.findById(id);
        return student.map(StudentDTO::new).orElse(null);
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> students = repository.findAll();
        return students.stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Optional<Student> student = repository.findById(id);
        student.ifPresent(repository::delete);
    }
}
