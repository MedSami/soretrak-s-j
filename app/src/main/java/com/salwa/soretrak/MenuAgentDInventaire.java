package com.salwa.soretrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAgentDInventaire extends AppCompatActivity {
Button btnGerer;
String idUtilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_agent_dinventaire);
        btnGerer=findViewById(R.id.btnGerer);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idUtilisateur = data.getString("idUtilisateur");


        }

        btnGerer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MenuAgentDInventaire.this,AgentDInventaire.class);
               intent.putExtra("idUtilisateur",idUtilisateur);
                startActivity(intent);
            }
        });
    }
}
