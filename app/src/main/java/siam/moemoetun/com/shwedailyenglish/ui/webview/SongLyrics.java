package siam.moemoetun.com.shwedailyenglish.ui.webview;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.IOException;
import java.io.InputStream;

import siam.moemoetun.com.shwedailyenglish.R;

public class SongLyrics extends AppCompatActivity {

    TextView textView;
    Typeface typeface;
    public InputStream input;
  //  private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    //private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voca_textview);

        MobileAds.initialize(this, initializationStatus -> {
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        //mAdView = findViewById(R.id.adView);
        //mAdView.loadAd(adRequest);

        InterstitialAd.load(SongLyrics.this, getString(R.string.inter_goback),
                adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });
       // mAdView = findViewById(R.id.adView);
       // AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        //AdView adView = new AdView(this);
        //adView.setAdSize(AdSize.SMART_BANNER);
        //adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");


        textView = (TextView)findViewById(R.id.textView2);
        typeface = Typeface.createFromAsset(getAssets(), "fonts/Zawgyi-One.ttf");
        textView.setTypeface(this.typeface);
        AssetManager assets = this.getAssets();

        int intExtra = getIntent().getIntExtra("key", 0);
        if (intExtra == 0) {
            try {
                this.input = assets.open("lyrics/Cry on my shoulder.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 1) {
            try {
                this.input = assets.open("lyrics/Flashlight by Jessie J.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 2) {
            try {
                this.input = assets.open("lyrics/Forgiveness Lyrics Translation.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 3) {
            try {
                this.input = assets.open("lyrics/I Will Be Right Here Waiting For You Lyrics.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 4) {
            try {
                this.input = assets.open("lyrics/Imagine me without you.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 5) {
            try {
                this.input = assets.open("lyrics/Just Give Me a Reason Lyrics.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 6) {
            try {
                this.input = assets.open("lyrics/Locked Away by R.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 7) {
            try {
                this.input = assets.open("lyrics/More Than Words.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 8) {
            try {
                this.input = assets.open("lyrics/My pride lyrics.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 9) {
            try {
                this.input = assets.open("lyrics/Need you now Lyrcis.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 10) {
            try {
                this.input = assets.open("lyrics/nothing gonna change.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 11) {
            try {
                this.input = assets.open("lyrics/Passenger let her go.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 12) {
            try {
                this.input = assets.open("lyrics/See you again.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 13) {
            try {
                this.input = assets.open("lyrics/Somebody's me lyrics.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 14) {
            try {
                this.input = assets.open("lyrics/Standbymeby.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 15) {
            try {
                this.input = assets.open("lyrics/Taylor Swift black space.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 16) {
            try {
                this.input = assets.open("lyrics/ThinkingoutloudbyEdSheeran.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 17) {
            try {
                this.input = assets.open("lyrics/Until You.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 18) {
            try {
                this.input = assets.open("lyrics/We Don't talk anymore lyrics.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 19) {
            try {
                this.input = assets.open("lyrics/Westlife if i let you go.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 20) {
            try {
                this.input = assets.open("lyrics/Why not me.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 21) {
            try {
                this.input = assets.open("lyrics/You Are My Sunshine.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 22) {
            try {
                this.input = assets.open("lyrics/You Are My Sunshine.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] bArr = new byte[0];
        try {
            bArr = new byte[this.input.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.input.read(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.textView.setText(new String(bArr));


    }



    @Override
    public void onBackPressed() {
        if (mInterstitialAd !=null) {
            mInterstitialAd.show(SongLyrics.this);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                @Override
                public void onAdShowedFullScreenContent() {
                    // Called when fullscreen content is shown.
                    // Make sure to set your reference to null so you don't
                    // show it a second time.
                    mInterstitialAd = null;
                }
            });
        }
        finish();
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


}
