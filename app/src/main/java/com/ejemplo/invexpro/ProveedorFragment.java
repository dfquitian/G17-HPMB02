package com.ejemplo.invexpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;

public class ProveedorFragment extends Fragment {

    // d. Variables
    private WebView wvProveedor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_proveedor, container, false);

        // d. Vínculos
        wvProveedor = view.findViewById(R.id.wv_proveedor);

        // e. Llamado de métodos
        cargarSitioProveedor();

        return view;
    }

    // e. Declaración de métodos
    private void cargarSitioProveedor() {
        WebSettings webSettings = wvProveedor.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wvProveedor.setWebViewClient(new WebViewClient()); // Para que cargue dentro de la app
        wvProveedor.loadUrl("https://www.google.com"); // URL del proveedor de ejemplo
    }
}