package webview.ui.training.android2ee.com.webviewapk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browser = (WebView) findViewById(R.id.webkit);
        //load an URL
        browser.loadUrl("https://www.com3elles.com/");
        //Set javascript enable
        browser.getSettings().setJavaScriptEnabled(true);
        //Javascript can open a new window
        browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    }
}
