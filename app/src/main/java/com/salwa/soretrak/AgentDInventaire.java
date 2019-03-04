package com.salwa.soretrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgentDInventaire extends AppCompatActivity {
Button btnConsulterEqP,btnConsulterEqB,btnMiseAJour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_dinventaire);
        btnConsulterEqB=findViewById(R.id.btnCEB);
        btnConsulterEqP=findViewById(R.id.btnEP);
        btnMiseAJour=findViewById(R.id.btnMise);

        btnConsulterEqB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AgentDInventaire.this,ListeBureaux.class);
               // i.putExtra("btnValue","bureau");
                startActivity(i);
            }
        });

        btnConsulterEqP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AgentDInventaire.this,ListePersonnels.class);
                //i.putExtra("btnValue","personnel");
                startActivity(i);

            }
        });

        btnMiseAJour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
}
