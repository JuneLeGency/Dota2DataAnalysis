package studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean;

import java.util.ArrayList;
import java.util.Collection;

import android.content.Context;

import com.google.common.base.Predicate;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "match")
public class Match {

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "matchresult")
	private MatchResult matchResult;

	@ForeignCollectionField(eager = true)
	Collection<DotaPlayer> players;

	@DatabaseField
	private String season;
	@DatabaseField
	private boolean radiant_win;
	@DatabaseField
	private int duration;
	@DatabaseField
	private long start_time;

	@DatabaseField(id = true)
	private int match_id;

	@DatabaseField
	private int match_seq_num;
	@DatabaseField
	private int tower_status_radiant;
	@DatabaseField
	private int tower_status_dire;
	@DatabaseField
	private int barracks_status_radiant;
	@DatabaseField
	private int barracks_status_dire;
	@DatabaseField
	private int cluster;
	@DatabaseField
	private int first_blood_time;
	@DatabaseField
	private int lobby_type;
	@DatabaseField
	private int human_players;
	@DatabaseField
	private int leagueid;
	@DatabaseField
	private int positive_votes;
	@DatabaseField
	private int negative_votes;
	@DatabaseField
	private int game_mode;
	@ForeignCollectionField(eager = true)
	Collection<BanPick> picks_bans;

	public MatchResult getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(MatchResult matchResult) {
		this.matchResult = matchResult;
	}

	public Collection<DotaPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(Collection<DotaPlayer> players) {
		this.players = players;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public boolean isRadiant_win() {
		return radiant_win;
	}

	public void setRadiant_win(boolean radiant_win) {
		this.radiant_win = radiant_win;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public long getStart_time() {
		return start_time;
	}

	public void setStart_time(long start_time) {
		this.start_time = start_time;
	}

	public int getMatch_id() {
		return match_id;
	}

	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	public int getMatch_seq_num() {
		return match_seq_num;
	}

	public void setMatch_seq_num(int match_seq_num) {
		this.match_seq_num = match_seq_num;
	}

	public int getTower_status_radiant() {
		return tower_status_radiant;
	}

	public void setTower_status_radiant(int tower_status_radiant) {
		this.tower_status_radiant = tower_status_radiant;
	}

	public int getTower_status_dire() {
		return tower_status_dire;
	}

	public void setTower_status_dire(int tower_status_dire) {
		this.tower_status_dire = tower_status_dire;
	}

	public int getBarracks_status_radiant() {
		return barracks_status_radiant;
	}

	public void setBarracks_status_radiant(int barracks_status_radiant) {
		this.barracks_status_radiant = barracks_status_radiant;
	}

	public int getBarracks_status_dire() {
		return barracks_status_dire;
	}

	public void setBarracks_status_dire(int barracks_status_dire) {
		this.barracks_status_dire = barracks_status_dire;
	}

	public int getCluster() {
		return cluster;
	}

	public void setCluster(int cluster) {
		this.cluster = cluster;
	}

	public int getFirst_blood_time() {
		return first_blood_time;
	}

	public void setFirst_blood_time(int first_blood_time) {
		this.first_blood_time = first_blood_time;
	}

	public int getLobby_type() {
		return lobby_type;
	}

	public void setLobby_type(int lobby_type) {
		this.lobby_type = lobby_type;
	}

	public int getHuman_players() {
		return human_players;
	}

	public void setHuman_players(int human_players) {
		this.human_players = human_players;
	}

	public int getLeagueid() {
		return leagueid;
	}

	public void setLeagueid(int leagueid) {
		this.leagueid = leagueid;
	}

	public int getPositive_votes() {
		return positive_votes;
	}

	public void setPositive_votes(int positive_votes) {
		this.positive_votes = positive_votes;
	}

	public int getNegative_votes() {
		return negative_votes;
	}

	public void setNegative_votes(int negative_votes) {
		this.negative_votes = negative_votes;
	}

	public int getGame_mode() {
		return game_mode;
	}

	public void setGame_mode(int game_mode) {
		this.game_mode = game_mode;
	}

	public Collection<BanPick> getPicks_bans() {
		return picks_bans;
	}

	public void setPicks_bans(Collection<BanPick> picks_bans) {
		this.picks_bans = picks_bans;
	}

	public DotaPlayer getmyuse(final Context context) {

		ArrayList<DotaPlayer> dotaPlayers = com.google.common.collect.Lists
				.newArrayList(com.google.common.collect.Iterables.filter(
						getPlayers(), new Predicate<DotaPlayer>() {
							public boolean apply(DotaPlayer arg0) {
								return arg0.isCurrentUser(context);
							}
						}));
		if (dotaPlayers != null && dotaPlayers.size() > 0) {
			return dotaPlayers.get(0);
		}
		return null;
	}

	public boolean mywin(final Context context) {
		DotaPlayer a = getmyuse(context);
		return !(a.isRadiant() ^ isRadiant_win());

	}
}
