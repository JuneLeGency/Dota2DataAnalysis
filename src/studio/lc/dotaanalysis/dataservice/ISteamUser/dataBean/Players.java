package studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean;

import java.util.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName="myfriend")
public class Players {
	@DatabaseField(id=true)
	String id;
	@ForeignCollectionField(eager=true)
	Collection<Player> players;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Collection<Player> players) {
		this.players = players;
	}

	
	
}
