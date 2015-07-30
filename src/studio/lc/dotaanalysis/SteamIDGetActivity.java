package studio.lc.dotaanalysis;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.steamid_activity)
public class SteamIDGetActivity extends Activity {	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_PROGRESS);
		super.onCreate(savedInstanceState);
	}

	@ViewById
	WebView openidwebview;
	
	@AfterViews
	void signin() {
		CookieSyncManager.createInstance(getApplicationContext());
		
		Intent intent = getIntent();
	    if (intent.getData() != null) {
	    	openidwebview.loadUrl(intent.getDataString());
	    }
//		openidwebview.loadUrl(url);
		openidwebview.getSettings().setJavaScriptEnabled(true);
		openidwebview.setWebChromeClient(new WebChromeClient() {
		     // Show loading progress in activity's title bar.
		      @Override
		      public void onProgressChanged(WebView view, int progress) {
		        setProgress(progress * 100);
		      }
		    });
		openidwebview.setWebViewClient(new WebViewClient() {
		     // When start to load page, show url in activity's title bar
		      @Override
		      public void onPageStarted(WebView view, String url,
		         Bitmap favicon) {
		        setTitle(url);
		      }
		      
		      @Override
		      public void onPageFinished(WebView view, String url) {
		    	 Log.i("url", url);
		        CookieSyncManager.getInstance().sync();
		        // Get the cookie from cookie jar.
		        String cookie = CookieManager.getInstance().getCookie(url);
		        if (cookie == null) {
		          return;
		        }
		        // Cookie is a string like NAME=VALUE [; NAME=VALUE]
		        String[] pairs = cookie.split(";");
		        for (int i = 0; i < pairs.length; ++i) {
		          String[] parts = pairs[i].split("=", 2);
		          // If token is found, return it to the calling activity.
		          if (parts.length == 2 &&
		             parts[0].equalsIgnoreCase("steamID")) {
		        	  
		            Intent result = new Intent();
		            Log.i("steamID", parts[1]);
		            result.putExtra("steamID", parts[1]);
		            setResult(RESULT_OK, result);
		            finish();
		          }
		        }
		      }
		    });
		
	}	
}
