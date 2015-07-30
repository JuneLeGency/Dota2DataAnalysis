package studio.lc.dotaanalysis;

import studio.lc.dotaanalysis.dataservice.ISteamUser.FriendRequest;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Player;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OnActivityResult;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import studio.lc.dotaanalysis.customwidget.ProfileItem;;

@EActivity(R.layout.signin_activity)
public class SignInActivity extends BaseActivity {

	private static final String JSON_CACHE_KEY = "userprofilecach";
	@ViewById(R.id.profile)
	ProfileItem profileItem;

	@ViewById(R.id.notlogin)
	View notlogin;
	@ViewById(R.id.signin)
	View signin;

	@ViewById(R.id.heros)
	View heros;
	@ViewById(R.id.herolist)
	View herolist;
	
	@Click
	void herolist() {
		Intent intent = new Intent(this, MatchActivity_.class);
		startActivity(intent);
	}

	@Click
	void heros() {
		Intent intent = new Intent(this, HerosActivity_.class);
		startActivity(intent);
	}
	

	@Click(R.id.export)
	void exprot() {
		CommonFunction.exportdb(getApplicationContext());
	}

	@Bean
	FriendRequest request;
	private RequestListener<Player> requestListener = new RequestListener<Player>() {

		@Override
		public void onRequestSuccess(Player arg0) {
			Log.i("数据获取成功", arg0.toString());
			profileItem.setVisibility(View.VISIBLE);
			profileItem.bind(arg0);
			notlogin.setVisibility(View.INVISIBLE);
		}

		@Override
		public void onRequestFailure(SpiceException arg0) {
			Log.i("数据获取失败", arg0.toString());
		}
	};

	@AfterViews
	void getdata() {
		steamid = prefs.steamId().getOr("");
		if (!steamid.equals("")) {
			request.setId(steamid);
			getSpiceManager().execute(request, JSON_CACHE_KEY,
					DurationInMillis.ONE_DAY, requestListener);
		}
	}

	@Pref
	SteamPrefs_ prefs;

	private String steamid;

	@Click(R.id.signin)
	void getSteamId() {
		Intent intent = new Intent(this, SteamIDGetActivity_.class);
		String url = "http://www.ychouchou.com/dotaanalysis/?login";
		intent.setData(Uri.parse(url));
		startActivityForResult(intent, 0);
	}

	@OnActivityResult(0)
	void onResult(int resultCode, Intent data) {

		if (resultCode != RESULT_OK || data == null) {
			return;
		}
		// Get the token.
		String steamID = data.getStringExtra("steamID");
		if (steamID != null) {
			/* Use the token to access data */
			Log.i("steamID", steamID);
			prefs.steamId().put(steamID);
		}
	}
}
