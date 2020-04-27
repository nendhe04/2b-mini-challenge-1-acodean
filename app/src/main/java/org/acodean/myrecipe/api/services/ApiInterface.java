package org.acodean.myrecipe.api.services;
import org.acodean.myrecipe.api.models.AppVersion;
import org.acodean.myrecipe.api.models.Envelope;
import org.acodean.myrecipe.api.models.Rebrandly;
import org.acodean.myrecipe.api.models.RebrandlyRequest;
import org.acodean.myrecipe.api.models.ResponseData;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface{
    @GET("/")
    Call<AppVersion> getAppVersion();

    @POST("/v1/links")
    Call<ResponseData> doRebrand(@Query("apikey") String apikey , @Body RebrandlyRequest destination);

    @GET("/v1/links")
    Call<List<ResponseData>> getRebrand(@Query("apikey") String data);


}
