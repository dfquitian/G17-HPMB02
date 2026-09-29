package com.ejemplo.invexpro;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import com.ejemplo.invexpro.ProductoFragment;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.fragment.app.Fragment;
//import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    // d. Definición de variables
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // d. Vínculos de las variables con los identificadores XML
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // e. Identificación de eventos (clics en el menú)
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return seleccionarItemMenu(item);
            }
        });

        // Cargar fragmento inicial por defecto
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProductoFragment()).commit();
        }
    }

    // e. Declaración de métodos
    private boolean seleccionarItemMenu(MenuItem item) {
        Fragment fragment = null;
        int itemId = item.getItemId();

        // Lógica de selección según el ID del menú (asumiendo que los creaste en res/menu/nav_menu.xml)
        if (itemId == R.id.nav_producto) {
            fragment = new ProductoFragment();
        } else if (itemId == R.id.nav_fotos) {
            fragment = new FotosFragment();
        } else if (itemId == R.id.nav_video) {
            fragment = new VideoFragment();
        } else if (itemId == R.id.nav_proveedor) {
            fragment = new ProveedorFragment();
        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            drawerLayout.closeDrawers();
            return true;
        }
        return false;
    }
}