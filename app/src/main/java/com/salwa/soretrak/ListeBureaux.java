package com.salwa.soretrak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.salwa.soretrak.API.ApiRequest;
import com.salwa.soretrak.API.RetrofitServer;
import com.salwa.soretrak.Adapter.BureauAdapter;
import com.salwa.soretrak.Adapter.EquippementPersonnelAdapter;
import com.salwa.soretrak.Model.DataModel;
import com.salwa.soretrak.Model.ResponseDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeBureaux extends AppCompatActivity {
    private RecyclerView RecycleLayout;
    private RecyclerView.LayoutManager RecycleManager;
    private RecyclerView.Adapter bureauAdapter;
    //String btnValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_bureaux);
        RecycleLayout = findViewById(R.id.recyclerview);

       /* Bundle data = getIntent().getExtras();
        if (data != null) {
            btnValue = data.getString("btnValue");

        }*/

        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> listeBureaux=api.getBureaux();
        listeBureaux.enqueue(new Callback<ResponseDataModel>() {
            @Override
            public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                String code = response.body().getCode();
                List<DataModel> item = response.body().getResult();
                if (code.equals("1")) {
                    RecycleManager = new LinearLayoutManager(ListeBureaux.this, LinearLayoutManager.VERTICAL, false);

                    RecycleLayout.setLayoutManager(RecycleManager);

                    bureauAdapter = new BureauAdapter(item, ListeBureaux.this);

                    RecycleLayout.setAdapter(bureauAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                Toast.makeText(ListeBureaux.this, "Problem connexion", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
