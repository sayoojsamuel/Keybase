package com.onedark.springbootstarter.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String id;
	private String name;
	private String description;
	private String pubkey;
	private String privkey;

	public User() {
	}

	
	public User(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public String getPubkey() {
		return pubkey;
	}


	public void setPubkey(String pubkey) {
		this.pubkey = pubkey;
	}


	public String getPrivkey() {
		return privkey;
	}


	public void setPrivkey(String privkey) {
		this.privkey = privkey;
	}
	
	
}
