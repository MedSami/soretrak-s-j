package com.salwa.soretrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuTechnicien extends AppCompatActivity {
Button btnGerePanne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_technicien);
    btnGerePanne=findViewById(R.id.btnGererPanne);


    btnGerePanne.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(MenuTechnicien.this,ListPanne.class);
            i.putExtra("btnValue","technicien");
            startActivity(i);
        }
    });

    }
}
