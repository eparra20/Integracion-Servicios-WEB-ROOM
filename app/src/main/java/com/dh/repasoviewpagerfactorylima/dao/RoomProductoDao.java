package com.dh.repasoviewpagerfactorylima.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.dh.repasoviewpagerfactorylima.modelo.Producto;

import java.util.List;

@Dao
public interface RoomProductoDao {

    @Query("SELECT * FROM Producto")
    List<Producto> getAll();

    @Insert
    void insert(Producto... producto);

    @Insert
    void insert(List<Producto> productoList);

    @Query("DELETE FROM PRODUCTO")
    void delete();
}
