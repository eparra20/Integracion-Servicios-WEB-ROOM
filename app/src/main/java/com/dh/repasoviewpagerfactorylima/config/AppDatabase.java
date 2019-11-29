package com.dh.repasoviewpagerfactorylima.config;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.dh.repasoviewpagerfactorylima.dao.RoomProductoDao;
import com.dh.repasoviewpagerfactorylima.modelo.Producto;

@Database(version = 1,entities = {Producto.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract RoomProductoDao roomProductoDao();
}
