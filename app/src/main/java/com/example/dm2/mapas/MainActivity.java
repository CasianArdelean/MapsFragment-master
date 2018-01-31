package com.example.dm2.mapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //COGER DE BASE DE DATOS LA LATITUD Y LONGITUD , GUARDAR  EN UN ARRAY DE LatIng Y CREAR MARKETPOINT POR CADA OBJETO DEL ARRAY


        map = googleMap;
        //CREAMOS EL PUNTO QUE QUEREMOS VER
        LatLng virgenblanca= new LatLng(42.846592,-2.673519);
        LatLng casa= new LatLng(42.846592,-2.650996);
        //AÑADIMOS ICONO PARA QUE SE VEA
        map.addMarker(new MarkerOptions().position(virgenblanca).title("virgen blanca"));
        map.addMarker(new MarkerOptions().position(casa).title("casa"));
        //EL ZOOM QUE VAMOS A HACER
        float zoom=16.0f;
        //DONDE SE VA A PONER LA UBICACION DE LA CAMARA Y SU ZOOM
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(virgenblanca,zoom));
        //CONTROLES PARA QUE PUEDA DISMINUIR Y AUMENTAR EL ZOOM
        map.getUiSettings().setZoomControlsEnabled(true);

    }
}
