package pl.colonygame.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@OneToOne(mappedBy = "user", cascade = { CascadeType.ALL } )
	Storage game;
	
	@OneToOne(mappedBy = "user", cascade = { CascadeType.ALL } )
	Upgrades upgrades;
	
	@OneToOne(mappedBy = "user", cascade = { CascadeType.ALL } )
	Efficiency efficiency;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String login;

	@Column
	private String password;

	public int setId(int id) {
		return this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Storage getGame() {
		return game;
	}

	public void setGame(Storage game) {
		this.game = game;
	}

	public Upgrades getUpgrades() {
		return upgrades;
	}

	public void setUpgrades(Upgrades upgrades) {
		this.upgrades = upgrades;
	}

	public Efficiency getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(Efficiency efficiency) {
		this.efficiency = efficiency;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


}
