//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package studio.lc.dotaanalysis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import studio.lc.dotaanalysis.R.id;
import studio.lc.dotaanalysis.R.layout;
import studio.lc.dotaanalysis.customwidget.ProfileItem;
import studio.lc.dotaanalysis.dataservice.ISteamUser.FriendRequest_;

public final class SignInActivity_
    extends SignInActivity
{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(layout.signin_activity);
    }

    private void init_(Bundle savedInstanceState) {
        prefs = new SteamPrefs_(this);
        request = FriendRequest_.getInstance_(this);
    }

    private void afterSetContentView_() {
        signin = ((View) findViewById(id.signin));
        heros = ((View) findViewById(id.heros));
        notlogin = ((View) findViewById(id.notlogin));
        herolist = ((View) findViewById(id.herolist));
        profileItem = ((ProfileItem) findViewById(id.profile));
        {
            View view = findViewById(id.heros);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        SignInActivity_.this.heros();
                    }

                }
                );
            }
        }
        {
            View view = findViewById(id.signin);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        SignInActivity_.this.getSteamId();
                    }

                }
                );
            }
        }
        {
            View view = findViewById(id.herolist);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        SignInActivity_.this.herolist();
                    }

                }
                );
            }
        }
        {
            View view = findViewById(id.export);
            if (view!= null) {
                view.setOnClickListener(new OnClickListener() {


                    @Override
                    public void onClick(View view) {
                        SignInActivity_.this.exprot();
                    }

                }
                );
            }
        }
        ((FriendRequest_) request).afterSetContentView_();
        getdata();
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

    public static SignInActivity_.IntentBuilder_ intent(Context context) {
        return new SignInActivity_.IntentBuilder_(context);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        SignInActivity_.super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case  0 :
                SignInActivity_.this.onResult(resultCode, data);
                break;
        }
    }

    public static class IntentBuilder_ {

        private Context context_;
        private final Intent intent_;

        public IntentBuilder_(Context context) {
            context_ = context;
            intent_ = new Intent(context, SignInActivity_.class);
        }

        public Intent get() {
            return intent_;
        }

        public SignInActivity_.IntentBuilder_ flags(int flags) {
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