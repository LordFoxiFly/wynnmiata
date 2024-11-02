package de.lordfoxifly.Api.CharacterDataAPI.CharacterData;

import com.google.gson.annotations.SerializedName;

public class Woodworking{

	@SerializedName("level")
	private int level;

	@SerializedName("xpPercent")
	private int xpPercent;

	public int getLevel(){
		return level;
	}

	public int getXpPercent(){
		return xpPercent;
	}
}