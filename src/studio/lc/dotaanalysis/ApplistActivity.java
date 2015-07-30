package studio.lc.dotaanalysis;

import studio.lc.dotaanalysis.dataservice.ISteamApps.ISteamAppsDP;
import studio.lc.dotaanalysis.dataservice.ISteamApps.AppAdapter;
import android.widget.ListView;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.rest.RestService;

@EActivity(R.layout.apps_activity)
public class ApplistActivity extends BaseActivity {

	@Bean
	AppAdapter appadapter;

	@RestService
	ISteamAppsDP iSteamApps;

	@ViewById
	ListView applist;

	@AfterViews
	void setview() {
		applist.setAdapter(appadapter);
	}

}
