//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis.dataservice.IDotaMatch;

import java.sql.SQLException;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.dataservice.DatabaseHelper;
import studio.lc.dotaanalysis.dataservice.IDota2.dataBean.Hero;

public final class PlayerAdapter_
    extends PlayerAdapter
{

    private Context context_;
    private ConnectionSource connectionSource_;

    private PlayerAdapter_(Context context) {
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
        connectionSource_ = OpenHelperManager.getHelper(context_, DatabaseHelper.class).getConnectionSource();
        try {
            herodao = DaoManager.createDao(connectionSource_, Hero.class);
        } catch (SQLException e) {
            Log.e("PlayerAdapter_", "Could not create DAO", e);
        }
        if (context_ instanceof BaseActivity) {
            context = ((BaseActivity) context_);
        }
    }

    public static PlayerAdapter_ getInstance_(Context context) {
        return new PlayerAdapter_(context);
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}