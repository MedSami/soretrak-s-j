package com.salwa.soretrak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.salwa.soretrak.API.ApiRequest;
import com.salwa.soretrak.API.RetrofitServer;
import com.salwa.soretrak.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReponsePanne extends AppCompatActivity {
String idPanne,description;
EditText edtReponse;
TextView txtDecription;
Button btnValider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponse_panne);

        edtReponse=findViewById(R.id.edtReponse);
        btnValider=findViewById(R.id.btnValider);
        txtDecription=findViewById(R.id.txtDescription);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            idPanne = data.getString("id");
            description = data.getString("description");
            txtDecription.setText(description);

        }


        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtReponse.getText().toString().equals("")){
                    Toast.makeText(ReponsePanne.this, "Merci de remplir champ Reponse !!!", Toast.LENGTH_SHORT).show();
                }else {
                    ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
                    Call<ResponseDataModel> Reponse=api.ReponsePanne(idPanne,edtReponse.getText().toString());
                    Reponse.enqueue(new Callback<ResponseDataModel>() {
                        @Override
                        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {

                            Toast.makeText(ReponsePanne.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                            Toast.makeText(ReponsePanne.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
