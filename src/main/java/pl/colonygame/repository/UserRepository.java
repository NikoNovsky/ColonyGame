package pl.colonygame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.colonygame.entity.User;

public interface UserRepository extends JpaRepository <User, Integer>{
	

}
