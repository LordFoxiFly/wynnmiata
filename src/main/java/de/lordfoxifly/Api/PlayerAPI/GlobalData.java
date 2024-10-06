package de.lordfoxifly.Api.PlayerAPI;

import com.google.gson.annotations.SerializedName;

public class GlobalData{

	@SerializedName("completedQuests")
	private int completedQuests;

	@SerializedName("totalLevel")
	private int totalLevel;

	@SerializedName("killedMobs")
	private int killedMobs;

	@SerializedName("dungeons")
	private Dungeons dungeons;

	@SerializedName("pvp")
	private Pvp pvp;

	@SerializedName("wars")
	private int wars;

	@SerializedName("chestsFound")
	private int chestsFound;

	@SerializedName("raids")
	private Raids raids;

	public int getCompletedQuests(){
		return completedQuests;
	}

	public int getTotalLevel(){
		return totalLevel;
	}

	public int getKilledMobs(){
		return killedMobs;
	}

	public Dungeons getDungeons(){
		return dungeons;
	}

	public Pvp getPvp(){
		return pvp;
	}

	public int getWars(){
		return wars;
	}

	public int getChestsFound(){
		return chestsFound;
	}

	public Raids getRaids(){
		return raids;
	}
}