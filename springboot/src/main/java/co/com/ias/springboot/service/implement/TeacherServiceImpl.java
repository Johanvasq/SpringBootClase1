package co.com.ias.springboot.service.implement;

import co.com.ias.springboot.dto.TeacherDTO;
import co.com.ias.springboot.repository.ITeacherRepository;
import co.com.ias.springboot.repository.entity.Teacher;
import co.com.ias.springboot.service.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements ITeacherService {

    private final ITeacherRepository repository;

    public TeacherServiceImpl(ITeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(TeacherDTO teacherDTO) {
        if (!repository.existsById(teacherDTO.getIdentification())) {
            repository.save(new Teacher(teacherDTO));
        }
    }

    @Override
    public void update(TeacherDTO teacherDTO) {
        Optional<Teacher> teacher = repository.findById(teacherDTO.getIdentification());
        if (teacher.isPresent()) {
            repository.save(new Teacher(teacherDTO));
        }
    }

    @Override
    public TeacherDTO findById(Integer id) {
        Optional<Teacher> teacher = repository.findById(id);
        if (teacher.isPresent()) {
            return new TeacherDTO(teacher.get());
        }
        return null;
    }

    @Override
    public List<TeacherDTO> findAll() {
        List<Teacher> teachers = repository.findAll();
        return teachers.stream()
                .map(TeacherDTO::new)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        Optional<Teacher> teacher = repository.findById(id);
        if (teacher.isPresent()) {
            repository.delete(teacher.get());
        }
    }
}
