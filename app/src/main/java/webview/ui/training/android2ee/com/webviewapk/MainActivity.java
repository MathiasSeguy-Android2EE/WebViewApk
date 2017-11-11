package webview.ui.training.android2ee.com.webviewapk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
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
        browser.loadUrl(getString(R.string.root_url));
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
            Log.e(TAG,"The url that should be loaded "+url);
            String urlToLoad=getString(R.string.root_url);
            //if it's fine
            if(url.contains(getString(R.string.core))){
                Log.e(TAG,"The url contains "+getString(R.string.core));
                Log.e(TAG,"The url is "+url+", the R.string.root_url "+getString(R.string.root_url)+" and are equals: "+(url.equalsIgnoreCase(getString(R.string.root_url))));

                if(url.equalsIgnoreCase(getString(R.string.root_url))){
                    urlToLoad=url+"/index.php?tmpl=component";
                }else{
                    urlToLoad=url+"?tmpl=component";
                }
            }
            Log.e(TAG,"The url that is really loaded is "+urlToLoad);
            view.loadUrl(urlToLoad);
            //else load something else
            return true;
        }
    }
}
