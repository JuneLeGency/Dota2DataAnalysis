package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;

import studio.lc.dotaanalysis.Constants;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.MatchDetail;

import com.googlecode.androidannotations.annotations.rest.Get;
import com.googlecode.androidannotations.annotations.rest.Rest;

/**
 * General interfaces
 * @author legency
 *
 */
@Rest(rootUrl = "http://api.steampowered.com/IDOTA2Match_", converters = { MappingJacksonHttpMessageConverter.class })
public interface IDotaMatchDP {
    /**
     * player_name (Optional) (string)
		Exact match of a player's display-name at the time of the match.
		hero_id (Optional) (uint32)
		A list of hero IDs can be found via the GetHeroes method.
		game_mode (Optional) (uint32)
		0 - None
		1 - All Pick
		2 - Captain's Mode
		3 - Random Draft
		4 - Single Draft
		5 - All Random
		6 - Intro
		7 - Diretide
		8 - Reverse Captain's Mode
		9 - The Greeviling
		10 - Tutorial
		11 - Mid Only
		12 - Least Played
		13 - New Player Pool
		14 - Compendium Matchmaking
		16 - Captain's Draft
		skill (Optional) (uint32)
		Skill bracket for the matches (Ignored if an account ID is specified).
		0 - Any
		1 - Normal
		2 - High
		3 - Very High
		date_min (Optional) (uint32)
		Minimum date range for returned matches (unix timestamp, rounded to the nearest day).
		date_max (Optional) (uint32)
		Maximum date range for returned matches (unix timestamp, rounded to the nearest day).
		min_players (Optional) (string)
		Minimum amount of players in a match for the match to be returned.
		account_id (Optional) (string)
		32-bit account ID.
		league_id (Optional) (string)
		Only return matches from this league. A list of league IDs can be found via the GetLeagueListing method.
		start_at_match_id (Optional) (string)
		Start searching for matches equal to or older than this match ID.
		matches_requested (Optional) (string)
		Amount of matches to include in results (default: 25).
		tournament_games_only (Optional) (string)
		Whether to limit results to tournament matches
     */
    @Get("{id}/GetMatchHistory/v1?key="+Constants.APPkey+"&player_name={player_name}&account_id={account_id}")
    MatchHistory GetMatchHistory(int id,String player_name,String account_id);
    
    @Get("{id}/GetMatchDetails/v1?key="+Constants.APPkey+"&match_id={match_id}")
    MatchDetail GetMatchDetails(int id,String match_id);
    
    @Get("{id}GetMatchHistoryBySequenceNum/v1?key="+Constants.APPkey+"&start_at_match_seq_num={start_at_match_seq_num}&matches_requested={matches_requested}")
    MatchHistory GetMatchHistoryBySequenceNum(int id,String start_at_match_seq_num,String matches_requested);
}