package pl.colonygame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.colonygame.entity.Efficiency;
import pl.colonygame.entity.GameState;

public interface EfficiencyRepository extends JpaRepository <Efficiency, Integer>{

}
