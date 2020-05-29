package com.example.human.donate

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.human.R

private const val TARGET_URL = "MYURL"

class DonateWebViewActivity: AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_view)
        val intent = intent
        webView = findViewById(R.id.webView1)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(intent.getStringExtra(TARGET_URL))
    }
}