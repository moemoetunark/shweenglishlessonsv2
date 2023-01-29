package siam.moemoetun.com.shwedailyenglish.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import siam.moemoetun.com.shwedailyenglish.R;
import siam.moemoetun.com.shwedailyenglish.ui.adapter.MyRecyclerViewAdapter;
import siam.moemoetun.com.shwedailyenglish.ui.webview.StoryWebView;

public class Fragment3 extends Fragment implements MyRecyclerViewAdapter.ItemClickListener{

    private InterstitialAd mInterstitialAd;
    MyRecyclerViewAdapter adapter;

    //TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_slideshow, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("လူကေလးနဲ႕ေျခအိတ္တစ္စံု");
        animalNames.add("ေခြးနဲ႕ေၾကာင္");
        animalNames.add("ပန္းသီးေဖ်ာ္ရည္");
        animalNames.add("ငွက္နဲ႕လူကေလး");
        animalNames.add("ေမြးေန႕ကိတ္မုန္႕");
        animalNames.add("ေယာက္်ားေလးဟာေယာက်္ားေလးပဲ");
        animalNames.add("ပန္းျခံထဲမွာ");
        animalNames.add("အလုပ္မရွိ အစားမရွိ");
        animalNames.add("ငါ့အတြက္ သူငယ္ခ်င္းမရွိ");
        animalNames.add("အမွန္ေျပာပါ");
        animalNames.add("ဝက္ဝံကေလး");
        animalNames.add("အိုဘားမား");
        animalNames.add("အီဗရာဟင္ လင္ကြန္း");
        animalNames.add("မာတင္ေလသာကင္း");
        animalNames.add("ေဂ်ာ့ဝါခ်င္တာန္");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MyRecyclerViewAdapter(getContext(), animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


        //textView = view.findViewById(R.id.textView_item);
       // textView.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/zawgyi.ttf"));


        MobileAds.initialize(getContext(), initializationStatus -> {});

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(getContext(), getString(R.string.interstial_2021),
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





    }

    @Override
    public void onItemClick(View view, int position) {
        if (mInterstitialAd !=null) {
            mInterstitialAd.show((Activity) getContext());
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                @Override
                public void onAdDismissedFullScreenContent() {
                    Intent intent = new Intent(getContext(), StoryWebView.class);
                    intent.putExtra("key",position);
                    startActivity(intent);
                    mInterstitialAd = null;
                    // Called when fullscreen content is dismissed.
                    Log.d("TAG", "The ad was dismissed.");
                }
            });
        }else {
            Intent intent = new Intent(getContext(), StoryWebView.class);
            intent.putExtra("key",position);
            startActivity(intent);
        }
    }
}
