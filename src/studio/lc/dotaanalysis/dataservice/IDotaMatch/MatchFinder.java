package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Match;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.MatchResult;


public interface MatchFinder {
	MatchResult findAll();
	Match getMatchDetail(String match_id);
}
