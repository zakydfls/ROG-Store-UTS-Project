package com.example.sharedpref;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import java.io.IOException;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MahasiswaViewHolder> {
    public interface ItemClickListener {
        void onClick(View view, int position);
    }
    private ArrayList<ListText> dataList;
    private String KEY_TOT="TOT";
    public double tot=0;
    int gambar[] = {R.drawable.d1, R.drawable.d2, R.drawable.d3,
            R.drawable.d4, R.drawable.d5, R.drawable.d6, R.drawable.d7,R.drawable.d8, R.drawable.d9, R.drawable.d10};
    public ListAdapter(ArrayList<ListText> dataList) {this.dataList = dataList;}
    private ItemClickListener clickListener;

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MahasiswaViewHolder holder, int position){
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtNoHp.setText(dataList.get(position).getHarga());
        holder.icon.setImageResource(gambar[position]);
    }

    @Override
    public int getItemCount() { return (dataList != null) ? dataList.size() : 0;}
    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtNama, txtNoHp;
        private ImageView icon;
        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNoHp = (TextView) itemView.findViewById(R.id.txt_nohp_mahasiswa);
            icon=(ImageView) itemView.findViewById(R.id.img_card);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            txtNama.setOnClickListener(this);
            icon.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(clickListener != null) clickListener.onClick(view,
                    getAdapterPosition());
        }
    }
    public double getTot()
    {
        return  tot;
    }
    public void setTot(double tot)
    {
        this.tot=tot;
    }
}
