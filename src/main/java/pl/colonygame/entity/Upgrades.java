package pl.colonygame.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "upgrades")
public class Upgrades {

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	User user;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int campfire;

	@Column
	private int knife;

	@Column
	private int tent;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCampfire() {
		return campfire;
	}

	public void setCampfire(int campfire) {
		this.campfire = campfire;
	}

	public int getKnife() {
		return knife;
	}

	public void setKnife(int knife) {
		this.knife = knife;
	}

	public int getTent() {
		return tent;
	}

	public void setTent(int tent) {
		this.tent = tent;
	}

	public Upgrades() {
		super();
	}
	
	

}
