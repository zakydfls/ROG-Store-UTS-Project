package com.example.sharedpref;

public class ListText {

    private String nama;
    private String harga;
    private int img;
    public ListText(String nama, String harga,int img) {
        this.nama = nama;
        this.harga = harga;
        this.img=img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    public void setImg(int img) {
        this.img = img;
    }
    public int getImg() {
        return img;
    }
}
