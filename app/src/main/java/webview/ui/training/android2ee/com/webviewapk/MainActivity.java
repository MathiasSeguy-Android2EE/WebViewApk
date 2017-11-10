package webview.ui.training.android2ee.com.webviewapk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView browser;
    CallBack webViewClient;
    Button btnPrevious,btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create the view
        setContentView(R.layout.activity_main);
        //update the toolbar (for color change them in the values/colors.xml file)
        getSupportActionBar().setTitle("A simple example");
        getSupportActionBar().setSubtitle("to yann");
        //find your components
        browser = (WebView) findViewById(R.id.webkit);
        btnPrevious=findViewById(R.id.btnPrevious);
        btnNext=findViewById(R.id.btnNext);
        //add listeners
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousPage();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextPage();
            }
        });
        // instanciate the webBrowser's events listener
        webViewClient = new CallBack();
        // link the listener to the browser else it will open the default browser (chrome or
        // whatever)
        browser.setWebViewClient(webViewClient);
        //Set javascript enable
        browser.getSettings().setJavaScriptEnabled(true);
        //Javascript can open a new window
        browser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //load an URL
        browser.loadUrl("https://www.com3elles.com/");
    }
    /***********************************************************
     *  Define your navigation methods
     **********************************************************/
    /**
     * Go to the next page
     */private void nextPage(){
         if(browser.canGoForward()){
             browser.goForward();
         }
    }
    /**
     * Go to the previous page
     */private void previousPage(){
        if(browser.canGoBack()){
            browser.goBack();
        }
    }
    /***********************************************************
     *  Define your callback
     **********************************************************/
    private class CallBack extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //if it's fine
            view.loadUrl(url);
            //else load something else
            return true;
        }
    }
}
