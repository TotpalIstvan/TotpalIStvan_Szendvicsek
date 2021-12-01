package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnKereses, btnFelvesz;
    private EditText txtAr;
    private DbHelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnKereses.setOnClickListener( v -> {
            Intent kereses = new Intent(MainActivity.this, SearchResultActivity.class);
            startActivity(kereses);
            finish();
        });
        btnFelvesz.setOnClickListener( v -> {
            Intent felvetel = new Intent(MainActivity.this, InsertActivity.class);
            startActivity(felvetel);
            finish();
        });
    }

    public void init() {
        btnKereses = findViewById(R.id.btnKereses);
        btnFelvesz = findViewById(R.id.btnFelvesz);
        txtAr = findViewById(R.id.txtAr);
        adatbazis = new DbHelper(this);
    }
}