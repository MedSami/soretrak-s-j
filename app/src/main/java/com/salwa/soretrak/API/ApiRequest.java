package com.salwa.soretrak.API;

import com.salwa.soretrak.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {



    /******************** Authentification Login*******************/
    @GET("Login.php")
    Call<ResponseDataModel> Login(@Query("pseudo") String pseudo);

    /************** Select Equippement ****************/
    @GET("ConsulterEquippement.php")
    Call<ResponseDataModel> getEquippement(@Query("id") String id_utilisateur);


}
