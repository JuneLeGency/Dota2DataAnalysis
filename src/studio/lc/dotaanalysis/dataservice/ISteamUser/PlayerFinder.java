package studio.lc.dotaanalysis.dataservice.ISteamUser;

import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Player;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Players;

public interface PlayerFinder {
	Players findAll();
	Player findPlayerByid(String id);
}
