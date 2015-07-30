package studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean;

import studio.lc.dotaanalysis.R;
import android.content.Context;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "player")
public class Player {
	@DatabaseField(id = true)
	private String steamid;
	
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "whosfriend")
	private Players response;
	
	/**
	 * An integer that describes the access setting of the profile 1 Private 2
	 * Friends only 3 Friends of Friends 4 Users Only 5 Public
	 */
	@DatabaseField
	private int communityvisibilitystate;

	/**
	 * If set to 1 the user has configured the profile.
	 */
	@DatabaseField
	private int profilestate;

	/**
	 * User's display name.
	 */
	@DatabaseField
	private String personaname;

	/**
	 * A unix timestamp of when the user was last online.
	 */
	@DatabaseField
	private long lastlogoff;

	/**
	 * The URL to the user's Steam Community profile.
	 */
	@DatabaseField
	private String profileurl;

	/**
	 * A 32x32 image
	 */
	@DatabaseField
	private String avatar;

	/**
	 * A 64x64 image
	 */
	@DatabaseField
	private String avatarmedium;

	/**
	 * A 184x184 image
	 */
	@DatabaseField
	private String avatarfull;
	/**
	 * 
	 * The user's status 0 Offline (Also set when the profile is Private) 1
	 * Online 2 Busy 3 Away 4 Snooze 5 Looking to trade 6 Looking to play
	 */
	@DatabaseField
	private int personastate;
	/**
	 * If present the profile allows public comments.
	 */
	@DatabaseField
	private int commentpermission;
	/**
	 * The user's real name.
	 */
	@DatabaseField
	private String realname;
	/**
	 * The 64 bit ID of the user's primary group.
	 */
	@DatabaseField
	private long primaryclanid;
	/**
	 * A unix timestamp of the date the profile was created.
	 */
	@DatabaseField
	private long timecreated;
	/**
	 * ISO 3166 code of where the user is located.
	 */
	@DatabaseField
	private String loccountrycode;
	/**
	 * Variable length code representing the state the user is located in.
	 */
	@DatabaseField
	private String locstatecode;
	/**
	 * An integer ID internal to Steam representing the user's city.
	 */
	@DatabaseField
	private String loccityid;
	/**
	 * If the user is in game this will be set to it's app ID as a string.
	 */
	@DatabaseField
	private int gameid;
	/**
	 * The title of the game.
	 */
	@DatabaseField
	private String gameextrainfo;

	/**
	 * The server URL given as an IP address and port number separated by a
	 * colon, this will not be present or set to "0.0.0.0:0" if none is
	 * available.
	 */
	@DatabaseField
	private String gameserverip;
	@DatabaseField
	private String gameserversteamid;

	public String getSteamid() {
		return steamid;
	}

	public void setSteamid(String steamid) {
		this.steamid = steamid;
	}

	public int getCommunityvisibilitystate() {
		return communityvisibilitystate;
	}

	public void setCommunityvisibilitystate(int communityvisibilitystate) {
		this.communityvisibilitystate = communityvisibilitystate;
	}

	public int getProfilestate() {
		return profilestate;
	}

	public void setProfilestate(int profilestate) {
		this.profilestate = profilestate;
	}

	public String getPersonaname() {
		return personaname;
	}

	public void setPersonaname(String personaname) {
		this.personaname = personaname;
	}

	public long getLastlogoff() {
		return lastlogoff;
	}

	public void setLastlogoff(long lastlogoff) {
		this.lastlogoff = lastlogoff;
	}

	public String getProfileurl() {
		return profileurl;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatarmedium() {
		return avatarmedium;
	}

	public void setAvatarmedium(String avatarmedium) {
		this.avatarmedium = avatarmedium;
	}

	public String getAvatarfull() {
		return avatarfull;
	}

	public void setAvatarfull(String avatarfull) {
		this.avatarfull = avatarfull;
	}

	public int getPersonastate() {
		return personastate;
	}

	public void setPersonastate(int personastate) {
		this.personastate = personastate;
	}

	public int getCommentpermission() {
		return commentpermission;
	}

	public void setCommentpermission(int commentpermission) {
		this.commentpermission = commentpermission;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public long getPrimaryclanid() {
		return primaryclanid;
	}

	public void setPrimaryclanid(long primaryclanid) {
		this.primaryclanid = primaryclanid;
	}

	public long getTimecreated() {
		return timecreated;
	}

	public void setTimecreated(long timecreated) {
		this.timecreated = timecreated;
	}

	public String getLoccountrycode() {
		return loccountrycode;
	}

	public void setLoccountrycode(String loccountrycode) {
		this.loccountrycode = loccountrycode;
	}

	public String getLocstatecode() {
		return locstatecode;
	}

	public void setLocstatecode(String locstatecode) {
		this.locstatecode = locstatecode;
	}

	public String getLoccityid() {
		return loccityid;
	}

	public void setLoccityid(String loccityid) {
		this.loccityid = loccityid;
	}

	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public String getGameextrainfo() {
		return gameextrainfo;
	}

	public void setGameextrainfo(String gameextrainfo) {
		this.gameextrainfo = gameextrainfo;
	}

	public String getGameserverip() {
		return gameserverip;
	}

	public void setGameserverip(String gameserverip) {
		this.gameserverip = gameserverip;
	}

	public String getGameserversteamid() {
		return gameserversteamid;
	}

	public void setGameserversteamid(String gameserversteamid) {
		this.gameserversteamid = gameserversteamid;
	}

	public String getpersonstatusString(Context context) {
		return context.getResources().getStringArray(R.array.userstatus)[getPersonastate()];
	}
}
