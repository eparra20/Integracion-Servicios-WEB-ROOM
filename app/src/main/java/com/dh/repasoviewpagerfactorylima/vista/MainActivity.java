package com.dh.repasoviewpagerfactorylima.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.dh.repasoviewpagerfactorylima.R;
import com.dh.repasoviewpagerfactorylima.config.AppDatabase;
import com.dh.repasoviewpagerfactorylima.controlador.ProductoController;
import com.dh.repasoviewpagerfactorylima.modelo.ContenedorProducto;
import com.dh.repasoviewpagerfactorylima.modelo.Producto;
import com.dh.repasoviewpagerfactorylima.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView miRecyclerView;
    private RecyclerViewAdapter miRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miRecyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<Producto>());

        miRecyclerView = findViewById(R.id.recyclerView);
        miRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        miRecyclerView.setAdapter(miRecyclerViewAdapter);
        miRecyclerView.setHasFixedSize(true);

        ProductoController productoController = new ProductoController();

        productoController.obtenerResultadoController(new ResultListener<ContenedorProducto>() {
            @Override
            public void finish(ContenedorProducto results) {
                List<Producto> listaProductos = results.getResults();
                miRecyclerViewAdapter.actualizarLista(listaProductos);
            }
        });


    }
}
