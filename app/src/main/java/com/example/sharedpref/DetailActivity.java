package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {
    private String KEY_JUDUL="barang";
    private String KEY_GAMBAR="gambar";
    private String KEY_DESC="deskripsi";
    private String KEY_PRICE = "harga";
    private Button btnBack;
    ImageView gbr;
    TextView brg,desc,prc;
    int gambar, price;
    String barang, deskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Detail Barang");
        btnBack = (Button) findViewById(R.id.back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(DetailActivity.this,SplitActivity.class);
                startActivity(back);
            }
        });
        gbr=(ImageView) findViewById(R.id.img_card_detail);
        gambar = getIntent().getIntExtra(KEY_GAMBAR, 0);
        gbr.setImageResource(gambar);
        brg = (TextView) findViewById(R.id.judul);
        barang = getIntent().getStringExtra(KEY_JUDUL);
        brg.setText(barang);
        desc = (TextView) findViewById(R.id.deskripsi);
        deskripsi = getIntent().getStringExtra(KEY_DESC);
        desc.setText(deskripsi);
        prc = (TextView) findViewById(R.id.hargaBrg);
        price = getIntent().getIntExtra(KEY_PRICE, 0);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        prc.setText("Rp. "+decimalFormat.format(price));
    }
}