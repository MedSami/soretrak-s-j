package com.salwa.soretrak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.salwa.soretrak.API.ApiRequest;
import com.salwa.soretrak.API.RetrofitServer;
import com.salwa.soretrak.Adapter.EquippementPersonnelAdapter;
import com.salwa.soretrak.Model.DataModel;
import com.salwa.soretrak.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsulterEquippement extends AppCompatActivity {

    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter equippementPersonnelAdapter;
    String idUtilisateur,btnValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_equippement);
        RecycleLayout = findViewById(R.id.recyclerView);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");
            btnValue = data.getString("btnValue");

        }

        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> getEquippement=api.getEquippement(idUtilisateur);

        getEquippement.enqueue(new Callback<ResponseDataModel>() {
        @Override
        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
            String code = response.body().getCode();
            List<DataModel> item = response.body().getResult();
            if (code.equals("1")) {
                RecycleManager = new LinearLayoutManager(ConsulterEquippement.this, LinearLayoutManager.VERTICAL, false);

                RecycleLayout.setLayoutManager(RecycleManager);

                equippementPersonnelAdapter = new EquippementPersonnelAdapter(item, ConsulterEquippement.this,btnValue,idUtilisateur);

                RecycleLayout.setAdapter(equippementPersonnelAdapter);
            }
        }

        @Override
        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
            Toast.makeText(ConsulterEquippement.this,"Problem connexion", Toast.LENGTH_SHORT).show();

        }
    });

    }
}
