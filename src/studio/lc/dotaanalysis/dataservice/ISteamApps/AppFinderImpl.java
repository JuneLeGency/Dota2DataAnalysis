package studio.lc.dotaanalysis.dataservice.ISteamApps;

import studio.lc.dotaanalysis.dataservice.ISteamApps.dataBean.Apps;

import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.rest.RestService;

@EBean
public class AppFinderImpl implements AppFinder {

	@RestService
	ISteamAppsDP dataservice;

	@Override
	public Apps findAll() {
		return dataservice.GetAppList().getApplist();		
	}
	

}
