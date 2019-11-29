package com.dh.repasoviewpagerfactorylima.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dh.repasoviewpagerfactorylima.dao.RoomProductoDao;
import com.dh.repasoviewpagerfactorylima.modelo.Producto;

@Database(version = 1,entities = {Producto.class},exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RoomProductoDao roomProductoDao();

    private static AppDatabase INSTANCE = null;

    public static AppDatabase getInstance(Context context){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, "mercado-esclavo-db")
                    .allowMainThreadQueries().build();
        }

        return INSTANCE;
    }
}
