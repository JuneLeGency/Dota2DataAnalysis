package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.R;
import studio.lc.dotaanalysis.dataservice.BaseDataAdapter;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.DotaPlayer;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Match;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.MatchResult;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.common.collect.Collections2;
import com.google.common.collect.ComparisonChain;
import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;

@EViewGroup(R.layout.lv_match)
class MatchItem extends RelativeLayout {
	@Bean
	PlayerAdapter playerAdapter;

	@ViewById
	GridView heros;

	@ViewById
	TextView matchid;
	
	public MatchItem(Context context) {
		super(context);
	}

	public void bind(Match match) {
		Collections2.orderedPermutations(match.getPlayers(),
				new Comparator<DotaPlayer>() {
					@Override
					public int compare(DotaPlayer lhs, DotaPlayer rhs) {
						return ComparisonChain
								.start()
								.compareTrueFirst(lhs.isRadiant(),
										rhs.isRadiant())
								.compare(lhs.getposition(), rhs.getposition())
								.result();
					}
				});
		heros.setAdapter(playerAdapter);
		playerAdapter.updata(match.getPlayers());
		matchid.setText(String.valueOf(match.getMatch_id()));
	}
}

@EBean
public class MatchAdapter extends BaseDataAdapter<MatchResult> {

	private static final String JSON_CACHE_KEY = "matchcache";
	private List<Match> list = new ArrayList<Match>();
	
	@RootContext
	BaseActivity context;

	@Bean(MatchFinderImpl.class)
	MatchFinder matchFinder;

	@AfterInject
	void initAdapter() {
		getSpiceManager().execute(request, JSON_CACHE_KEY,
				DurationInMillis.ALWAYS_RETURNED, requestListener);
//		getdata();
	}

	@UiThread
	void updateui() {
		this.notifyDataSetChanged();
	}

	public MatchAdapter(Context context) {
		super(MatchResult.class, context);
	}

	@Override
	public int getCount() {
		if(list==null){
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
		MatchItem matchItem;
		if (convertView == null) {
			matchItem = MatchItem_.build(context);
		} else {
			matchItem = (MatchItem) convertView;
		}

		matchItem.bind(getItem(position));

		return matchItem;
	}

	@Override
	protected MatchResult loadData() {
		MatchResult a=matchFinder.findAll();
		Log.i("比赛个数", "共"+a.getMatches().size());
		return a;
	}

	@Override
	protected void dategetFailure(SpiceException arg0) {

	}

	@Override
	protected void dategetsuccess(MatchResult arg0) {
		this.list = CommonFunction.CollectiontoList(arg0.getMatches());
	}
}
