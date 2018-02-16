package pl.colonygame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.colonygame.entity.GameState;
import pl.colonygame.entity.User;
import pl.colonygame.repository.EfficiencyRepository;
import pl.colonygame.repository.StorageRepository;
import pl.colonygame.repository.UpgradesRepository;
import pl.colonygame.repository.UserRepository;

@Controller
public class GameController {

	@Autowired
	StorageRepository storageRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UpgradesRepository upgradesRepository;
	
	@Autowired
	EfficiencyRepository efficiencyRepository;
	
//	@Autowired
//	GameStateRepository gameStateRepository;

	@PostMapping("/savegame")
	@ResponseBody
	public String savegame(@RequestBody GameState gameState) {
//		gameStateRepository.save(gameState);
		//userRepository.save(gameState.getUser());
		User user = this.userRepository.getOne(Integer.valueOf(gameState.getUser()));
		gameState.getStorage().setUser(user);
		gameState.getUpgrades().setUser(user);
		gameState.getEfficiency().setUser(user);
		storageRepository.save(gameState.getStorage());
		upgradesRepository.save(gameState.getUpgrades());
		efficiencyRepository.save(gameState.getEfficiency());
//		System.out.println(gameState.toString());
		return "GAME SAVED!";
	}
	
	@GetMapping("/savegame")
	@ResponseBody
	public String savegameGet() {
		return "GAME SAVED!";
	}
}
