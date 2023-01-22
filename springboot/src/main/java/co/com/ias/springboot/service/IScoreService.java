package co.com.ias.springboot.service;

import co.com.ias.springboot.dto.CourseDTO;
import co.com.ias.springboot.dto.ScoreDTO;

import java.util.List;

public interface IScoreService {
    void save(ScoreDTO scoreDTO);

    void update(ScoreDTO scoreDTO);

    ScoreDTO findById(Integer id);

    List<ScoreDTO> findAll();

    void delete(Integer id);
}
