package com.example.human.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.human.R;

/**
 *
 * Created by Millochka on 1/29/17.
 */

public class DonateWebView extends Activity {

    private WebView webView;
    private static final String TARGET_URL ="MYURL" ;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        Intent intent = getIntent();

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(intent.getStringExtra(TARGET_URL ));
    }

}
