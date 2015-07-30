package studio.lc.dotaanalysis.customwidget;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import studio.lc.dotaanalysis.FriendsActivity_;
import studio.lc.dotaanalysis.R;
import studio.lc.dotaanalysis.SteamPrefs_;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Player;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

@EViewGroup(R.layout.profile_layout)
public class ProfileItem extends RelativeLayout {
	private Context context;
	@ViewById
	ImageView avatar;

	@Click
	void avatarClicked() {
		Log.i("点击了", "点击了");
		Intent intent = new Intent(context, FriendsActivity_.class);
		context.startActivity(intent);
	}

	@ViewById
	TextView personaname;

	@ViewById
	TextView status;

	@ViewById
	TextView friendlattime;

	@Pref
	SteamPrefs_ prefs;

	@Click(R.id.logout)
	void logout() {
		prefs.steamId().remove();
	}

	public ProfileItem(Context context,AttributeSet attrs) {
		super(context,attrs);
		this.context = context;
	}

	public void bind(Player player) {
		UrlImageViewHelper.setUrlDrawable(avatar, player.getAvatarfull());
		personaname.setText(String.valueOf(player.getPersonaname()));
		status.setText("(" + player.getpersonstatusString(context) + ")");
		SimpleDateFormat sdf = (SimpleDateFormat) DateFormat
				.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		Date date = new Date(player.getLastlogoff() * 1000);
		friendlattime.setText(sdf.format(date));
	}
}