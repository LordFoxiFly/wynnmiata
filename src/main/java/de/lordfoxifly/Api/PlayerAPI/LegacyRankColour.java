package de.lordfoxifly.Api.PlayerAPI;

import com.google.gson.annotations.SerializedName;

public class LegacyRankColour{

	@SerializedName("sub")
	private String sub;

	@SerializedName("main")
	private String main;

	public String getSub(){
		return sub;
	}

	public String getMain(){
		return main;
	}
}