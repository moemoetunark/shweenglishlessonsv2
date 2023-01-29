package siam.moemoetun.com.shwedailyenglish.ui.webview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import siam.moemoetun.com.shwedailyenglish.R;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.IOException;
import java.io.InputStream;

public class VocaWebView extends AppCompatActivity {

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

        InterstitialAd.load(VocaWebView.this, getString(R.string.inter_goback),
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
                this.input = assets.open("asset_new/make_collocation.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 1) {
            try {
                this.input = assets.open("asset_new/give-keep-break.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 2) {
            try {
                this.input = assets.open("asset_new/go-get.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 3) {
            try {
                this.input = assets.open("asset_new/family_vocabulary.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 4) {
            try {
                this.input = assets.open("asset_new/Weather_Vocabulary.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 5) {
            try {
                this.input = assets.open("asset_new/health_problem.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 6) {
            try {
                this.input = assets.open("asset_new/Animal Vocabulary.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 7) {
            try {
                this.input = assets.open("asset_new/partofbody.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 8) {
            try {
                this.input = assets.open("asset_new/Positive Personality Adjectives.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 9) {
            try {
                this.input = assets.open("asset_new/Actions and Feelings.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 10) {
            try {
                this.input = assets.open("asset_new/Daily Routine.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 11) {
            try {
                this.input = assets.open("asset_new/money.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 12) {
            try {
                this.input = assets.open("asset_new/foods.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 13) {
            try {
                this.input = assets.open("asset_new/transportation.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 14) {
            try {
                this.input = assets.open("asset_new/job_vocabulary.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 15) {
            try {
                this.input = assets.open("asset_new/sport.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 16) {
            try {
                this.input = assets.open("asset_new/movies.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 17) {
            try {
                this.input = assets.open("asset_new/music vocabulary.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 18) {
            try {
                this.input = assets.open("asset_new/politics.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 19) {
            try {
                this.input = assets.open("asset_new/crimes.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 20) {
            try {
                this.input = assets.open("asset_new/environmental issues.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (intExtra == 21) {
            try {
                this.input = assets.open("asset_new/ministery in Myanmar.txt");
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
            mInterstitialAd.show(VocaWebView.this);
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





}
