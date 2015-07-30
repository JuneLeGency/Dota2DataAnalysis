//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis.dataservice.ISteamUser;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import studio.lc.dotaanalysis.BaseActivity;

public final class FriendAdapter_
    extends FriendAdapter
{

    private Context context_;

    private FriendAdapter_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    public void afterSetContentView_() {
        if (!(context_ instanceof Activity)) {
            return ;
        }
        ((PlayerFinderImpl_) playerFinder).afterSetContentView_();
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
        if (context_ instanceof BaseActivity) {
            context = ((BaseActivity) context_);
        }
        playerFinder = PlayerFinderImpl_.getInstance_(context_);
        initAdapter();
    }

    public static FriendAdapter_ getInstance_(Context context) {
        return new FriendAdapter_(context);
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}
