package com.ejemplo.invexpro;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {

    private ScrollView layoutProducto;
    private LinearLayout layoutFotos, layoutVideo, layoutProveedor;

    // Componentes interactivos
    private ListView listFotos;
    private TextView tvFotoDescripcion;
    private VideoView videoView;
    private WebView webView;
    private EditText etUrl;
    private Button btnCargarUrl;

    // Datos de ejemplo para la lista
    private int[] imagenes = {R.drawable.foto_producto_1, R.drawable.foto_producto_2};
    private String[] descripciones = {"Vista frontal del artículo", "Empaque original de fábrica"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        // Inicializar vistas de layouts
        layoutProducto = view.findViewById(R.id.layout_producto);
        layoutFotos = view.findViewById(R.id.layout_fotos);
        layoutVideo = view.findViewById(R.id.layout_video);
        layoutProveedor = view.findViewById(R.id.layout_proveedor);

        // Inicializar componentes
        listFotos = view.findViewById(R.id.list_fotos);
        tvFotoDescripcion = view.findViewById(R.id.tv_foto_descripcion);
        videoView = view.findViewById(R.id.video_view);
        webView = view.findViewById(R.id.web_view);
        etUrl = view.findViewById(R.id.et_url);
        btnCargarUrl = view.findViewById(R.id.btn_cargar_url);

        configurarListaFotos();
        configurarVideo();
        configurarWebView();

        return view;
    }

    private void configurarListaFotos() {
        FotosAdapter adapter = new FotosAdapter();
        listFotos.setAdapter(adapter);

        listFotos.setOnItemClickListener((parent, view, position, id) -> {
            tvFotoDescripcion.setText("Descripción: " + descripciones[position]);
        });
    }

    private void configurarVideo() {
        // Cargar video desde res/raw/video_prueba.mp4
        Uri uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_prueba);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
    }

    private void configurarWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient()); // Evita que se abra en el navegador externo

        btnCargarUrl.setOnClickListener(v -> {
            String url = etUrl.getText().toString();
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            webView.loadUrl(url);
        });
    }

    // Método para cambiar la vista desde la actividad principal
    public void cambiarSeccion(int opcion) {
        layoutProducto.setVisibility(View.GONE);
        layoutFotos.setVisibility(View.GONE);
        layoutVideo.setVisibility(View.GONE);
        layoutProveedor.setVisibility(View.GONE);

        switch (opcion) {
            case 0: layoutProducto.setVisibility(View.VISIBLE); break;
            case 1: layoutFotos.setVisibility(View.VISIBLE); break;
            case 2: layoutVideo.setVisibility(View.VISIBLE); break;
            case 3: layoutProveedor.setVisibility(View.VISIBLE); break;
        }
    }

    // Adaptador personalizado para la ListView
    class FotosAdapter extends BaseAdapter {
        @Override
        public int getCount() { return imagenes.length; }
        @Override
        public Object getItem(int position) { return imagenes[position]; }
        @Override
        public long getItemId(int position) { return position; }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_foto, parent, false);
            }
            ImageView imgItem = convertView.findViewById(R.id.img_item);
            TextView tvItemDesc = convertView.findViewById(R.id.tv_item_desc);

            imgItem.setImageResource(imagenes[position]);
            tvItemDesc.setText("Foto " + (position + 1));
            return convertView;
        }
    }
}