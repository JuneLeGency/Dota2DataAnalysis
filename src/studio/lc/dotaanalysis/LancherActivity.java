package studio.lc.dotaanalysis;

import studio.lc.dotaanalysis.dataservice.IDota2.HeroRequest;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Heros;
import android.content.Intent;
import android.os.Bundle;

import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
@EActivity(R.layout.lanucher_activity)
public class LancherActivity extends BaseActivity {

	private static final String JSON_CACHE_KEY = "inithero";

	@Bean
	HeroRequest request;
	public RequestListener<Heros> requestListener = new RequestListener<Heros>() {

		@Override
		public void onRequestSuccess(Heros arg0) {
			Intent intent = new Intent(LancherActivity.this, SignInActivity_.class);
			startActivity(intent);
		}

		@Override
		public void onRequestFailure(SpiceException arg0) {

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onStart() {
		super.onStart();
		getSpiceManager().execute(request, JSON_CACHE_KEY,
				DurationInMillis.ALWAYS_RETURNED, requestListener);
	}

}
