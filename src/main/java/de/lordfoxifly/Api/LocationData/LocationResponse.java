package de.lordfoxifly.Api.LocationData;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LocationResponse {

	@SerializedName("server")
	private String server;

	@SerializedName("guild")
	private List<GuildItem> guild;

	@SerializedName("character")
	private String character;

	@SerializedName("name")
	private String name;



	@SerializedName("nickname")
	private String nickname;

	@SerializedName("x")
	private int x;

	@SerializedName("y")
	private int y;

	@SerializedName("z")
	private int z;

	@SerializedName("uuid")
	private String uuid;

	@SerializedName("friends")
	private List<FriendItem> friends;

	@SerializedName("party")
	private List<PartyItem> party;

	public String getServer(){
		return server;
	}

	public String getCharacter(){
		return character;
	}

	public String getName(){
		return name;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getZ(){
		return z;
	}

	public String getUuid(){
		return uuid;
	}
	public String getNickname() {
		return nickname;
	}
	public List<FriendItem> getFriends(){
		return friends;
	}
	public List<PartyItem> getParty(){
		return party;
	}
	public List<GuildItem> getGuild(){
		return guild;
	}
}