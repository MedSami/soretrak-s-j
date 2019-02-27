package com.salwa.soretrak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.salwa.soretrak.API.ApiRequest;
import com.salwa.soretrak.API.RetrofitServer;
import com.salwa.soretrak.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReclamationPanne extends AppCompatActivity {
String idUtilisateur,idEquippement;
Button btnEnvoyer;
EditText edtDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation_panne);

        btnEnvoyer=findViewById(R.id.btnEnvoyer);
        edtDescription=findViewById(R.id.edtDescription);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");
            idEquippement = data.getString("idEquippement");

        }

btnEnvoyer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(edtDescription.getText().toString().equals("")){
            Toast.makeText(ReclamationPanne.this, "Saisir description SVP", Toast.LENGTH_SHORT).show();
        }else {
            ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
            Call<ResponseDataModel> Reclamation=api.ReclamationPanne(idUtilisateur,
                    idEquippement,edtDescription.getText().toString());

            Reclamation.enqueue(new Callback<ResponseDataModel>() {
                @Override
                public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                    Toast.makeText(ReclamationPanne.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                    Toast.makeText(ReclamationPanne.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
});

    }
}
