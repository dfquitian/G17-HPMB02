package com.ejemplo.invexpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FotosFragment extends Fragment {

    // d. Definición de variables
    private RecyclerView rvGaleria;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fotos, container, false);

        // d. Vínculos con identificadores
        rvGaleria = view.findViewById(R.id.rv_galeria_fotos);

        // e. Declaración de método para configurar la lista
        configurarRecyclerView();

        return view;
    }

    private void configurarRecyclerView() {
        rvGaleria.setLayoutManager(new LinearLayoutManager(getContext()));
        // Aquí iría la asignación del adaptador (Adapter) para cargar las imágenes
    }
}