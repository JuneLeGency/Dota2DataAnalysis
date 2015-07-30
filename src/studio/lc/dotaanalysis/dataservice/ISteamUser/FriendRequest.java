package studio.lc.dotaanalysis.dataservice.ISteamUser;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;

import studio.lc.dotaanalysis.dataservice.BaseRequest;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Player;
import android.content.Context;

@EBean
public class FriendRequest extends BaseRequest< Player > {

	@Bean(PlayerFinderImpl.class)
    PlayerFinder playerFinder;
	private String id;
	
	public FriendRequest(Context context) {
		super(Player.class, context);
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	protected Player loadDataFrom() throws Exception {
		return playerFinder.findPlayerByid(id);
	}	
	   
    
}