package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.R;
import studio.lc.dotaanalysis.dataservice.BaseDataAdapter;
import studio.lc.dotaanalysis.dataservice.DatabaseHelper;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Heros;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.DotaPlayer;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Match;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.MatchResult;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.common.collect.ImmutableMap;
import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.OrmLiteDao;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.j256.ormlite.dao.Dao;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;

@EViewGroup(R.layout.expandable_list_item)
class NewMatchItem extends RelativeLayout {

	Context context;
	@Bean
	PlayerAdapter playerAdapter;

	@ViewById
	GridView heros;

	@ViewById
	ImageView myhero;

	@ViewById
	TextView heroname;
	
	@ViewById	
	TextView winorlost;
	
	@ViewById
	TextView position;
	
	@OrmLiteDao(helper = DatabaseHelper.class, model = Hero.class)
	Dao<Hero, String> herodao;
	
	@Bean(MatchFinderImpl.class)
	MatchFinder finder;
	
	@Background
	void getMatchDetail(Match match){
		Match match2 = finder.getMatchDetail(String.valueOf(match.getMatch_id()));
		if(match2!=null){
			updatematchdetail(match2);
		}
	}
	@UiThread
	void updatematchdetail(Match match2){
		if(match2.mywin(context)){
			winorlost.setText("Ê¤Àû");
		}else{
			winorlost.setText("Ê§°Ü");
		}
	}
	
	public NewMatchItem(Context context) {
		super(context);
		this.context = context;
	}

	public void bind(Match match) {
		DotaPlayer dotaPlayer = match.getmyuse(context);
		Hero hero = null;
		try {
			hero = herodao.queryForId(String.valueOf(dotaPlayer.getHero_id()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (hero != null) {
			myhero.setImageResource(hero.getHeroResource(context, 0));
			heroname.setText(hero.getLocalized_name());
			if(dotaPlayer.isRadiant()){
				position.setText("Radiant");
			}else{
				position.setText("DIRE");
			}
		}
		heros.setAdapter(playerAdapter);
		playerAdapter.updata(match.getPlayers());
		getMatchDetail(match);
	}
}

@EBean
public class NewMatchAdapter extends BaseDataAdapter<MatchResult> {

	private static final String JSON_CACHE_KEY = "matchcache";
	private List<Match> list = new ArrayList<Match>();
	private ImmutableMap<String, Hero> heromap;

	@RootContext
	BaseActivity context;

	@Bean(MatchFinderImpl.class)
	MatchFinder matchFinder;

	@AfterInject
	void initAdapter() {
		getSpiceManager().execute(request, JSON_CACHE_KEY,
				DurationInMillis.ALWAYS_RETURNED, requestListener);
		// getdata();
	}

	@UiThread
	void updateui() {
		this.notifyDataSetChanged();
	}

	public NewMatchAdapter(Context context) {
		super(MatchResult.class, context);
	}

	@Override
	public int getCount() {
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	@Override
	public Match getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NewMatchItem matchItem;
		if (convertView == null) {
			matchItem = NewMatchItem_.build(context);
		} else {
			matchItem = (NewMatchItem) convertView;
		}

		matchItem.bind(getItem(position));

		return matchItem;
	}

	@Override
	protected MatchResult loadData() {
		return matchFinder.findAll();
	}

	@Override
	protected void dategetFailure(SpiceException arg0) {

	}

	@Override
	protected void dategetsuccess(MatchResult arg0) {
		this.list = CommonFunction.CollectiontoList(arg0.getMatches());
	}
}
