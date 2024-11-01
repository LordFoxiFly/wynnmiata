package de.lordfoxifly.Api.CharacterDataAPI.CharacterData;

import com.google.gson.annotations.SerializedName;

public class Pvp{

	@SerializedName("kills")
	private int kills;

	@SerializedName("deaths")
	private int deaths;

	public int getKills(){
		return kills;
	}

	public int getDeaths(){
		return deaths;
	}
}