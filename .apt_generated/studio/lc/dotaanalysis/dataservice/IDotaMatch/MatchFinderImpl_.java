//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.SteamPrefs_;
import studio.lc.dotaanalysis.dataservice.IDota2.IDotaHeroDP_;

public final class MatchFinderImpl_
    extends MatchFinderImpl
{

    private Context context_;

    private MatchFinderImpl_(Context context) {
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
        pref = new SteamPrefs_(context_);
        dataservice = new IDotaHeroDP_();
        dotadataservice = new IDotaMatchDP_();
        if (context_ instanceof BaseActivity) {
            context = ((BaseActivity) context_);
        }
    }

    public static MatchFinderImpl_ getInstance_(Context context) {
        return new MatchFinderImpl_(context);
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}
