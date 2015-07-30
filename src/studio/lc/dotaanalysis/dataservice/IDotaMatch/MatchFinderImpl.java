package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.Constants;
import studio.lc.dotaanalysis.SteamPrefs_;
import studio.lc.dotaanalysis.dataservice.IDota2.IDotaHeroDP;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.HerosResult;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Match;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.MatchDetail;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.MatchResult;
import android.util.Log;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.googlecode.androidannotations.annotations.sharedpreferences.Pref;

@EBean
public class MatchFinderImpl implements MatchFinder {

	@RootContext
	BaseActivity context;

	@Pref
	SteamPrefs_ pref;

	@RestService
	IDotaMatchDP dotadataservice;

	@RestService
	IDotaHeroDP dataservice;
	
	

	@Override
	public MatchResult findAll() {
		String steamid = pref.steamId().get();
		MatchHistory matchHistory = dotadataservice.GetMatchHistory(
				Constants.DotaId, null,
				CommonFunction.steamidtoacountid(steamid)
						.toString());
		Log.i("数据完毕", "matches");
		HerosResult herosResult = dataservice.GetHeroes(Constants.DotaId,
				CommonFunction.getLanguage());
		ImmutableMap<String, Hero> heromap = Maps.uniqueIndex(herosResult
				.getResult().getHeroes(), new Function<Hero, String>() {
			public String apply(Hero hero) {
				return hero.getId();
			}
		});
		Log.i("数据完毕", "Hero");
		Log.i("比赛个数", "一共"+matchHistory.getResult().getMatches().size());
		return matchHistory.getResult();				
	}

	@Override
	public Match getMatchDetail(String match_id) {
		MatchDetail a = dotadataservice.GetMatchDetails(Constants.DotaId,
				match_id);
		if (a != null)
			return a.getResult();
		else
			return null;

	}

}
