package com.dh.repasoviewpagerfactorylima.modelo;


import java.util.List;

public class ContenedorProducto {

    List<Producto> results;

    public ContenedorProducto(List<Producto> results) {
        this.results = results;
    }

    public ContenedorProducto() {
    }


    public List<Producto> getResults() {
        return results;
    }

    public void setResults(List<Producto> results) {
        this.results = results;
    }
}
