//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis.dataservice.IDota2;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public final class HeroRequest_
    extends HeroRequest
{

    private Context context_;

    private HeroRequest_(Context context) {
        super(context);
        context_ = context;
        init_();
    }

    public void afterSetContentView_() {
        if (!(context_ instanceof Activity)) {
            return ;
        }
        ((HeroFinderImpl_) heroFinder).afterSetContentView_();
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
        heroFinder = HeroFinderImpl_.getInstance_(context_);
    }

    public static HeroRequest_ getInstance_(Context context) {
        return new HeroRequest_(context);
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}
