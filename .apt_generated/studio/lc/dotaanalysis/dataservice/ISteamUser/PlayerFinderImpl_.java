//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis.dataservice.ISteamUser;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import studio.lc.dotaanalysis.SteamPrefs_;

public final class PlayerFinderImpl_
    extends PlayerFinderImpl
{

    private Context context_;

    private PlayerFinderImpl_(Context context) {
        context_ = context;
        init_();
    }

    public void afterSetContentView_() {
        if (!(context_ instanceof Activity)) {
            return ;
        }
    }

    /**
     * You should check that context is an activity before calling this method
     * 
     */
    public View findViewById(int id) {
        Activity activity_ = ((Activity) context_);
        return activity_.findViewById(id);
    }

    @SuppressWarnings("all")
    private void init_() {
        if (context_ instanceof Activity) {
            Activity activity = ((Activity) context_);
        }
        prefs = new SteamPrefs_(context_);
        userdataservice = new ISteamUserDP_();
    }

    public static PlayerFinderImpl_ getInstance_(Context context) {
        return new PlayerFinderImpl_(context);
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}
