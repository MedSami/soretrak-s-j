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
    Call<ResponseDataModel> Login(@Query("pseudo") String pseudo,
                                  @Query("type") int type);

    /************** Select Equippement ****************/
    @GET("ConsulterEquippement.php")
    Call<ResponseDataModel> getEquippement(@Query("id") String id_utilisateur);

    /************** Liste Bureaux ****************/
    @GET("ListeBureaux.php")
    Call<ResponseDataModel> getBureaux();
    /************** Liste Panne ****************/
    @GET("listPanne.php")
    Call<ResponseDataModel> getPanne();
 /************** Liste Personnels ****************/
    @GET("ListePersonnel.php")
    Call<ResponseDataModel> getPersonnels();

    /******************** Inventaire*******************/
    @GET("Inventaire.php")
    Call<ResponseDataModel> Inventaire(@Query("id") String idPersonnel,
                                  @Query("designation") String designation);
    /*************** Reclamation Panne *******************/
    @FormUrlEncoded
    @POST("ReclamationPanne.php")
    Call<ResponseDataModel> ReclamationPanne(
            @Field("idPersonnel") String idPersonnel,
            @Field("idEquippement") String idEquippement,
            @Field("description") String description
    );


    /******************** Reponse Panne *******************/
    @GET("reponsePanne.php")
    Call<ResponseDataModel> ReponsePanne(@Query("id") String idPanne,
                                       @Query("reponse") String reponse);
}
