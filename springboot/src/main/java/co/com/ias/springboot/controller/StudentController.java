package co.com.ias.springboot.controller;

import co.com.ias.springboot.dto.StudentDTO;
import co.com.ias.springboot.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    public final IStudentService service;

    public StudentController(IStudentService service) {
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
    public ResponseEntity<?> save(@RequestBody StudentDTO studentDTO){
        service.save(studentDTO);
        return ResponseEntity
                .ok()
                .body("The student " + studentDTO.getName() + " has been created");
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody StudentDTO studentDTO){
        service.update(studentDTO);
        return new ResponseEntity<>( "The student has been updated",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.accepted().body("The student has been deleted");
    }


}
