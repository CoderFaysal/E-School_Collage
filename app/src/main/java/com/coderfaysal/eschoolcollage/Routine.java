package com.coderfaysal.eschoolcollage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Routine extends AppCompatActivity {

    ImageView backPres;
    LinearLayout layNonet;
    RelativeLayout layRoot;
    WebView webView;
    FloatingActionButton fab;
    String USER_AGENT_ = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";
    public static String WEB_URL = "https://docs.google.com/document/d/1bj_SQKJ29Ecoc8tTkiTv7qfFxo_x0NBT7oR3MaScp4U";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        backPres = findViewById(R.id.backPres);
        backPres.setOnClickListener(v -> {
            onBackPressed();
        });

        layNonet = findViewById(R.id.layNonet);
        layRoot = findViewById(R.id.layRoot);

        //Creating webView programmatically which supports media player and js automatically like a browser
        webView = new WebView(Routine.this);
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


        //webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebViewClient(new HelloWebViewClient());
        webView.setWebChromeClient(new ChromeClient());


        //-------------------new setting
        webView.getSettings().setBlockNetworkLoads (false);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.getSettings().setDomStorageEnabled(true);

        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }


        //initialize WebView
        webView = findViewById(R.id.webView);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code Here ==========
                createWebPrintJob(webView);
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(WEB_URL);


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Hide the progress bar when the page finishes loading
                fab.setVisibility(View.VISIBLE);
            }
        });



        if(!isNetworkAvailable(Routine.this)){
            layRoot.setVisibility(View.GONE);
            layNonet.setVisibility(View.VISIBLE);
        }else{
            layRoot.setVisibility(View.VISIBLE);
            layNonet.setVisibility(View.GONE);
        }




    } // OnCreate method close here =============
    private void createWebPrintJob(WebView webView) {
        PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);
        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();
        String jobName = getString(R.string.app_name) + " Print Result";
        printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());
    }


    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo() != null;
    }

    // =================================================


    //================================================= defining custom class (HelloWebViewClient)
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }
    //=================================================



    //================================================= defining custom class (ChromeClient)
    private class ChromeClient extends WebChromeClient {
        // Defining some variables


        private View mCustomView;
        private CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        ChromeClient() {
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}