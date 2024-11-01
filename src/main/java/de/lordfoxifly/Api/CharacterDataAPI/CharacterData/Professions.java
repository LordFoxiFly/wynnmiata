package de.lordfoxifly.Api.CharacterDataAPI.CharacterData;

import com.google.gson.annotations.SerializedName;

public class Professions{

	@SerializedName("tailoring")
	private Tailoring tailoring;

	@SerializedName("woodcutting")
	private Woodcutting woodcutting;

	@SerializedName("woodworking")
	private Woodworking woodworking;

	@SerializedName("fishing")
	private Fishing fishing;

	@SerializedName("farming")
	private Farming farming;

	@SerializedName("scribing")
	private Scribing scribing;

	@SerializedName("armouring")
	private Armouring armouring;

	@SerializedName("mining")
	private Mining mining;

	@SerializedName("jeweling")
	private Jeweling jeweling;

	@SerializedName("alchemism")
	private Alchemism alchemism;

	@SerializedName("cooking")
	private Cooking cooking;

	@SerializedName("weaponsmithing")
	private Weaponsmithing weaponsmithing;

	public Tailoring getTailoring(){
		return tailoring;
	}

	public Woodcutting getWoodcutting(){
		return woodcutting;
	}

	public Woodworking getWoodworking(){
		return woodworking;
	}

	public Fishing getFishing(){
		return fishing;
	}

	public Farming getFarming(){
		return farming;
	}

	public Scribing getScribing(){
		return scribing;
	}

	public Armouring getArmouring(){
		return armouring;
	}

	public Mining getMining(){
		return mining;
	}

	public Jeweling getJeweling(){
		return jeweling;
	}

	public Alchemism getAlchemism(){
		return alchemism;
	}

	public Cooking getCooking(){
		return cooking;
	}

	public Weaponsmithing getWeaponsmithing(){
		return weaponsmithing;
	}
}