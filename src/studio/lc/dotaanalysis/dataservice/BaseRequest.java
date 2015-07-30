package studio.lc.dotaanalysis.dataservice;

import android.content.Context;

import com.octo.android.robospice.request.SpiceRequest;
public abstract class BaseRequest<T> extends SpiceRequest<T>{
	
	Context context;
	public BaseRequest(Class<T> clazz,Context context) {
		super(clazz);
		this.context=context;
	}

	@Override
	public T loadDataFromNetwork() throws Exception {
		return loadDataFrom();
	}
	protected abstract T loadDataFrom()throws Exception;
}
