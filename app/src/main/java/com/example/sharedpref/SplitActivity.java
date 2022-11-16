package com.example.sharedpref;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.sharedpref.R;

public class SplitActivity extends AppCompatActivity implements ListAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private ArrayList<ListText> ArrayList;
    private ArrayList<String> listGambar;
    public int tot=0;
    TextView txtTot;
    private String KEY_JUDUL="barang";
    private String KEY_GAMBAR="gambar";
    private String KEY_DESC = "deskripsi";
    private String KEY_PRICE = "harga";
    private int pricePlus;
    int[] gambar = {R.drawable.d1, R.drawable.d2, R.drawable.d3,R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7, R.drawable.d8, R.drawable.d9, R.drawable.d10};
    int price[] = {17000000, 20000999, 20000999, 20000999, 34599000, 16899000,10500899,10500899,2769000,1399000};
    String namaProduk[] = {"ROG Strix G513QC", "ROG Zephyrus G14", "ROG Zephyrus G14 White", "ROG Zephyrus G14 Grey", "ROG Zephyrus Duo GX650RM", "TUF Dash-F15", "ROG PHONE 5 White", "ROG PHONE 5 Black", "ROG Clavis", "ROG Throne" };
    String descProduk[] = {"AMD Ryzen™ 7 6800H, NVIDIA® GeForce RTX™ 3050, RAM 8GB DDR5-4800 SO-DIMM,512GB M.2 NVMe™ PCIe® 4.0 SSD,Backlit Chiclet Keyboard 4-Zone RGB ",
                            "AMD Ryzen™ 9 6900HS, AMD Radeon™ RX 6800S 8GB GDDR6 MUX Switch, 16GB DDR5 on board Up To 32GB,512GB M.2 NVMe™ PCIe® 4.0 SSD,Backlit Chiclet Keyboard 4-Zone RGB",
                            "AMD Ryzen™ 9 6900HS, AMD Radeon™ RX 6800S 8GB GDDR6 MUX Switch, 16GB DDR5 on board Up To 32GB, Backlit Chiclet Keyboard 4-Zone RGB, 1TB M.2 NVMe™ PCIe® 4.0 SSD",
                            "AMD Ryzen™ 9 6900HS, AMD Radeon™ RX 6800S 8GB GDDR6 MUX Switch, 16GB DDR5 on board Up To 32GB, Backlit Chiclet Keyboard 4-Zone RGB, 1TB M.2 NVMe™ PCIe® 4.0 SSD",
                            "AMD Ryzen™ 7 6800H, NVIDIA® GeForce RTX™ 3060 Laptop GPU 6GB GDDR6, 16GB DDR5 4800Mhz, Backlit Chiclet Keyboard 4-Zone RGB, 1TB M.2 NVMe™ PCIe® 4.0 SSD",
                            "AMD Ryzen™ 9 6900HS, AMD Radeon™ RX 6800S 8GB GDDR6 MUX Switch,16GB DDR5 on board Up To 32GB16GB DDR5 on board Up To 32GB, Backlit Chiclet Keyboard 4-Zone RGB, 1TB M.2 NVMe™ PCIe® 4.0 SSD",
                            "173 x 77 x 10.3 mm, Qualcomm SM8475 Snapdragon 8+ Gen 1 (4 nm), Octa-core (1x3.19 GHz Cortex-X2 and 3x2.75 GHz Cortex-A710), Adreno 730, NFC",
                            "173 x 77 x 10.3 mm, Qualcomm SM8475 Snapdragon 8+ Gen 1 (4 nm), Octa-core (1x3.19 GHz Cortex-X2 and 3x2.75 GHz Cortex-A710), Adreno 730, NFC",
                            "ROG Clavis USB-C to 3.5 mm gaming DAC with AI Noise-Canceling Mic, MQA rendering tech, ESS 9281 QUAD DAC, audio amplifier and Aura Sync. ROG Clavis is compatible with PCs, mobile devices and laptops",
                            "Customizable 18 RGB lighting zones, and sync-able with other Aura Sync products\n" +
                                    "Build-in ESS DAC and AMP deliver stunning music and immersive gaming audio\n" +
                                    "Support 2 USB 3.1 ports to charge devices or connect to your gaming gears"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new ListAdapter(ArrayList);

        StaggeredGridLayoutManager llm=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        txtTot = findViewById(R.id.totalPrice);

//        public void checkout(View view) {
//            Intent checkout = new Intent(SplitActivity.this,CheckoutActivity.class);
//            TextView txtTot=(TextView) findViewById(R.id.totalPrice);
//            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
//            txtTot.setText("Rp. "+decimalFormat.format(tot));
//            String transaksi = txtTot.getText().toString();
//            Intent intent = new Intent(SplitActivity.this,CheckoutActivity.class);
//            intent.putExtra("n",transaksi);
////        intent.putExtra("transaksi",tot);
//            startActivity(checkout);
//        }
    }
    public void onClick(View v, int position){
        final ListText list = ArrayList.get(position);
        switch (v.getId()){
            case R.id.txt_nama_mahasiswa:{
                int gbr = gambar[position];
                int prc = price[position];
                String brg = namaProduk[position];
                String desc = descProduk[position];
                Intent i = new Intent(SplitActivity.this,DetailActivity.class);
                i.putExtra(KEY_PRICE, prc);
                i.putExtra(KEY_GAMBAR, gbr);
                i.putExtra(KEY_JUDUL, brg);
                i.putExtra(KEY_DESC, desc);
                startActivity(i);
                break;
            }
            case R.id.img_card:{
                int prc = price[position];
                tot=tot+prc;
                Toast.makeText(this,"Berhasil Menambahkan ke keranjang : " + list.getNama() ,Toast.LENGTH_SHORT).show();
                postTotals();
                return;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.call) {
            String number = "081541193319";
            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.fromParts("tel", number, null));
            startActivity(call);
            return true;
        }
        else if (id == R.id.location){
            Intent openMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("https://goo.gl/maps/DMuDo2APLxt3csr77"));
            startActivity(openMaps);
            return true;
        }
        else if (id == R.id.resetpass){
            Intent resetPass = new Intent(SplitActivity.this,UpdateUser.class);
            startActivity(resetPass);
        }
        else if (id == R.id.sms) {
            Uri uri = Uri.parse("smsto:081541193319") ;
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
            try{
                startActivity(smsIntent);
            } catch (Exception ex) {
                Toast.makeText(SplitActivity.this, "Pengiriman SMS Gagal...",
                        Toast.LENGTH_LONG).show();
                ex.printStackTrace();}
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void postTotals()
    {
        TextView txtTot=(TextView) findViewById(R.id.totalPrice);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        txtTot.setText(String.valueOf(tot));
    }

    void addData(){
        ArrayList = new ArrayList<>();
        ArrayList.add(new ListText("ROG Strix G513QC", "17.000.000",1));
        ArrayList.add(new ListText("ROG Zephyrus G14", "20.000.999",2));
        ArrayList.add(new ListText("ROG Zephyrus G14 White", "20.000.999",3));
        ArrayList.add(new ListText("ROG Zephyrus G14 Grey", "20.000.999",4));
        ArrayList.add(new ListText("ROG Zephyrus Duo", "34.599.000",5));
        ArrayList.add(new ListText("TUF Dash-F15", "16.899.000",6));
        ArrayList.add(new ListText("ROG PHONE 5 White", "10.500.899",7));
        ArrayList.add(new ListText("ROG PHONE 5 Black", "10.500.899",8));
        ArrayList.add(new ListText("ROG Clavis USB-C Adapter", "2.769.000",9));
        ArrayList.add(new ListText("ROG Throne RGB Stand", "1.399.000",10));
    }
    public void checkout(View view) {
        postTotals();
//        TextView txtTot=(TextView) findViewById(R.id.totalPrice);
//        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
//        txtTot.setText("Rp. "+decimalFormat.format(tot));
        String transaksi = txtTot.getText().toString();
        Intent checkout = new Intent(SplitActivity.this,CheckoutActivity.class);
        checkout.putExtra("n",transaksi);
//        intent.putExtra("transaksi",tot);
        startActivity(checkout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
