package co.com.ias.springboot.service.implement;

import co.com.ias.springboot.dto.ScoreDTO;
import co.com.ias.springboot.repository.IScoreRepository;
import co.com.ias.springboot.repository.entity.Score;
import co.com.ias.springboot.repository.entity.Student;
import co.com.ias.springboot.service.IScoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements IScoreService {

    private final IScoreRepository repository;

    public ScoreServiceImpl(IScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(ScoreDTO scoreDTO) {
        repository.save(new Score(scoreDTO));
    }

    @Override
    public void update(ScoreDTO scoreDTO) {
        Optional<Score> score = repository.findById(scoreDTO.getId());
        if(score.isPresent()){
            repository.save(new Score(scoreDTO));
        }
    }

    @Override
    public ScoreDTO findById(Integer id) {
        Optional<Score> score = repository.findById(id);
        return score.map(ScoreDTO::getDTO).orElse(null);
    }

    @Override
    public List<ScoreDTO> findAll() {
        List<Score> score = repository.findAll();
        return score.stream()
                .map(ScoreDTO::getDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        Optional<Score> score = repository.findById(id);
        if(score.isPresent()){
            repository.deleteById(id);
        }
    }
}
