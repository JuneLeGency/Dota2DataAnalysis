package studio.lc.dotaanalysis.dataservice;

import java.sql.SQLException;

import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Heros;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	
	private static final int VERSION = 1;
	final static String DATABASE_FILENAME = "dotasteam";
	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public DatabaseHelper(Context context) {
		super(context, DATABASE_FILENAME, null, VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		
//		try {
//			TableUtils.createTable(arg1, Heros.class);
//			TableUtils.createTable(arg1, Hero.class);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		
	}
	
	

}
