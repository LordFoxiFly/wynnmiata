package de.lordfoxifly.Api.CharacterDataAPI.CharacterData;

import com.google.gson.annotations.SerializedName;

public class SkillPoints{

	@SerializedName("dexterity")
	private int dexterity;

	@SerializedName("strength")
	private int strength;

	@SerializedName("intelligence")
	private int intelligence;

	public int getDexterity(){
		return dexterity;
	}

	public int getStrength(){
		return strength;
	}

	public int getIntelligence(){
		return intelligence;
	}
}