package studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author legency
 * 
 *         A list of the picks and bans in the match, if the game mode is
 *         Captains Mode.
 */
@DatabaseTable(tableName = "banpick")
public class BanPick {
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "whichmatch")
	private Match match;
	@DatabaseField(generatedId=true)
	private int id;
	/**
	 * 
	 Whether this entry is a pick (true) or a ban (false).
	 */
	@DatabaseField
	private boolean is_pick;
	/**
	 * 
	 The hero's unique ID. A list of hero IDs can be found via the GetHeroes
	 * method.
	 */
	@DatabaseField
	private int hero_id;
	/**
	 * 
	 The team who chose the pick or ban; 0 for Radiant, 1 for Dire.
	 */
	@DatabaseField
	private int team;
	/**
	 * 
	 The order of which the picks and bans were selected; 0-19.
	 */
	@DatabaseField
	private int order;

	public boolean isIs_pick() {
		return is_pick;
	}

	public void setIs_pick(boolean is_pick) {
		this.is_pick = is_pick;
	}

	public int getHero_id() {
		return hero_id;
	}

	public void setHero_id(int hero_id) {
		this.hero_id = hero_id;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
