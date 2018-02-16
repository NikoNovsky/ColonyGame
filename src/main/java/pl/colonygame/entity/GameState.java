package pl.colonygame.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity // dodane
//@Table(name = "gamestate") // dodane
public class GameState {
	
	private int user;
	private Efficiency efficiency;
	private Storage storage;
	private Upgrades upgrades;
	
//	@OneToOne(fetch = FetchType.EAGER) // dodane
//	@JoinColumn(name = "user_id") // dodane
//	User user; // dodane
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public GameState() {
		super();
	}
	
	public Efficiency getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(Efficiency efficiency) {
		this.efficiency = efficiency;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	public Upgrades getUpgrades() {
		return upgrades;
	}
	public void setUpgrades(Upgrades upgrades) {
		this.upgrades = upgrades;
	}



	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
}
