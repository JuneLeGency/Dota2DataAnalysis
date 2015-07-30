package studio.lc.dotaanalysis;

import studio.lc.dotaanalysis.dataservice.IDotaMatch.MatchAdapter;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Match;
import studio.lc.dotaanalysis.dataservice.ISteamUser.FriendAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;

@EActivity(R.layout.friends_activity)
public class FriendsActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i("构造中", "构造中");
		super.onCreate(savedInstanceState);
	}

	@Pref
	SteamPrefs_ prefs;
	
	@Bean
	FriendAdapter appadapter;
	
	@Bean
	MatchAdapter matchAdapter;

	@ViewById
	ListView friendslist;

	@AfterInject
	void f(){
		Log.i("steamid", prefs.steamId().get());
		Log.i("steamid", prefs.steamId().get());
	}
	

	@AfterViews
	void setview() {
		friendslist.setAdapter(appadapter);
		matches.setAdapter(matchAdapter);
	}
	
	@ViewById
	ListView matches;
	
	@ItemClick
    void matchesItemClicked(Match match) {
		Toast.makeText(this, match.getFirst_blood_time() + " " + match.getMatch_id(), Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(this, HerosActivity_.class);
		startActivity(intent);
    }	
}
