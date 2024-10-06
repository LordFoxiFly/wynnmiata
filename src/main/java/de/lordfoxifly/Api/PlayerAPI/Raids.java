package de.lordfoxifly.Api.PlayerAPI;

import com.google.gson.annotations.SerializedName;

public class Raids{

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