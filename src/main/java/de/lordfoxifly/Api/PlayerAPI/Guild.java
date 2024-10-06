package de.lordfoxifly.Api.PlayerAPI;

import com.google.gson.annotations.SerializedName;

public class Guild{

	@SerializedName("rankStars")
	private String rankStars;

	@SerializedName("prefix")
	private String prefix;

	@SerializedName("name")
	private String name;

	@SerializedName("rank")
	private String rank;

	@SerializedName("uuid")
	private String uuid;

	public String getRankStars(){
		return rankStars;
	}

	public String getPrefix(){
		return prefix;
	}

	public String getName(){
		return name;
	}

	public String getRank(){
		return rank;
	}

	public String getUuid(){
		return uuid;
	}
}