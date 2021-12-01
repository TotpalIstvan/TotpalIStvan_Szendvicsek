package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {
    Button visszaBtn;
    TextView txtMegjelenit;
    DbHelper adatbazis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();

        visszaBtn.setOnClickListener( v ->
        {
            Intent vissza = new Intent(SearchResultActivity.this, MainActivity.class);
            startActivity(vissza);
            finish();
        });
    }

    public void init(){
        visszaBtn = findViewById(R.id.btnVissza);
        txtMegjelenit = findViewById(R.id.txtMegjelenit);
        adatbazis = new DbHelper(this);
    }
}