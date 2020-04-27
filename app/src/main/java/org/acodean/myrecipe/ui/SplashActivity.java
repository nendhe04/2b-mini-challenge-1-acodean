package org.acodean.myrecipe.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.acodean.myrecipe.R;
import org.acodean.myrecipe.api.helper.ServiceGenerator;
import org.acodean.myrecipe.api.models.AppVersion;
import org.acodean.myrecipe.api.services.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    Context context;
    private ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = getApplicationContext();
        check();
    }


    private void check() {

        if (checkInternetConnection()) {
            Toast.makeText(SplashActivity.this, "Internet Connection", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(SplashActivity.this, TermsActivity.class);
            startActivity(i);

        } else {
            AlertDialog.Builder batal = new AlertDialog.Builder(SplashActivity.this);
            batal.setTitle("Notification")
                    .setMessage("No Internet Connection")
                    .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            check();
                        }
                    })
                    .setCancelable(false);
            batal.show();

        }
    }

    private boolean checkInternetConnection() {
        //TODO : 1. Implementasikan proses pengecekan koneksi internet, berikan informasi ke user jika tidak terdapat koneksi internet
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
