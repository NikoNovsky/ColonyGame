package pl.colonygame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.colonygame.entity.Storage;
import pl.colonygame.entity.User;

public interface StorageRepository extends JpaRepository <Storage, Integer>{


}
