package studio.lc.dotaanalysis.dataservice.IDota2.dataBean;

import studio.lc.dotaanalysis.Constants;
import android.content.Context;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "hero")
public class Hero {

	public Hero() {
		super();
	}

	/**
	 * 
	 The tokenized string for the name of the hero.
	 */
	@DatabaseField
	private String name;

	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "heros_id")
	private Heros heros;
	/**
	 * 
	 ID of the hero.
	 */
	@DatabaseField(id = true)
	private String id;
	/**
	 * 
	 The localized name of the hero for use in name display.
	 */
	@DatabaseField
	private String localized_name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;

	}

	public String getLocalized_name() {
		return localized_name;
	}

	public void setLocalized_name(String localized_name) {
		this.localized_name = localized_name;
	}

	public String getHeroname() {
		return name.replace("npc_dota_hero_", "");
	}

	public String getHeronImageFull(int type) {
		String herourl = null;
		String name = getHeronImage(type);
		switch (type) {
		case 1:
			herourl = name.concat(".png");
			break;
		case 2:
			herourl = name.concat(".png");
			break;
		case 3:
			herourl = name.concat(".png");
			break;
		case 4:
			herourl = name.concat(".jpg");
			break;
		default:
			herourl = name.concat(".png");
			break;
		}
		return herourl;
	}

	public String getHeronImage(int type) {
		String herourl = null;
		switch (type) {
		case 1:
			herourl = getHeroname().concat("_sb");
			break;
		case 2:
			herourl = getHeroname().concat("_lg");
			break;
		case 3:
			herourl = getHeroname().concat("_full");
			break;
		case 4:
			herourl = getHeroname().concat("_vert");
			break;
		default:
			herourl = getHeroname();
			break;
		}
		return herourl;
		// 1) tiny horizontal portrait - 35x20px
		// <suffix> = eb.png
		// 2) small horizontal portrait - 59x33px
		// <suffix> = sb.png
		// 3) large horizontal portrait - 205x11px
		// <suffix> = lg.png
		// 4) full quality horizontal portrait - 256x114px
		// <suffix> = full.png
		// 5) full quality vertical portrait - 234x272px
		// <suffix> = vert.jpg
	}

	public String getHeroUrl(int type) {
		return Constants.HeroImageUrl + getHeronImageFull(type);
	}

	public int getHeroResource(Context context, int type) {
		return context.getResources().getIdentifier(getHeronImage(type),
				"drawable", context.getPackageName());
	}

}
