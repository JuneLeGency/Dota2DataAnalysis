package studio.lc.dotaanalysis.dataservice.IDota2;

import android.content.Context;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;

import studio.lc.dotaanalysis.dataservice.BaseRequest;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Heros;
@EBean
public class HeroRequest extends BaseRequest<Heros> {
	
	public HeroRequest(Context context) {
		super(Heros.class, context);
	}

	@Bean(HeroFinderImpl.class)
	HeroFinder heroFinder;
	
	@Override
	protected Heros loadDataFrom() throws Exception {
		return heroFinder.findHeros();
	}

}
