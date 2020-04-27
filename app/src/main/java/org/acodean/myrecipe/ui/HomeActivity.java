package org.acodean.myrecipe.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.startapp.android.publish.adsCommon.StartAppSDK;

import org.acodean.myrecipe.api.helper.ServiceGenerator;
import org.acodean.myrecipe.api.models.ApiError;
import org.acodean.myrecipe.api.models.Rebrandly;
import org.acodean.myrecipe.api.models.RebrandlyRequest;
import org.acodean.myrecipe.api.models.ResponseData;
import org.acodean.myrecipe.api.services.ApiInterface;
import org.acodean.myrecipe.R;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST = 100;
    private InterstitialAd mInterstitialAd;
    EditText editText;
    Button btn;
    String url;
    String apikey = "88e93778a7414296aed991cf8a3b2d5d";
    private RebrandlyRequest rebrandlyRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "203460553", true);
        StartAppSDK.setUserConsent(this, "pas", System.currentTimeMillis(), true);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //add event
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
//                Toast.makeText(HomeActivity.this, "On loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Toast.makeText(HomeActivity.this, "On failed to load with error code "+errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        setContentView(R.layout.activity_home);
        editText = findViewById(R.id.edtText);
        btn = findViewById(R.id.button);
        check();

    }
    private void showInterstial(){
        if(mInterstitialAd != null && mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        } else{
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
        }
    }



    public void handleOpen(View view) {
        if(check()==true){
            url = editText.getText().toString().trim();
            rebrandlyRequest = new RebrandlyRequest(url);
            if(url.isEmpty()){
                Toast.makeText(this, "Isi data terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else {
                brandly();
            }
        }
    }
    private void brandly() {
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
//        String destination = editText.getText().toString();
        Call<ResponseData> call = service.doRebrand(apikey, rebrandlyRequest);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(HomeActivity.this, "Successfully Shortest Email", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(HomeActivity.this, BlankActivity.class);
                    startActivity(intent);

                    Toast.makeText(HomeActivity.this, response.body().getShortUrl(), Toast.LENGTH_SHORT).show();
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                        showInterstial();
                    } else {
                        Log.d("TAG", "The interstial wasn't loaded yet");
                    }
                } else {
                    Toast.makeText(HomeActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.d("HomeActivity", t.getMessage());
            }
        });
    }

    public boolean check(){
        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();
        return true;
    }
}
