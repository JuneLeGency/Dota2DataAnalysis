package studio.lc.dotaanalysis.dataservice.ISteamUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import studio.lc.dotaanalysis.BaseActivity;
import studio.lc.dotaanalysis.CommonFunction;
import studio.lc.dotaanalysis.R;
import studio.lc.dotaanalysis.dataservice.BaseDataAdapter;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Player;
import studio.lc.dotaanalysis.dataservice.ISteamUser.dataBean.Players;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.annotations.ViewById;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;

@EBean
public class FriendAdapter extends BaseDataAdapter<Players> {
	public static final String JSON_CACHE_KEY = "friendcache";
	
	public FriendAdapter(Context context) {
		super(Players.class, context);
	}

	private List<Player> list=new ArrayList<Player>();
	
	@Bean(PlayerFinderImpl.class)
    PlayerFinder playerFinder;
	
	@RootContext
	BaseActivity context;
	
	@AfterInject
    void initAdapter() {
		getSpiceManager().execute(request, JSON_CACHE_KEY,
				DurationInMillis.ALWAYS_RETURNED, requestListener);
//		getdata();
    }
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Player getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		PlayerItem playerItemView;
        if (convertView == null) {
            playerItemView = PlayerItem_.build(context);
        } else {
            playerItemView = (PlayerItem) convertView;
        }
        
        playerItemView.bind(getItem(position));

        return playerItemView;
	}

	@Override
	protected Players loadData() {
		return playerFinder.findAll();
	}

	@Override
	protected void dategetFailure(SpiceException arg0) {
		
	}


	@Override
	protected void dategetsuccess(Players arg0) {
		this.list=CommonFunction.CollectiontoList(arg0.getPlayers());
	}
}

@EViewGroup(R.layout.lv_friend)
class PlayerItem extends RelativeLayout {
	private Context context;
    @ViewById
    ImageView avatar;

    @ViewById
    TextView personaname;
    
    @ViewById
    TextView status;
    
    @ViewById
    TextView friendlattime;

    public PlayerItem(Context context) {
        super(context);
        this.context=context;
    }

    public void bind(Player player) {
    	UrlImageViewHelper.setUrlDrawable(avatar, player.getAvatarmedium());
    	personaname.setText(String.valueOf(player.getPersonaname()));
		status.setText("("+player.getpersonstatusString(context)+")");
		SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);  
		Date date=new Date(player.getLastlogoff()*1000);
		friendlattime.setText(sdf.format(date));
    }
}