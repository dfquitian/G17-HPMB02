package com.ejemplo.invexpro;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    public interface OnMenuInteractionListener {
        void onOptionSelected(int option);
    }

    private OnMenuInteractionListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnMenuInteractionListener) {
            mListener = (OnMenuInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " debe implementar OnMenuInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        Button btnProducto = view.findViewById(R.id.btn_producto);
        Button btnFotos = view.findViewById(R.id.btn_fotos);
        Button btnVideo = view.findViewById(R.id.btn_video);
        Button btnProveedor = view.findViewById(R.id.btn_proveedor);

        btnProducto.setOnClickListener(v -> mListener.onOptionSelected(0));
        btnFotos.setOnClickListener(v -> mListener.onOptionSelected(1));
        btnVideo.setOnClickListener(v -> mListener.onOptionSelected(2));
        btnProveedor.setOnClickListener(v -> mListener.onOptionSelected(3));

        return view;
    }
}
