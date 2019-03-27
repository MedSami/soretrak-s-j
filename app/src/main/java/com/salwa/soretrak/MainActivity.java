package com.salwa.soretrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.salwa.soretrak.API.ApiRequest;
import com.salwa.soretrak.API.RetrofitServer;
import com.salwa.soretrak.Model.ResponseDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText pseudo,password;
    Button Login;
    TextView txtError;

    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pseudo=findViewById(R.id.edtPseudo);
        password=findViewById(R.id.edtPassword);
        Login=findViewById(R.id.btnLogin);
        txtError=findViewById(R.id.txterror);

        // Spinner element
        Spinner spinner =  findViewById(R.id.spinner);


        // Spinner Drop down elements
        List<String> utilisateurs = new ArrayList<String>();
        utilisateurs.add("Personnel");
        utilisateurs.add("Agent Inventaire");
        utilisateurs.add("Technicien");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, utilisateurs);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                 //item = adapterView.getItemAtPosition(position).toString();
                        index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(pseudo.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Remplir Champ Pseudo Svp", Toast.LENGTH_SHORT).show();
            }else if(password.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "Remplir Champ Mot De Passe SVP", Toast.LENGTH_SHORT).show();
            }else {
                ApiRequest api= RetrofitServer.getClient().create(ApiRequest.class);
                //Instance Call Methode
                Call<ResponseDataModel> Login=api.Login(pseudo.getText().toString(),index);
Login.enqueue(new Callback<ResponseDataModel>() {
    @Override
    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
        if(response.isSuccessful()){
            if(!response.body().getResult().isEmpty()){
            if(response.body().getResult().get(0).getPseudo().equals(pseudo.getText().toString())){
                if(response.body().getResult().get(0).getMot_de_passe().equals(password.getText().toString())){
                    if(index==0){

                        Intent intent=new Intent(MainActivity.this,MenuPersonel.class);
                        intent.putExtra("idUtilisateur",""+response.body().getResult().get(0).getId());
                        startActivity(intent);
                    }
                    if(index==1){

                        Intent intent=new Intent(MainActivity.this,MenuAgentDInventaire.class);
                        intent.putExtra("idUtilisateur",""+response.body().getResult().get(0).getId());
                        startActivity(intent);
                    }
                    if(index==2){

                        Intent intent=new Intent(MainActivity.this,MenuTechnicien.class);
                        intent.putExtra("idUtilisateur",""+response.body().getResult().get(0).getId());
                        startActivity(intent);
                    }

                }else {
                    txtError.setText("Mot De Passe Incorrect");
                }
            }
            }else {
                txtError.setText("Pseudo Incorrect");
            }
        }else {
            txtError.setText("Pseudo Incorrect");
        }
    }

    @Override
    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
        Toast.makeText(MainActivity.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
    }
});
            }


        }
    });




    }
}
