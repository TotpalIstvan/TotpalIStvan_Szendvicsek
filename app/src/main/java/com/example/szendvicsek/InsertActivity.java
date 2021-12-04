package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private Button felvetelBtn, visszaBtn;
    private EditText txtNev, txtLeiras, txtElkeszetesiIdo, arTxt;
    private DbHelper adatbazis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();

        visszaBtn.setOnClickListener( v ->
        {
            Intent vissza = new Intent(InsertActivity.this, MainActivity.class);
            startActivity(vissza);
            finish();
        });
        felvetelBtn.setOnClickListener( v -> {
            if (!(txtNev.getText().toString().isEmpty()&&arTxt.getText().toString().isEmpty()&&txtLeiras.getText().toString().isEmpty()&&txtElkeszetesiIdo.getText().toString().isEmpty())){
                if(adatbazis.felvetel(txtNev.getText().toString(),txtLeiras.getText().toString(),txtLeiras.getText().toString(),arTxt.getText().toString())){
                    Toast.makeText(this, "Sikeres szendvics felvétel :)", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(this, "Sikertelen szendvics felvétel :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        felvetelBtn = findViewById(R.id.btnFelvesz);
        visszaBtn = findViewById(R.id.btnVissza);
        txtNev = findViewById(R.id.txtNev);
        txtLeiras = findViewById(R.id.txtLeiras);
        txtElkeszetesiIdo = findViewById(R.id.txtElkeszetesiIdo);
        arTxt = findViewById(R.id.arTXT);
        adatbazis = new DbHelper(this);
    }
}