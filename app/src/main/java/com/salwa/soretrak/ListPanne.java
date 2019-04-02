package com.salwa.soretrak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.salwa.soretrak.API.ApiRequest;
import com.salwa.soretrak.API.RetrofitServer;
import com.salwa.soretrak.Adapter.PanneAdapter;
import com.salwa.soretrak.Adapter.PersonnelAdapter;
import com.salwa.soretrak.Model.DataModel;
import com.salwa.soretrak.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPanne extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter panneAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_panne);
        RecycleLayout = findViewById(R.id.recyclerview);


        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> ListPanne=api.getPanne();

        ListPanne.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListPanne.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    panneAdapter = new PanneAdapter(item, ListPanne.this);

                    RecycleLayout.setAdapter(panneAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ListPanne.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
