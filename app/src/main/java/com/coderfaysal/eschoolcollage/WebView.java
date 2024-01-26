package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class WebView extends AppCompatActivity {

    TextView toolbarTitle;
    ImageView backPres;
    LinearLayout layNonet, layRoot;
    android.webkit.WebView webView;
    public static String BOOK_TITLE = "";
    String USER_AGENT_ = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
    public static String WEB_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);


        backPres = findViewById(R.id.backPres);
        toolbarTitle = findViewById(R.id.toolbarTitle);

        toolbarTitle.setText(BOOK_TITLE);

        backPres.setOnClickListener(v -> {
            onBackPressed();
        });


        layNonet = findViewById(R.id.layNonet);
        layRoot = findViewById(R.id.layRoot);

        //Creating webView programmatically which supports media player and js automatically like a browser
        webView = new android.webkit.WebView(WebView.this);
        webView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        webView.setFitsSystemWindows(false); // your preferences
        webView.setPadding(10,10,10,10); // your preferences


        // Enabling some setting so that browser can work properly
        webView.getSettings().setUserAgentString(USER_AGENT_);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webView.getSettings().setBuiltInZoomControls(true);


        //-------------------new setting
        webView.getSettings().setBlockNetworkLoads (false);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.getSettings().setDomStorageEnabled(true);

        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }


        //initialize WebView
        webView = findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(WEB_URL);


        if(!isNetworkAvailable(WebView.this)){
            layRoot.setVisibility(View.GONE);
            layNonet.setVisibility(View.VISIBLE);
        }else{
            layRoot.setVisibility(View.VISIBLE);
            layNonet.setVisibility(View.GONE);
        }




    } // OnCreate method close here =============


    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo() != null;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}