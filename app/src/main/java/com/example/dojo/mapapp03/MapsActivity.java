package com.example.dojo.mapapp03;

import android.graphics.Color;
import android.hardware.input.InputManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // シドニーの緯度経度を設定して、そこにマーカーを設置
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        //日本のどこかの緯度経度を設定して、そこにマーカーを設置
        LatLng Oosaka = new LatLng(34.664516, 135.492418);
        mMap.addMarker(new MarkerOptions().position(Oosaka).title("Marker in Oosaka"));

        //北米のどこかの緯度経度を設定して、そこにマーカーを設置
        LatLng redDevil = new LatLng(61.759120, -157.312928);
        mMap.addMarker(new MarkerOptions().position(redDevil).title("Marker in redDevil"));

        //カメラの位置とズームを設定
        LatLng center = new LatLng(20.701566, 178.011535);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center,2));


        //線を描く
//        PolylineOptions line  = new PolylineOptions()
//                .add(redDevil,sydney,Oosaka)
//                .geodesic(true)
//                //色、太さ、測地線
//
//
//                .color(Color.BLUE)
//                .width(20);
//        mMap.addPolyline(line);

//        mMap.addPolyline(line);



        // 描画内容の設定
//PolygonOptions triangle = new PolygonOptions()
//        .add(Oosaka,redDevil,sydney)
//        .fillColor(Color.argb(100,255,0,0))
//        .strokeColor(Color.GREEN)
//        .strokeWidth(5);
//mMap.addPolygon(triangle);

    //三地点を中心とする半透明の円を描く（三つの円が重なるように）

        CircleOptions circle = new CircleOptions();
        circle.center(Oosaka);
        circle.radius(100000);



        mMap.addCircle(circle);

    }
}
