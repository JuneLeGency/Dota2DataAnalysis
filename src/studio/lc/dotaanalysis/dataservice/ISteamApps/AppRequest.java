package studio.lc.dotaanalysis.dataservice.ISteamApps;

import studio.lc.dotaanalysis.dataservice.ISteamApps.dataBean.Apps;
import android.content.Context;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.octo.android.robospice.request.SpiceRequest;
@EBean
public class AppRequest extends SpiceRequest< Apps > {
	@Bean(AppFinderImpl.class)
	AppFinder appFinder;
	
	@RootContext
	Context context;
	
    public AppRequest(Context context) {
        super(Apps.class);
        this.context=context;
    }

    @Override
    public Apps loadDataFromNetwork() throws Exception {    	
        return appFinder.findAll();
    }
    
}