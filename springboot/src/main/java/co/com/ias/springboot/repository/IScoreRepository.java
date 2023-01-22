package co.com.ias.springboot.repository;

import co.com.ias.springboot.repository.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScoreRepository extends JpaRepository<Score, Integer> {
}
