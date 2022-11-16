package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CheckoutActivity extends AppCompatActivity {

    private EditText bayar;
    private TextView kembalian;
    private Button pembayaran;
    TextView mtransaksi;
    String transaksi;
    String xtransaksi = "n";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        bayar = (EditText) findViewById(R.id.bayar);
        kembalian = (TextView) findViewById(R.id.kembali);
        pembayaran = (Button) findViewById(R.id.pembayaran);
        mtransaksi= (TextView) findViewById(R.id.transaksi);

        Bundle bundle = getIntent().getExtras();
        transaksi=bundle.getString(xtransaksi);
//        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        mtransaksi.setText("Rp. "+transaksi);

        pembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bn = getIntent().getExtras();
                String harga = bn.getString("n").trim();
                String buy = bayar.getText().toString().trim();
                int b = Integer.parseInt(buy);
                int h = Integer.parseInt(harga);
                if (b > h){
                    double kembali = b - h;
                    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
                    kembalian.setText("Kembalian Anda :   Rp. "+decimalFormat.format(kembali));
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Jumlah uang yang anda masukkan belum mencukupi!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}