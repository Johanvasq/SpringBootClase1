package co.com.ias.springboot.controller;

import co.com.ias.springboot.dto.CourseDTO;
import co.com.ias.springboot.dto.StudentDTO;
import co.com.ias.springboot.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody CourseDTO courseDTO){

        service.save(courseDTO);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody CourseDTO courseDTO){
        service.update(courseDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }
}
