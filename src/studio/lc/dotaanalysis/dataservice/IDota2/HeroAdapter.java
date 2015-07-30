package studio.lc.dotaanalysis.dataservice.IDota2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.R;
import studio.lc.dotaanalysis.dataservice.BaseDataAdapter;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Heros;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.annotations.ViewById;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;

@EBean
public class HeroAdapter extends BaseDataAdapter<Heros> {
	public static final String JSON_CACHE_KEY = "appcachkey";
	
	public HeroAdapter(Context context) {
		super(Heros.class, context);
	}

	private List<Hero> list=new ArrayList<Hero>();
	
	@Bean(HeroFinderImpl.class)
    HeroFinder heroFinder;
	
	@RootContext
	BaseActivity context;
	
	
	@AfterInject
    void initAdapter() {
		getSpiceManager().execute(request, JSON_CACHE_KEY,
				DurationInMillis.ALWAYS_RETURNED, requestListener);
    }
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Hero getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HeroItem playerItemView;
        if (convertView == null) {
            playerItemView = HeroItem_.build(context);
        } else {
            playerItemView = (HeroItem) convertView;
        }
        
        playerItemView.bind(getItem(position));

        return playerItemView;
	}

	@Override
	protected Heros loadData() {		
		return heroFinder.findHeros();
	}

	@Override
	protected void dategetFailure(SpiceException arg0) {
		
	}


	@Override
	protected void dategetsuccess(Heros arg0) {
		Collection<Hero> a = arg0.getHeroes();
		list=CommonFunction.CollectiontoList(a);		
	}
}

@EViewGroup(R.layout.gv_hero)
class HeroItem extends RelativeLayout {
	private Context context;
    @ViewById
    ImageView heropic;

    @ViewById
    TextView heroname;
    

    public HeroItem(Context context) {
        super(context);
        this.context=context;
    }

    public void bind(Hero player) {
    	int resId = context.getResources().getIdentifier(player.getHeroname(), "drawable", context.getPackageName());
    	heropic.setImageResource(resId);
    	heroname.setText(player.getHeroname());
    }
    
}