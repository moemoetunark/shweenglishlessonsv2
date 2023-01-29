package siam.moemoetun.com.shwedailyenglish.ui.webview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


import java.util.Objects;

import siam.moemoetun.com.shwedailyenglish.R;

public class OnlineLessons extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_lessons);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        if(hasConnect()){
            webView = findViewById(R.id.webview);
            webView.loadUrl("https://shwe-daily-english2.web.app/");
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
        }else {
            showDialog();
        }

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasConnect()){
                    webView.reload();
                }else {
                    showDialog();
                }
            }
        });




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    public void showDialog(){
        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("You have no Internet!")
                .setIcon(R.drawable.nointernet)
                .setCancelable(false)
                .setPositiveButton("Go Back", (dialogInterface, i) -> {
                    OnlineLessons.super.onBackPressed();
                }).show();
    }

    public boolean hasConnect(){
        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        boolean isConnected = (info!= null && info.isConnected() && info.isAvailable());
        return isConnected;
    }


}