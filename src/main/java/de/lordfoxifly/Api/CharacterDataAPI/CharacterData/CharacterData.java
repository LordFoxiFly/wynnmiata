package de.lordfoxifly.Api.CharacterDataAPI.CharacterData;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CharacterData{

	@SerializedName("totalLevel")
	private int totalLevel;

	@SerializedName("preEconomy")
	private boolean preEconomy;

	@SerializedName("level")
	private int level;

	@SerializedName("skillPoints")
	private SkillPoints skillPoints;

	@SerializedName("quests")
	private List<String> quests;

	@SerializedName("dungeons")
	private Dungeons dungeons;

	@SerializedName("professions")
	private Professions professions;

	@SerializedName("playtime")
	private Object playtime;

	@SerializedName("pvp")
	private Pvp pvp;

	@SerializedName("type")
	private String type;

	@SerializedName("gamemode")
	private List<Object> gamemode;

	@SerializedName("itemsIdentified")
	private int itemsIdentified;

	@SerializedName("xpPercent")
	private int xpPercent;

	@SerializedName("discoveries")
	private int discoveries;

	@SerializedName("mobsKilled")
	private int mobsKilled;

	@SerializedName("nickname")
	private Object nickname;

	@SerializedName("xp")
	private int xp;

	@SerializedName("blocksWalked")
	private int blocksWalked;

	@SerializedName("wars")
	private int wars;

	@SerializedName("chestsFound")
	private int chestsFound;

	@SerializedName("logins")
	private int logins;

	@SerializedName("raids")
	private Raids raids;

	@SerializedName("deaths")
	private int deaths;

	public int getTotalLevel(){
		return totalLevel;
	}

	public boolean isPreEconomy(){
		return preEconomy;
	}

	public int getLevel(){
		return level;
	}

	public SkillPoints getSkillPoints(){
		return skillPoints;
	}

	public List<String> getQuests(){
		return quests;
	}

	public Dungeons getDungeons(){
		return dungeons;
	}

	public Professions getProfessions(){
		return professions;
	}

	public Object getPlaytime(){
		return playtime;
	}

	public Pvp getPvp(){
		return pvp;
	}

	public String getType(){
		return type;
	}

	public List<Object> getGamemode(){
		return gamemode;
	}

	public int getItemsIdentified(){
		return itemsIdentified;
	}

	public int getXpPercent(){
		return xpPercent;
	}

	public int getDiscoveries(){
		return discoveries;
	}

	public int getMobsKilled(){
		return mobsKilled;
	}

	public Object getNickname(){
		return nickname;
	}

	public int getXp(){
		return xp;
	}

	public int getBlocksWalked(){
		return blocksWalked;
	}

	public int getWars(){
		return wars;
	}

	public int getChestsFound(){
		return chestsFound;
	}

	public int getLogins(){
		return logins;
	}

	public Raids getRaids(){
		return raids;
	}

	public int getDeaths(){
		return deaths;
	}
}