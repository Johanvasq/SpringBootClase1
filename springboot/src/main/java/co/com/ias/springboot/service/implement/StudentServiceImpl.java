package co.com.ias.springboot.service.implement;

import co.com.ias.springboot.dto.StudentDTO;
import co.com.ias.springboot.repository.IStudentRepository;
import co.com.ias.springboot.repository.entity.Student;
import co.com.ias.springboot.service.IStudentService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository repository;

    public StudentServiceImpl(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(StudentDTO studentDTO) {
        if(repository.existsById(studentDTO.getIdentification())) {
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
        if(student.isPresent()) {
            return new StudentDTO(student.get());
        }
        return null;
    }

    @Override
    public List<StudentDTO> findAll() {
        List<Student> students = repository.findAll();
        return students.stream()
                .map(student -> new StudentDTO(student))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Optional<Student> student = repository.findById(id);
        if(student.isPresent()) {
            repository.delete(student.get());
        }
    }
}
