package com.dh.repasoviewpagerfactorylima.util;

import com.dh.repasoviewpagerfactorylima.modelo.ContenedorProducto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductoService {

    @GET("search")
    Call<ContenedorProducto> getCallService(@Query("q") String productoBuscado);

}
