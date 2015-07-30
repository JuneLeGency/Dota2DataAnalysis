package studio.lc.dotaanalysis.dataservice.IDota2.dataBean;

import java.util.Collection;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName="heros")
public class Heros {
	
	public Heros() {
		super();
	}
	@DatabaseField(id=true)
    private int id;
	
	@ForeignCollectionField(eager = false)	
	private Collection<Hero> heroes;
	
	@DatabaseField
	private int count;
	
	
	public Collection<Hero> getHeroes() {
		return heroes;
	}
	public void setHeroes(Collection<Hero> heroes) {
		this.heroes = heroes;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
