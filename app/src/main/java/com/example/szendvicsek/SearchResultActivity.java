package com.example.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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


        Cursor adat = adatbazis.listazas(String.valueOf(MainActivity.ar));
        StringBuilder sb = new StringBuilder();
        if(adat.getCount() == 0){
                sb.append("Nincs ilyen olcsó szendvics: ").append(MainActivity.ar);
        } else {
            while (adat.moveToNext()){
                sb.append("Id: ").append(adat.getInt(0));
                sb.append(System.lineSeparator());
                sb.append("Név: ").append(adat.getInt(1));
                sb.append(System.lineSeparator());
                sb.append("Leírás: ").append(adat.getInt(2));
                sb.append(System.lineSeparator());
                sb.append("Elkészítési idő (perc): ").append(adat.getInt(3));
                sb.append(System.lineSeparator());
                sb.append("Ár (ft): ").append(adat.getInt(4));
                sb.append(System.lineSeparator());
                sb.append("++++++++++++++++++++++");
            }
        }
        txtMegjelenit.setText(sb.toString());
    }

    public void init(){
        visszaBtn = findViewById(R.id.btnVissza);
        txtMegjelenit = findViewById(R.id.txtMegjelenit);
        adatbazis = new DbHelper(this);
    }
}