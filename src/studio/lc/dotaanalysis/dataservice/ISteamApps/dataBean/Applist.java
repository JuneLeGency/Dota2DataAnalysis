package studio.lc.dotaanalysis.dataservice.ISteamApps.dataBean;

import java.io.Serializable;

public class Applist implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Apps applist;

	public Apps getApplist() {
		return applist;
	}

	public void setApplist(Apps applist) {
		this.applist = applist;
	}

}
