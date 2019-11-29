package com.dh.repasoviewpagerfactorylima.dao;

import com.dh.repasoviewpagerfactorylima.modelo.ContenedorProducto;
import com.dh.repasoviewpagerfactorylima.util.ProductoService;
import com.dh.repasoviewpagerfactorylima.util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductoDao {

    private ProductoService productoService;
    private Retrofit retrofit;
    public static final String BASE_URL = "https://api.mercadolibre.com/sites/MLA/";

    public ProductoDao() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        productoService = retrofit.create(ProductoService.class);
    }

    public void obtenerResultadoDao(final ResultListener<ContenedorProducto> escuchadorDelControler){
        Call<ContenedorProducto> callProductos = productoService.getCallService("gatitos");

        callProductos.enqueue(new Callback<ContenedorProducto>() {
            @Override
            public void onResponse(Call<ContenedorProducto> call, Response<ContenedorProducto> response) {
                ContenedorProducto contenedorProductoDeInternet = response.body();
                escuchadorDelControler.finish(contenedorProductoDeInternet);
            }

            @Override
            public void onFailure(Call<ContenedorProducto> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }


}
