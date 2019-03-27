package com.salwa.soretrak;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.salwa.soretrak.API.ApiRequest;
import com.salwa.soretrak.API.RetrofitServer;
import com.salwa.soretrak.Model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inventaire extends AppCompatActivity {
ImageView img;

Button btnScan,btnNext;
EditText edtRef;
Bitmap bitmap;
String idUtilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventaire);
        img=findViewById(R.id.imageView);
        edtRef=findViewById(R.id.edtRef);
        btnScan=findViewById(R.id.btnScan);
        btnNext=findViewById(R.id.btnNext);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");
            Toast.makeText(this, idUtilisateur, Toast.LENGTH_SHORT).show();
        }

        bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources()
                ,R.drawable.frame);
        img.setImageBitmap(bitmap);

        final Activity activity = this;
        btnScan.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }
});

btnNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ApiRequest api = RetrofitServer.getClient().create(ApiRequest.class);
        Call<ResponseDataModel> inventaire=api.Inventaire(idUtilisateur,edtRef.getText().toString());
inventaire.enqueue(new Callback<ResponseDataModel>() {
    @Override
    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
        Toast.makeText(Inventaire.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
        btnScan.setEnabled(true);
        btnNext.setVisibility(View.GONE);
        edtRef.setVisibility(View.GONE);
        edtRef.setEnabled(false);
    }

    @Override
    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
        Toast.makeText(activity, "Problem Connexion", Toast.LENGTH_SHORT).show();
    }
});
    }
});

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {
                //Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();
                edtRef.setText(result.getContents());
                btnScan.setEnabled(false);
                btnNext.setVisibility(View.VISIBLE);
                edtRef.setVisibility(View.VISIBLE);
                edtRef.setEnabled(false);
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
