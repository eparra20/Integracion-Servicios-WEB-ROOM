package com.dh.repasoviewpagerfactorylima.controlador;

import android.content.Context;

import com.dh.repasoviewpagerfactorylima.config.AppDatabase;
import com.dh.repasoviewpagerfactorylima.dao.ProductoDao;
import com.dh.repasoviewpagerfactorylima.dao.RoomProductoDao;
import com.dh.repasoviewpagerfactorylima.modelo.ContenedorProducto;
import com.dh.repasoviewpagerfactorylima.util.ResultListener;

public class ProductoController {

    private ProductoDao productoDao;
    private RoomProductoDao roomProductoDao;

    public ProductoController(Context context) {
        this.productoDao = new ProductoDao();
        this.roomProductoDao = AppDatabase.getInstance(context).roomProductoDao();
    }

    public void obtenerResultadoController(final ResultListener<ContenedorProducto> escuchadorDeLaVista){
        productoDao.obtenerResultadoDao(new ResultListener<ContenedorProducto>() {
            @Override
            public void finish(ContenedorProducto results) {
                escuchadorDeLaVista.finish(results);
            }
        });
    }
}
