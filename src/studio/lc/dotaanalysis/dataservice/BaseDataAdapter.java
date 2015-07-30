package studio.lc.dotaanalysis.dataservice;

import studio.lc.dotaanalysis.CommonFunction;
import android.content.Context;
import android.widget.BaseAdapter;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public abstract class BaseDataAdapter<T> extends BaseAdapter {

	private Context context;

	protected BaseRequest<T> request;

	protected RequestListener<T> requestListener;

	public BaseDataAdapter(Class<T> clazz, Context context) {
		this.context = context;
		this.request = new BaseRequest<T>(clazz, context) {

			@Override
			protected T loadDataFrom() throws Exception {
				return loadData();
			}
		};

		requestListener = new RequestListener<T>() {

			@Override
			public void onRequestFailure(SpiceException arg0) {
				dategetFailure(arg0);
			}

			@Override
			public void onRequestSuccess(T arg0) {
				dategetsuccess(arg0);
				BaseDataAdapter.this.notifyDataSetChanged();
			}
		};
	}

	protected SpiceManager getSpiceManager() {
		return CommonFunction.getSpiceManager(context);
	}

//	protected void getdata() {
//		getSpiceManager().execute(request, Constants.JSON_CACHE_KEY,
//				DurationInMillis.ALWAYS_RETURNED, requestListener);
//	}

	abstract protected T loadData();

	abstract protected void dategetFailure(SpiceException arg0);

	abstract protected void dategetsuccess(T arg0);

}
