package com.ejemplo.invexpro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    // d. Variables
    private VideoView videoView;
    private Button btnReproducir;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        // d. Vínculos
        videoView = view.findViewById(R.id.vv_producto_demo);
        btnReproducir = view.findViewById(R.id.btn_reproducir_video);

        // e. Eventos
        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirVideo();
            }
        });

        return view;
    }

    // e. Declaración de métodos
    private void reproducirVideo() {
        // Lógica de reproducción (ejemplo con URI local)
        // videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.video_demo));
        videoView.start();
    }
}