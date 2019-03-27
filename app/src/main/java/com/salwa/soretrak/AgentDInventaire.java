package com.salwa.soretrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgentDInventaire extends AppCompatActivity {
Button btnConsulterEqP,btnMiseAJour;
String idUtilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dinventaire);
        btnConsulterEqP=findViewById(R.id.btnEP);
        btnMiseAJour=findViewById(R.id.btnMise);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");

        }

        btnConsulterEqP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AgentDInventaire.this,ListePersonnels.class);
                i.putExtra("btnValue","consulter");
                i.putExtra("idUtilisateur",idUtilisateur);
                startActivity(i);

            }
        });

        btnMiseAJour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AgentDInventaire.this,ListePersonnels.class);
                i.putExtra("btnValue","scan");
                i.putExtra("idUtilisateur",idUtilisateur);
                startActivity(i);

            }
        });

    }
}
