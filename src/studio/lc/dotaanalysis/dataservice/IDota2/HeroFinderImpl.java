package studio.lc.dotaanalysis.dataservice.IDota2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.Constants;
import studio.lc.dotaanalysis.dataservice.DatabaseHelper;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Heros;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.HerosResult;
import android.util.Log;

import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.OrmLiteDao;
import com.googlecode.androidannotations.annotations.rest.RestService;
import com.j256.ormlite.dao.Dao;

@EBean
public class HeroFinderImpl implements HeroFinder {

	@RestService
	IDotaHeroDP dataservice;

	@OrmLiteDao(helper = DatabaseHelper.class, model = Heros.class)
	Dao<Heros, Long> herosdao;

	@Override
	public ImmutableMap<String, Hero> findAll() {
		HerosResult herosResult = dataservice.GetHeroes(Constants.DotaId,
				CommonFunction.getLanguage());
		ImmutableMap<String, Hero> heromap = Maps.uniqueIndex(herosResult
				.getResult().getHeroes(), new Function<Hero, String>() {
			public String apply(Hero hero) {
				return hero.getId();
			}
		});
		Log.i("Êý¾ÝÍê±Ï", "Hero");
		return heromap;
	}

	@Override
	public Heros findHeros() {
		HerosResult herosResult = dataservice.GetHeroes(Constants.DotaId,
				CommonFunction.getLanguage());
		try {
			herosdao.create(herosResult.getResult());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collections.sort((ArrayList<Hero>) herosResult.getResult().getHeroes(),
				new Comparator<Hero>() {
					@Override
					public int compare(Hero lhs, Hero rhs) {
						return ComparisonChain.start()
								.compare(lhs.getHeroname(), rhs.getHeroname())
								.result();
					}
				});
		Heros a = herosResult.getResult();
		a.setId(Constants.DotaId);
		return a;
	}

}
