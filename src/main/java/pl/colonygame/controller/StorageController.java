package pl.colonygame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pl.colonygame.entity.Efficiency;
import pl.colonygame.entity.Storage;
import pl.colonygame.entity.Upgrades;
import pl.colonygame.entity.User;
import pl.colonygame.repository.EfficiencyRepository;
import pl.colonygame.repository.StorageRepository;
import pl.colonygame.repository.UpgradesRepository;
import pl.colonygame.repository.UserRepository;

@Controller
public class StorageController {

	@Autowired
	StorageRepository storageRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UpgradesRepository upgradesRepository;
	@Autowired
	EfficiencyRepository efficiencyRepository;
	
	
	@GetMapping("/game/{id}")
	public String gameStart(Model model, @PathVariable int id) {
//		User user = userRepository.findOne(id);
//		Storage storage = new Storage();
//		Efficiency efficiency = new Efficiency();
//		Upgrades upgrades = new Upgrades();
//		model.addAllAttributes("energy", energy);
		return "/game/game";
	}
	
//	@PostMapping("/game/{id}")
//	public String storageSave() {
//		return "game/game";
//	}
	
	@GetMapping("/how")
	public String how() {
		return "/game/how";
	}
	
}
