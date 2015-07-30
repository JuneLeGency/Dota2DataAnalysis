package studio.lc.dotaanalysis;

import studio.lc.dotaanalysis.dataservice.DatabaseHelper;
import studio.lc.dotaanalysis.dataservice.IDota2.HeroAdapter;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import android.widget.GridView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.OrmLiteDao;
import com.googlecode.androidannotations.annotations.ViewById;
import com.j256.ormlite.dao.Dao;

@EActivity(R.layout.heros_activity)
public class HerosActivity extends BaseActivity {
	@ViewById
	GridView heros;

	@Bean
	HeroAdapter adapter;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Hero.class)
	Dao<Hero, Long> herodao;

	@AfterViews
	void setdata() {
		heros.setAdapter(adapter);
	}	

}
