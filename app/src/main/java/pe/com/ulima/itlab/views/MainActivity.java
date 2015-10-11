package pe.com.ulima.itlab.views;

import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;

import pe.com.ulima.itlab.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String documento = extras.getString("doc");

        int ot = getResources().getConfiguration().orientation;
        switch(ot)
        {
            case  Configuration.ORIENTATION_LANDSCAPE:
                WebView webview2 = (WebView)this.findViewById(R.id.webView2);
                webview2.loadData(documento, "text/html; charset=utf-8", "UTF-8");
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                WebView webview = (WebView)this.findViewById(R.id.webView);
                webview.loadData(documento, "text/html; charset=utf-8", "UTF-8");
                break;
        }


    }



}
