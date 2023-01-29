package siam.moemoetun.com.shwedailyenglish;

import android.app.Application;
import android.os.StrictMode;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
public class MyApplication extends Application {
	private static MyApplication mInstance;
	public MyApplication() {
		mInstance = this;
	}


	@Override
	public void onCreate() {
		super.onCreate();
		MobileAds.initialize(this, initializationStatus -> {
		});
		AudienceNetworkAds.initialize(this);


		mInstance = this;
		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		StrictMode.setVmPolicy(builder.build());
		builder.detectFileUriExposure();

	}

	public static synchronized MyApplication getInstance() {
		return mInstance;
	}

}
