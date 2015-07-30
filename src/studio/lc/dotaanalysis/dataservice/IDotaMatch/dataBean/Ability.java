package studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author legency detailing a player's ability upgrades.
 */
@DatabaseTable(tableName = "ability")
public class Ability {
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "whichplayer")
	private DotaPlayer player;
	
	@DatabaseField(generatedId=true)
	private int id;
	/**
	 * ID of the ability upgraded.
	 */
	@DatabaseField
	private int ability;
	/**
	 * Time since match start that the ability was upgraded.
	 */
	@DatabaseField
	private int time;
	/**
	 * The level of the player at time of upgrading.
	 */
	@DatabaseField
	private int level;

	public int getAbility() {
		return ability;
	}

	public void setAbility(int ability) {
		this.ability = ability;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public DotaPlayer getPlayer() {
		return player;
	}

	public void setPlayer(DotaPlayer player) {
		this.player = player;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
