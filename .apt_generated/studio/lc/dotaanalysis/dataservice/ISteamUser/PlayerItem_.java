//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis.dataservice.ISteamUser;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import studio.lc.dotaanalysis.R.id;
import studio.lc.dotaanalysis.R.layout;


/**
 * We use @SuppressWarning here because our java code
 * generator doesn't know that there is no need
 * to import OnXXXListeners from View as we already
 * are in a View.
 * 
 */
@SuppressWarnings("unused")
public final class PlayerItem_
    extends PlayerItem
{

    private Context context_;
    private boolean mAlreadyInflated_ = false;

    public PlayerItem_(Context context) {
        super(context);
        init_();
    }

    private void init_() {
        context_ = getContext();
        if (context_ instanceof Activity) {
            Activity activity = ((Activity) context_);
        }
    }

    private void afterSetContentView_() {
        avatar = ((ImageView) findViewById(id.avatar));
        personaname = ((TextView) findViewById(id.personaname));
        friendlattime = ((TextView) findViewById(id.friendlattime));
        status = ((TextView) findViewById(id.status));
    }

    /**
     * The mAlreadyInflated_ hack is needed because of an Android bug
     * which leads to infinite calls of onFinishInflate()
     * when inflating a layout with a parent and using
     * the <merge /> tag.
     * 
     */
    @Override
    public void onFinishInflate() {
        if (!mAlreadyInflated_) {
            mAlreadyInflated_ = true;
            inflate(getContext(), layout.lv_friend, this);
            afterSetContentView_();
        }
        super.onFinishInflate();
    }

    public static PlayerItem build(Context context) {
        PlayerItem_ instance = new PlayerItem_(context);
        instance.onFinishInflate();
        return instance;
    }

}
