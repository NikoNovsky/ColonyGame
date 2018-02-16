package pl.colonygame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import pl.colonygame.repository.StorageRepository;

@Controller
public class UpgradesController {

	@Autowired
	StorageRepository storageRepository;
	

}
