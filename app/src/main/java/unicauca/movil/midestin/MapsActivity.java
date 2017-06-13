package unicauca.movil.midestin;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import unicauca.movil.midestin.DataSites.DataSites;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    public  static int origen ;
    public static  int destino ;
    public  static String nombreOrigen;
    public static String nombreDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        origen = getIntent().getExtras().getInt("ORIGEN");
        destino = getIntent().getExtras().getInt("DESTINO");

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

        Log.d("luggg", ""+origen);
        if (origen == 1 && destino ==2 || destino==1 && origen ==2 ){


            nombreOrigen = DataSites.getPlaces().get(0).getNombre();
            nombreDestino = DataSites.getPlaces().get(1).getNombre();
            LatLng origen = new LatLng(DataSites.getPlaces().get(0).getLatitud(),DataSites.getPlaces().get(0).getLongitud() );
            LatLng destino = new LatLng(DataSites.getPlaces().get(1).getLatitud(),DataSites.getPlaces().get(1).getLongitud());
            mMap.addMarker(new MarkerOptions().position(origen).title(DataSites.getPlaces().get(0).getNombre()));
            mMap.addMarker(new MarkerOptions().position(destino).title(DataSites.getPlaces().get(1).getNombre()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origen,8));
            mMap.addPolyline(new PolylineOptions().add(
                    origen,
                    new LatLng(3.264997, -76.529923),
                    new LatLng(2.892021, -76.546402),

                    destino
                    )
                            .width(10)
                            .color(Color.BLUE)
            );

        }

        if (origen ==1 && destino==3 || destino==1 && origen ==3 ){
            nombreOrigen = DataSites.getPlaces().get(0).getNombre();
            nombreDestino = DataSites.getPlaces().get(2).getNombre();
            LatLng origen = new LatLng(DataSites.getPlaces().get(0).getLatitud(),DataSites.getPlaces().get(0).getLongitud() );
            LatLng destino = new LatLng(DataSites.getPlaces().get(2).getLatitud(),DataSites.getPlaces().get(2).getLongitud());
            mMap.addMarker(new MarkerOptions().position(origen).title(DataSites.getPlaces().get(0).getNombre()));
            mMap.addMarker(new MarkerOptions().position(destino).title(DataSites.getPlaces().get(2).getNombre()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origen,6));
            mMap.addPolyline(new PolylineOptions().add(
                    origen,
                    new LatLng(3.329513, -76.350449),
                    new LatLng(3.636561, -76.295518),
                    new LatLng(4.327025, -76.086777),
                    new LatLng(4.524189, -75.630845),
                    new LatLng(4.420137, -75.246323),
                    new LatLng(4.228423, -74.982651),
                    destino
            )
                    .width(10)
                    .color(Color.BLUE) );}

        if (origen == 2 && destino ==3 || destino ==2 && origen==3){

            nombreOrigen = DataSites.getPlaces().get(1).getNombre();
            nombreDestino = DataSites.getPlaces().get(2).getNombre();
            LatLng origen = new LatLng(DataSites.getPlaces().get(1).getLatitud(),DataSites.getPlaces().get(1).getLongitud() );
            LatLng destino = new LatLng(DataSites.getPlaces().get(2).getLatitud(),DataSites.getPlaces().get(2).getLongitud());
            mMap.addMarker(new MarkerOptions().position(origen).title(DataSites.getPlaces().get(1).getNombre()));
            mMap.addMarker(new MarkerOptions().position(destino).title(DataSites.getPlaces().get(2).getNombre()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origen,6));
            mMap.addPolyline(new PolylineOptions().add(
                    origen,
                    new LatLng(3.44,-76.519722),
                    new LatLng(3.329513, -76.350449),
                    new LatLng(3.636561, -76.295518),
                    new LatLng(4.327025, -76.086777),
                    new LatLng(4.524189, -75.630845),
                    new LatLng(4.420137, -75.246323),
                    new LatLng(4.228423, -74.982651),
                    destino
            )
                    .width(10)
                    .color(Color.BLUE) );
        }






    }








}
