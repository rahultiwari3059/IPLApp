package com.ipl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Team {
	
	@Id
	@GeneratedValue
	private int teamId;
	
	@Column
	private String teamName;
	
	@Column
	private byte[] teamImage;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public byte[] getTeamImage() {
		return teamImage;
	}

	public void setTeamImage(byte[] teamImage) {
		this.teamImage = teamImage;
	}
}
