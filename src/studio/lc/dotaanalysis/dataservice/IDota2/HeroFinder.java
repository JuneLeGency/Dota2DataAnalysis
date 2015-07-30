package studio.lc.dotaanalysis.dataservice.IDota2;

import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Heros;

import com.google.common.collect.ImmutableMap;

public interface HeroFinder {
	ImmutableMap<String, Hero> findAll();

	Heros findHeros();
}
