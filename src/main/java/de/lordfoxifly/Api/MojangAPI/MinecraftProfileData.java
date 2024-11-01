package de.lordfoxifly.Api.MojangAPI;

import com.google.gson.annotations.SerializedName;

public class MinecraftProfileData{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}
}