package org.acodean.myrecipe.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.startapp.android.publish.adsCommon.StartAppAd;

import org.acodean.myrecipe.R;
import org.acodean.myrecipe.api.helper.ServiceGenerator;
//import org.acodean.myrecipe.api.models.LinkAdapter;
import org.acodean.myrecipe.api.models.Rebrandly;
import org.acodean.myrecipe.api.models.ResponseData;
import org.acodean.myrecipe.api.services.ApiInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlankActivity extends AppCompatActivity {
    private ProgressDialog progress;
    private RecyclerView linksView;
    private ItemAdapter itemAdapter;
    private FastAdapter fastAdapter;
    private List dataLinks = new ArrayList<>();
    private String id,title,destination,shortUrl;
    String apikey = "88e93778a7414296aed991cf8a3b2d5d";
    TextView id_link, judul, tujuan, linkBaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        progress = new ProgressDialog(this);
        progress.setMessage("Loading...");
        progress.show();
        id_link = findViewById(R.id.id_link);
        judul = findViewById(R.id.judul);
        tujuan = findViewById(R.id.tujuan);
        linkBaru = findViewById(R.id.linkBaru);
        getData();
    }

    public void getData(){
        progress.hide();
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
        Call<List<ResponseData>> call = service.getRebrand(apikey);
        call.enqueue(new Callback<List<ResponseData>>() {
            @Override
            public void onResponse(Call<List<ResponseData>> call, Response<List<ResponseData>> response) {
                if(response.isSuccessful()){
                    int i = 0;
                    id = response.body().get(i).getId();
                    title = response.body().get(i).getTitle();
                    destination = response.body().get(i).getDestination();
                    shortUrl = response.body().get(i).getShortUrl();

                    id_link.setText(id);
                    judul.setText(title);
                    tujuan.setText(destination);
                    linkBaru.setText(shortUrl);
                }
            }

            @Override
            public void onFailure(Call<List<ResponseData>> call, Throwable t) {
                Toast.makeText(BlankActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
