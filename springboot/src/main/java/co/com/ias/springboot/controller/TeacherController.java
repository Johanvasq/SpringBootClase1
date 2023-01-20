package co.com.ias.springboot.controller;

import co.com.ias.springboot.dto.TeacherDTO;
import co.com.ias.springboot.service.ITeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/teacher")
public class TeacherController {

    private final ITeacherService service;

    public TeacherController(ITeacherService service) {
        this.service = service;
    }

    @GetMapping("/")
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

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody TeacherDTO teacherDTO){
        service.save(teacherDTO);
        return ResponseEntity
               .ok()
               .build();
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody TeacherDTO teacherDTO){
        service.update(teacherDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
