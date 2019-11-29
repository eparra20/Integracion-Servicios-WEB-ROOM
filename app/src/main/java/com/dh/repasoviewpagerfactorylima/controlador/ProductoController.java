package com.dh.repasoviewpagerfactorylima.controlador;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dh.repasoviewpagerfactorylima.config.AppDatabase;
import com.dh.repasoviewpagerfactorylima.dao.ProductoDao;
import com.dh.repasoviewpagerfactorylima.dao.RoomProductoDao;
import com.dh.repasoviewpagerfactorylima.modelo.ContenedorProducto;
import com.dh.repasoviewpagerfactorylima.modelo.Producto;
import com.dh.repasoviewpagerfactorylima.util.ResultListener;

import java.util.List;

public class ProductoController {

    private ProductoDao productoDao;
    private RoomProductoDao roomProductoDao;
    private Context context;

    public ProductoController(Context context) {
        this.context = context;
        this.productoDao = new ProductoDao();
        this.roomProductoDao = AppDatabase.getInstance(context).roomProductoDao();
    }

    public void obtenerResultadoController(final ResultListener<ContenedorProducto> escuchadorDeLaVista){

        if (hayInternet()){
            productoDao.obtenerResultadoDao(new ResultListener<ContenedorProducto>() {
                @Override
                public void finish(ContenedorProducto results) {
                    //antes de devolver los resultados a la view, los guardo en la base
                    roomProductoDao.delete();
                    roomProductoDao.insert(results.getResults());
                    escuchadorDeLaVista.finish(results);
                }
            });
        }else{
            List<Producto> productoList = roomProductoDao.getAll();
            ContenedorProducto contenedorProducto = new ContenedorProducto(productoList);
            escuchadorDeLaVista.finish(contenedorProducto);
        }

    }

    public Boolean hayInternet(){

        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
