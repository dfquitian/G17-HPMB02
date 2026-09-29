package com.ejemplo.invexpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class ProductoFragment extends Fragment {

    // d. Definición de variables
    private ImageView imgProducto;
    private EditText etCodigo, etStock;
    private Button btnGuardar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto, container, false);

        // d. Vínculos con identificadores
        imgProducto = view.findViewById(R.id.img_producto);
        etCodigo = view.findViewById(R.id.et_codigo_producto);
        etStock = view.findViewById(R.id.et_stock_producto);
        btnGuardar = view.findViewById(R.id.btn_guardar_producto);

        // e. Identificación de eventos
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarProducto();
            }
        });

        return view;
    }

    // e. Declaración de métodos
    private void guardarProducto() {
        String codigo = etCodigo.getText().toString();
        String stock = etStock.getText().toString();
        // Lógica para guardar la información
        Toast.makeText(getContext(), "Producto " + codigo + " actualizado con stock: " + stock, Toast.LENGTH_SHORT).show();
    }
}