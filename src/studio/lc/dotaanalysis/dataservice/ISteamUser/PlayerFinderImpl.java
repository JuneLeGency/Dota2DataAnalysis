package studio.lc.dotaanalysis.dataservice.ISteamUser;

import java.util.Collection;

import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.SteamPrefs_;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.AppUsers;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Friend;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Player;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Players;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.UsersProfile;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;

@EBean
public class PlayerFinderImpl implements PlayerFinder {
	@Pref
	SteamPrefs_ prefs;

	@RestService
	ISteamUserDP userdataservice;

	@Override
	public Players findAll() {
		String steamid = prefs.steamId().get();
		AppUsers users = userdataservice.GetFriendList(steamid, AppUsers.ALL);
		Collection<String> steamids = Collections2.transform(users
				.getFriendslist().getFriends(), new Function<Friend, String>() {
			public String apply(Friend friend) {
				return String.valueOf(friend.getSteamid());
			}
		});
		String steamids2 = CommonFunction.join(steamids.toArray(), ",");
		UsersProfile profile = userdataservice.GetPlayerSummaries(steamids2);
		profile.getResponse().setId(steamid);
		return profile.getResponse();
	}

	@Override
	public Player findPlayerByid(String steamid) {
		UsersProfile profile = userdataservice.GetPlayerSummaries(steamid);
		if (profile.getResponse().getPlayers().size() > 0)
			return CommonFunction.CollectiontoList(
					profile.getResponse().getPlayers()).get(0);
		else
			return null;
	}

}
