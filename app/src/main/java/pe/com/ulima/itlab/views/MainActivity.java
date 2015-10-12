package pe.com.ulima.itlab.views;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
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
                webview2.loadDataWithBaseURL("file:///android_asset/", documento, "text/html", "UTF-8", null);
                break;
            case Configuration.ORIENTATION_PORTRAIT:
                WebView webview = (WebView)this.findViewById(R.id.webView);
                webview.loadDataWithBaseURL("file:///android_asset/", documento, "text/html", "UTF-8", null);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
