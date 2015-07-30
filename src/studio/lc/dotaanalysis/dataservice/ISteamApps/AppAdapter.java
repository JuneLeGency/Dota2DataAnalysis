package studio.lc.dotaanalysis.dataservice.ISteamApps;

import java.util.ArrayList;
import java.util.List;

import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.R;
import studio.lc.dotaanalysis.dataservice.BaseDataAdapter;
import studio.lc.dotaanalysis.dataservice.ISteamApps.dataBean.App;
import studio.lc.dotaanalysis.dataservice.ISteamApps.dataBean.Apps;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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

@EViewGroup(R.layout.lv_app)
class AppItem extends RelativeLayout {

	@ViewById
	TextView appid;

	@ViewById
	TextView appname;

	public AppItem(Context context) {
		super(context);
	}

	public void bind(App a) {
		appid.setText(String.valueOf(a.getAppid()));
		appname.setText(a.getName());
	}
}

@EBean
public class AppAdapter extends BaseDataAdapter<Apps> {

	private static final String JSON_CACHE_KEY = "appcache";

	public AppAdapter(Context context) {
		super(Apps.class, context);
	}

	private List<App> apps = new ArrayList<App>();

	@RootContext
	BaseActivity context;

	@Bean(AppFinderImpl.class)
	AppFinder appFinder;

	@AfterInject
	protected void getdata() {
		getSpiceManager().execute(request, JSON_CACHE_KEY,
				DurationInMillis.ALWAYS_RETURNED, requestListener);
	}

	@Override
	public int getCount() {
		return apps.size();
	}

	@Override
	public App getItem(int position) {
		return apps.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		AppItem appItem;
		if (convertView == null) {
			appItem = AppItem_.build(context);
		} else {
			appItem = (AppItem) convertView;
		}

		appItem.bind(getItem(position));

		return appItem;
	}

	@Override
	protected void dategetsuccess(Apps arg0) {
		this.apps = arg0.getApps();
	}

	@Override
	protected void dategetFailure(SpiceException arg0) {

	}

	@Override
	protected Apps loadData() {
		return appFinder.findAll();
	}

}