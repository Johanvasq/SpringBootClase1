package co.com.ias.springboot.controller;

import co.com.ias.springboot.dto.ScoreDTO;
import co.com.ias.springboot.service.IScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/score")
public class ScoreController {

    public final IScoreService service;

    public ScoreController(IScoreService service) {
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
    public ResponseEntity<?> save(@Valid @RequestBody ScoreDTO scoreDTO){
        try{
            service.save(scoreDTO);
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
    public ResponseEntity<?> update(@Valid @RequestBody ScoreDTO scoreDTO){
        service.update(scoreDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
