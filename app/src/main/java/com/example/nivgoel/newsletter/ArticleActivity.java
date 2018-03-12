package com.example.nivgoel.newsletter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article);
       // WebView webView=(WebView)findViewById(R.id.webview);
        WebView webView = (WebView)findViewById(R.id.webview);
        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            String newUrl = extras.getString("url");
            webView.loadUrl(newUrl);
        }

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

    }
}
