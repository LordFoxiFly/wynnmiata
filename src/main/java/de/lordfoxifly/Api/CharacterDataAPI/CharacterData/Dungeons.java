package de.lordfoxifly.Api.CharacterDataAPI.CharacterData;

import com.google.gson.annotations.SerializedName;

public class Dungeons{

	@SerializedName("total")
	private int total;

	@SerializedName("list")
	private List list;

	public int getTotal(){
		return total;
	}

	public List getList(){
		return list;
	}
}