package studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean;

public class Friend {
	
	private long steamid;
	
	/**
	 * Role in relation to the given steamid
	 */
	private String relationship;
	/**
	 * A unix timestamp of when the friend was added to the list.
	 */
	private long friend_since;

	public long getSteamid() {
		return steamid;
	}

	public void setSteamid(long steamid) {
		this.steamid = steamid;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public long getFriend_since() {
		return friend_since;
	}

	public void setFriend_since(long friend_since) {
		this.friend_since = friend_since;
	}

}
