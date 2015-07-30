package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.R;
import studio.lc.dotaanalysis.dataservice.DatabaseHelper;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.DotaPlayer;
import studio.lc.dotaanalysis.dataservice.ISteamUser.PlayerFinder;
import studio.lc.dotaanalysis.dataservice.ISteamUser.PlayerFinderImpl;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Player;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.OrmLiteDao;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.j256.ormlite.dao.Dao;

@EViewGroup(R.layout.lv_player)
class HeroItem extends RelativeLayout {
	Context context;

	@Bean(PlayerFinderImpl.class)
	PlayerFinder playerFinder;

	@ViewById
	ImageView heropic;

	@ViewById
	TextView playername;

	@ViewById
	TextView status;

	@ViewById
	TextView friendlattime;

	public HeroItem(Context context) {
		super(context);
		this.context = context;
	}

	@Background
	void getplayername(DotaPlayer dotaPlayer) {
		Player player = playerFinder.findPlayerByid(String
				.valueOf(CommonFunction.acountidtosteamid(dotaPlayer
						.getAccount_id())));
		if (player != null) {
			setData(player);
		}
	}

	@UiThread
	void setData(Player player) {
		playername.setText(player.getPersonaname());
	}

	public void bind(DotaPlayer dotaPlayer, Hero hero) {
		if (dotaPlayer.isAnymos()) {
			if (hero != null)
				playername.setText("Ïº±ø" + hero.getLocalized_name());
			else {
				Log.i("Ó¢ÐÛ²»´æÔÚ", "id" + dotaPlayer.getHero_id());
			}
		} else {
			if (dotaPlayer.isCurrentUser(context)) {
				playername.setText("ÉÙÏÀ");
			} else {
				getplayername(dotaPlayer);
			}
		}
		if (hero != null)
			heropic.setImageResource(hero.getHeroResource(context, 1));
		// UrlImageViewHelper.setUrlDrawable(heropic, hero.getHeroUrl(1));
	}
}

@EBean
public class PlayerAdapter extends BaseAdapter {

	private List<DotaPlayer> list = new ArrayList<DotaPlayer>();

	@RootContext
	BaseActivity context;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Hero.class)
	Dao<Hero, String> herodao;

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public DotaPlayer getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HeroItem playerItemView;
		if (convertView == null) {
			playerItemView = HeroItem_.build(context);
		} else {
			playerItemView = (HeroItem) convertView;
		}
		DotaPlayer player = getItem(position);

		try {
			playerItemView.bind(getItem(position),
					herodao.queryForId(String.valueOf(player.getHero_id())));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return playerItemView;
	}

	public void updata(Collection<DotaPlayer> list2) {
		list = CommonFunction.CollectiontoList(list2);
		this.notifyDataSetChanged();
	}
}
