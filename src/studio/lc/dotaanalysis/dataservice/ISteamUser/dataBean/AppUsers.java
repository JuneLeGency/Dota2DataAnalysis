package studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean;

public class AppUsers {
	public static final String ALL = "all";
	public static final String FRIEND = "friend";
	private Friends friendslist;

	public Friends getFriendslist() {
		return friendslist;
	}

	public void setFriendslist(Friends friendslist) {
		this.friendslist = friendslist;
	}

}
