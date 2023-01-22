package co.com.ias.springboot.controller;

import co.com.ias.springboot.dto.CourseDTO;
import co.com.ias.springboot.dto.StudentDTO;
import co.com.ias.springboot.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

    public final ICourseService service;

    public CourseController(ICourseService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity
                .ok()
                .body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        return ResponseEntity
                .ok()
                .body(service.findById(id));
    }

    @GetMapping("/listStudents/{id}")
    public ResponseEntity<?> getStudentsByCourseId(@PathVariable("id") Integer id) {
        return ResponseEntity
                .ok()
                .body(service.findStudentsByCursoId(id));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody CourseDTO courseDTO){
        try{
            service.save(courseDTO);
            return ResponseEntity
                    .ok()
                    .build();
        } catch (Exception e){
            return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body("error");
        }

    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody CourseDTO courseDTO){
        service.update(courseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
