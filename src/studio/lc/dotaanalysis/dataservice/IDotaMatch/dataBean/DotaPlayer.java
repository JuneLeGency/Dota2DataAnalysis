package studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean;

import java.util.Collection;
import java.util.List;

import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.DotaMath;

import android.content.Context;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

;
/**
 * @author legency
 * 
 */
@DatabaseTable(tableName = "dotaplayer")
public class DotaPlayer {
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "whichmatch")
	private Match match;
	/**
	 * Ö÷¼ü
	 */
	@DatabaseField(generatedId = true)
	private int id;
	/**
	 * 32-bit account ID.
	 * 
	 */
	@DatabaseField
	private long account_id;
	/**
	 * 
	 * 
	 */
	@DatabaseField
	private int player_slot;
	/**
	 * 
	 The hero's unique ID. A list of hero IDs can be found via the GetHeroes
	 * method.
	 */
	@DatabaseField
	private int hero_id;

	/**
	 * ID of the top-left inventory item.
	 */
	@DatabaseField
	private int item_0;
	/**
	 * ID of the top-center inventory item.
	 */
	@DatabaseField
	private int item_1;
	/**
	 * ID of the top-right inventory item.
	 */
	@DatabaseField
	private int item_2;
	/**
	 * ID of the bottom-left inventory item.
	 */
	@DatabaseField
	private int item_3;
	/**
	 * ID of the bottom-center inventory item.
	 */
	@DatabaseField
	private int item_4;
	/**
	 * ID of the bottom-right inventory item.
	 */
	@DatabaseField
	private int item_5;
	@DatabaseField
	private int kills;
	@DatabaseField
	private int deaths;
	@DatabaseField
	private int assists;
	@DatabaseField
	private int leaver_status;
	/**
	 * The amount of gold the player had remaining at the end of the match.
	 */
	@DatabaseField
	private int gold;
	@DatabaseField
	private int last_hits;
	@DatabaseField
	private int denies;
	@DatabaseField
	private int gold_per_min;
	@DatabaseField
	private int xp_per_min;
	/**
	 * The amount of gold the player spent during the match.
	 */
	@DatabaseField
	private int gold_spent;
	@DatabaseField
	private int hero_damage;
	@DatabaseField
	private int tower_damage;
	@DatabaseField
	private int hero_healing;
	@DatabaseField
	private int level;
	@ForeignCollectionField(eager = true)
	private Collection<Ability> ability_upgrades;
	@ForeignCollectionField(eager = true)
	private Collection<Unit> additional_units;

	public int getItem_0() {
		return item_0;
	}

	public void setItem_0(int item_0) {
		this.item_0 = item_0;
	}

	public int getItem_1() {
		return item_1;
	}

	public void setItem_1(int item_1) {
		this.item_1 = item_1;
	}

	public int getItem_2() {
		return item_2;
	}

	public void setItem_2(int item_2) {
		this.item_2 = item_2;
	}

	public int getItem_3() {
		return item_3;
	}

	public void setItem_3(int item_3) {
		this.item_3 = item_3;
	}

	public int getItem_4() {
		return item_4;
	}

	public void setItem_4(int item_4) {
		this.item_4 = item_4;
	}

	public int getItem_5() {
		return item_5;
	}

	public void setItem_5(int item_5) {
		this.item_5 = item_5;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getLeaver_status() {
		return leaver_status;
	}

	public void setLeaver_status(int leaver_status) {
		this.leaver_status = leaver_status;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getLast_hits() {
		return last_hits;
	}

	public void setLast_hits(int last_hits) {
		this.last_hits = last_hits;
	}

	public int getDenies() {
		return denies;
	}

	public void setDenies(int denies) {
		this.denies = denies;
	}

	public int getGold_per_min() {
		return gold_per_min;
	}

	public void setGold_per_min(int gold_per_min) {
		this.gold_per_min = gold_per_min;
	}

	public int getXp_per_min() {
		return xp_per_min;
	}

	public void setXp_per_min(int xp_per_min) {
		this.xp_per_min = xp_per_min;
	}

	public int getGold_spent() {
		return gold_spent;
	}

	public void setGold_spent(int gold_spent) {
		this.gold_spent = gold_spent;
	}

	public int getHero_damage() {
		return hero_damage;
	}

	public void setHero_damage(int hero_damage) {
		this.hero_damage = hero_damage;
	}

	public int getTower_damage() {
		return tower_damage;
	}

	public void setTower_damage(int tower_damage) {
		this.tower_damage = tower_damage;
	}

	public int getHero_healing() {
		return hero_healing;
	}

	public void setHero_healing(int hero_healing) {
		this.hero_healing = hero_healing;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public Collection<Ability> getAbility_upgrades() {
		return ability_upgrades;
	}

	public void setAbility_upgrades(Collection<Ability> ability_upgrades) {
		this.ability_upgrades = ability_upgrades;
	}

	public Collection<Unit> getAdditional_units() {
		return additional_units;
	}

	public void setAdditional_units(Collection<Unit> additional_units) {
		this.additional_units = additional_units;
	}

	public void setAdditional_units(List<Unit> additional_units) {
		this.additional_units = additional_units;
	}

	public long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}

	public int getPlayer_slot() {
		return player_slot;
	}

	public void setPlayer_slot(int player_slot) {
		this.player_slot = player_slot;
	}

	public int getHero_id() {
		return hero_id;
	}

	public void setHero_id(int hero_id) {
		this.hero_id = hero_id;
	}

	public boolean isRadiant() {
		return DotaMath.isRadiant(player_slot);
	}

	public int getposition() {
		return DotaMath.getplayerposition(player_slot);
	}

	public boolean isAnymos() {
		return account_id == 4294967295l;
	}

	public boolean isCurrentUser(Context context) {
		return account_id == CommonFunction.getAccountid(context);
	}
}
