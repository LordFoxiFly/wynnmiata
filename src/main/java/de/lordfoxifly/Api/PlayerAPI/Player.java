package de.lordfoxifly.Api.PlayerAPI;

import com.google.gson.annotations.SerializedName;
import de.lordfoxifly.Api.CharacterDataAPI.CharacterData.CharacterData;
import de.lordfoxifly.Api.CharacterListAPI.CharacterListData;

import java.util.List;
import java.util.Map;

public class Player{

	@SerializedName("server")
	private String server;

	@SerializedName("forumLink")
	private Object forumLink;

	@SerializedName("globalData")
	private GlobalData globalData;

	@SerializedName("rankBadge")
	private String rankBadge;

	@SerializedName("playtime")
	private Object playtime;

	@SerializedName("uuid")
	private String uuid;

	@SerializedName("guild")
	private Guild guild;

	@SerializedName("previousRanking")
	private PreviousRanking previousRanking;

	@SerializedName("firstJoin")
	private String firstJoin;

	@SerializedName("veteran")
	private Object veteran;

	@SerializedName("activeCharacter")
	private String activeCharacter;

	@SerializedName("publicProfile")
	private boolean publicProfile;

	@SerializedName("online")
	private boolean online;

	@SerializedName("rank")
	private String rank;

	@SerializedName("legacyRankColour")
	private LegacyRankColour legacyRankColour;

	@SerializedName("ranking")
	private Ranking ranking;

	@SerializedName("shortenedRank")
	private Object shortenedRank;

	@SerializedName("supportRank")
	private String supportRank;

	@SerializedName("lastJoin")
	private String lastJoin;

	@SerializedName("username")
	private String username;
	private Map<String, CharacterListData> characters;
	private List<CharacterData> characterData;

	public Map<String, CharacterListData> getCharacters() {
		return characters;
	}
	public List<CharacterData> getCharacterData() {
		return characterData;
	}

	public void setCharacterData(List<CharacterData> characterData) {
		this.characterData = characterData;
	}

	public void setCharacters(Map<String, CharacterListData> characters) {
		this.characters = characters;
	}

	public String getServer(){
		return server;
	}

	public Object getForumLink(){
		return forumLink;
	}

	public GlobalData getGlobalData(){
		return globalData;
	}

	public String getRankBadge(){
		return rankBadge;
	}

	public Object getPlaytime(){
		return playtime;
	}

	public String getUuid(){
		return uuid;
	}

	public Guild getGuild(){
		return guild;
	}

	public PreviousRanking getPreviousRanking(){
		return previousRanking;
	}

	public String getFirstJoin(){
		return firstJoin;
	}

	public Object getVeteran(){
		return veteran;
	}

	public String getActiveCharacter(){
		return activeCharacter;
	}

	public boolean isPublicProfile(){
		return publicProfile;
	}

	public boolean isOnline(){
		return online;
	}

	public String getRank(){
		return rank;
	}

	public LegacyRankColour getLegacyRankColour(){
		return legacyRankColour;
	}

	public Ranking getRanking(){
		return ranking;
	}

	public Object getShortenedRank(){
		return shortenedRank;
	}

	public String getSupportRank(){
		return supportRank;
	}

	public String getLastJoin(){
		return lastJoin;
	}

	public String getUsername(){
		return username;
	}
}