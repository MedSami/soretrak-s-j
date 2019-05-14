package com.salwa.soretrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPersonel extends AppCompatActivity {
String idUtilisateur;
Button btnConsulter,btnPanne,btnReponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_personel);

        btnConsulter=findViewById(R.id.btnConsulter);
        btnPanne=findViewById(R.id.btnPanne);
        btnReponse=findViewById(R.id.btnReponse);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");

        }

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuPersonel.this,ConsulterEquippement.class);
                i.putExtra("idUtilisateur",idUtilisateur);
                i.putExtra("btnValue","consulter");
                startActivity(i);
            }
        });



        btnPanne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuPersonel.this,ConsulterEquippement.class);
                i.putExtra("idUtilisateur",idUtilisateur);
                i.putExtra("btnValue","panne");
                startActivity(i);
            }
        });

        btnReponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MenuPersonel.this,ListPanne.class);
                i.putExtra("idUtilisateur",idUtilisateur);
                i.putExtra("btnValue","personnel");
                startActivity(i);
            }
        });

    }
}
