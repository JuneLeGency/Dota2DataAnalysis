package studio.lc.dotaanalysis;

import studio.lc.dotaanalysis.dataservice.IDotaMatch.NewMatchAdapter;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Match;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ItemClick;
import com.googlecode.androidannotations.annotations.ViewById;
import com.tjerkw.slideexpandable.library.ActionSlideExpandableListView;

@EActivity(R.layout.match_activity)
public class MatchActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i("构造中", "构造中");
		super.onCreate(savedInstanceState);
	}

	@Bean
	NewMatchAdapter matchAdapter;

	@ViewById
	ActionSlideExpandableListView list;

	@AfterViews
	void setview() {
		list.setAdapter(matchAdapter);
	}
	
	
	@ItemClick
    void matchesItemClicked(Match match) {
		Toast.makeText(this, match.getFirst_blood_time() + " " + match.getMatch_id(), Toast.LENGTH_SHORT).show();
		Intent intent=new Intent(this, HerosActivity_.class);
		startActivity(intent);
    }	
}
