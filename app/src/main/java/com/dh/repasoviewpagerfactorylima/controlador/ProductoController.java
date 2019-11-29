package com.dh.repasoviewpagerfactorylima.controlador;

import com.dh.repasoviewpagerfactorylima.dao.ProductoDao;
import com.dh.repasoviewpagerfactorylima.modelo.ContenedorProducto;
import com.dh.repasoviewpagerfactorylima.util.ResultListener;

public class ProductoController {

    private ProductoDao productoDao;

    public ProductoController() {
        this.productoDao = new ProductoDao();
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
