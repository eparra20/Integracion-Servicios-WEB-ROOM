package com.dh.repasoviewpagerfactorylima.modelo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class Producto implements Serializable {

    @PrimaryKey
    //todo corregir.
    @SerializedName("NOEXISTES")
    private Integer id;

    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "thumbnail")
    private String thumbnail;
    @ColumnInfo(name = "price")
    private String price;

    @Ignore
    public Producto(String title, String thumbnail, String price) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.price = price;
    }

    public Producto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
