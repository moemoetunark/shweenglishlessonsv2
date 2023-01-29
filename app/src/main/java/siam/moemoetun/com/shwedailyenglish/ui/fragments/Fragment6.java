package siam.moemoetun.com.shwedailyenglish.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import siam.moemoetun.com.shwedailyenglish.R;
import siam.moemoetun.com.shwedailyenglish.ui.adapter.ExpandableListAdapter;
import siam.moemoetun.com.shwedailyenglish.ui.webview.InterchangeWeb;

public class Fragment6 extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private InterstitialAd mInterstitialAd;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_send, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

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



        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getContext(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                //Toast.makeText(getContext(),
                // listDataHeader.get(groupPosition) + " Expanded",
                //Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                // Toast.makeText(getContext(),
                //listDataHeader.get(groupPosition) + " Collapsed",
                //Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        final int groupPosition, final int childPosition, long id) {
                // TODO Auto-generated method stub

                if (mInterstitialAd !=null) {
                    mInterstitialAd.show((Activity) getContext());
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Intent intent = new Intent(getContext(), InterchangeWeb.class);
                            intent.putExtra("key",groupPosition);
                            intent.putExtra("key1",childPosition);
                            startActivity(intent);
                            mInterstitialAd = null;
                            // Called when fullscreen content is dismissed.
                            Log.d("TAG", "The ad was dismissed.");
                        }
                    });

                }else {
                    Intent intent = new Intent(getContext(), InterchangeWeb.class);
                    intent.putExtra("key",groupPosition);
                    intent.putExtra("key1",childPosition);
                    startActivity(intent);
                }


                //Intent intent = new Intent(getContext(), InterchangeWeb.class);
                //intent.putExtra("key",groupPosition);
                //intent.putExtra("key1",childPosition);
                //getContext().startActivity(intent);

                return false;
            }
        });

    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Interchange Level 1");
        listDataHeader.add("Interchange Level 2- Greeting");
        listDataHeader.add("Interchange Level 2(အလုပ္အကိုင္)");
        listDataHeader.add("Interchange Level 2 - Shopping");
        listDataHeader.add("Interchange Level 2 - Talking about Music, Like and Dislike");
        listDataHeader.add("Interchange Level 2- About family");
        listDataHeader.add("Interchange Level 2- Sports and Fitness Activity");
        listDataHeader.add("Interchange Level 2 - Free time and Weekend");


        // Adding child data
        List<String> Grammar = new ArrayList<String>();
        Grammar.add("It's nice to meet you.\\nေတြ႕ရတာဝမ္းသာပါတယ္");
        Grammar.add("He's over there. သူဟိုမွာ");
        Grammar.add("It's ...interesting.\n စိတ္ဝင္စားစရာပဲ");
        Grammar.add("Oh, no! မဟုတ္ေသးပါဘူး");
        Grammar.add("Are you from Seoul? \nနင္ ဆိုးလ္ျမိဳ႕ကလား");
        Grammar.add("He's cute. သူကခ်စ္စရာေလးေနာ္");
        Grammar.add("It's disaster.အရမ္းဆိုးတာပဲ");
        Grammar.add("It's really cold.\nအရမ္းေအးတယ္");

        Grammar.add("What time is it there?\nအဲ့ဒီမွာ ဘယ္အခ်ိန္ ရွိျပီလဲ");
        Grammar.add("I'm really hungry.\nငါဗိုက္အရမ္းဆာေနတယ္");
        Grammar.add("Nice Car. သိပ္ေကါင္းတဲ့ကားေနာ္");
        Grammar.add("I get up at noon.\nငါေန႕လည္မွ အိပ္ရာကထတယ္");
        Grammar.add("My new apartment.\nငါ့ရဲ႕အခန္းသစ္");
        Grammar.add("There aren't any chairs. \nကုလားထိုင္ေတြ မရွိဘူး");
        Grammar.add("He works in a hotel.\\nသူဟိုတယ္မွာ အလုပ္လုပ္တယ္");
        Grammar.add("Please be careful.\\n ေက်းဇူးျပဳလို႕ ဂရုစိုက္ပါ။");
        Grammar.add("How about some sandwiches?\\nအသားညွပ္ေပါင္မုန္႕ဆုိ ဘယ္လိုလဲ");
        Grammar.add("Fish for the breakfast \\n မနက္စာအတြက္ ငါး");
        Grammar.add("I love sports\\nအားကစားကို ႏွစ္သက္တယ္");
        Grammar.add("I can't sing. သီခ်င္းမဆိုတတ္ဘူး");
        Grammar.add("Birthday plan ေမြးေန႕အစီစဥ္");
        Grammar.add("Valentine's Day -ခ်စ္သူမ်ားေန႕");
        Grammar.add("I don't feel well. \\n ေနမေကါင္းဘူး");
        Grammar.add("Don't work too hard \\n သိပ္ပင္ပန္းခံျပီး အလုပ္မလုပ္နဲ႕");
        Grammar.add("It's emergency အေရးေပၚ");
        Grammar.add("Is it far from here? \\n ဒီကေနေဝးလား");






        List<String> Grammar1 = new ArrayList<String>();
        Grammar1.add("Please call me Beth. \\n Beth လို႕ေခၚပါ");
        Grammar1.add("What's Seoul like?\\n ဆိုးလ္ျမိဳက ဘယ္လိုလဲ");
        Grammar1.add("How's it going?\\nေနေကါင္းရဲ႕လား");


        List<String> Grammar2 = new ArrayList<String>();
        Grammar2.add("Where do you work?\\nနင္ဘယ္မွာ အလုပ္လုပ္လဲ");
        Grammar2.add("I start work at five.\\n ငါးနာရီမွာ ငါစအလုပ္လုပ္တယ္");



        List<String>Grammar3 = new ArrayList<String>();
        Grammar3.add("It's really pretty. \\nဒါေလးအရမ္းလွတယ္");
        Grammar3.add("I prefer the blue one\\nအျပာေရာင္တစ္ခုကို ပိုၾကိဳက္တယ္");

        List<String> Grammar4 = new ArrayList<String>();
        Grammar4.add("Who is your favorite singer?");
        Grammar4.add("An invitation");

        List<String> Grammar5 = new ArrayList<String>();
        Grammar5.add("Asking about Family");
        Grammar5.add("Is that typical?");



        List<String> Grammar6 = new ArrayList<String>();
        Grammar6.add("I hardly ever exercise.\\nတစ္ခါတစ္ရံ႔ပဲေလ့က်င့္ခန္းလုပ္တယ္");
        Grammar6.add("I'm a real fitness freak.\\nက်န္းမာေရးအရမ္းလိုက္စားသူ");

        List<String> Grammar7 = new ArrayList<String>();
        Grammar7.add("Did you do anything special?");
        Grammar7.add("How was your vocation? \\nနင့္အားလပ္ရက္ခရီးဘယ္လိုလဲ");





        listDataChild.put(listDataHeader.get(0), Grammar); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Grammar1);
        listDataChild.put(listDataHeader.get(2), Grammar2);
        listDataChild.put(listDataHeader.get(3), Grammar3); // Header, Child data
        listDataChild.put(listDataHeader.get(4), Grammar4);
        listDataChild.put(listDataHeader.get(5), Grammar5);
        listDataChild.put(listDataHeader.get(6), Grammar6);
        listDataChild.put(listDataHeader.get(7), Grammar7);




    }


}
