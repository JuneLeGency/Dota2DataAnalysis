//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import studio.lc.dotaanalysis.R.layout;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.NewMatchAdapter_;
import studio.lc.dotaanalysis.dataservice.IDotaMatch.dataBean.Match;

public final class MatchActivity_
    extends MatchActivity
{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(layout.match_activity);
    }

    private void init_(Bundle savedInstanceState) {
        matchAdapter = NewMatchAdapter_.getInstance_(this);
    }

    private void afterSetContentView_() {
        {
            AdapterView<?> view = ((AdapterView<?> ) findViewById(studio.lc.dotaanalysis.R.id.matches));
            if (view!= null) {
                view.setOnItemClickListener(new OnItemClickListener() {


                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        matchesItemClicked(((Match) parent.getAdapter().getItem(position)));
                    }

                }
                );
            }
        }
        ((NewMatchAdapter_) matchAdapter).afterSetContentView_();
        setview();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        afterSetContentView_();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        afterSetContentView_();
    }

    public static MatchActivity_.IntentBuilder_ intent(Context context) {
        return new MatchActivity_.IntentBuilder_(context);
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, MatchActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public MatchActivity_.IntentBuilder_ flags(int flags) {
            intent_.setFlags(flags);
            return this;
        }

        public void start() {
            context_.startActivity(intent_);
        }

        public void startForResult(int requestCode) {
            if (context_ instanceof Activity) {
                ((Activity) context_).startActivityForResult(intent_, requestCode);
            } else {
                context_.startActivity(intent_);
            }
        }

    }

}
