package com.skybox.isasetiawan.emochi;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions ;

import java.util.ArrayList;

public class PetaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    int kodeangkot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peta);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        kodeangkot = getIntent().getIntExtra("kodeangkot",0);
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
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        ArrayList<PolylineOptions> es = new ArrayList<>();

        PolylineOptions  angkot1 = new PolylineOptions ()
                .add(new LatLng( -6.922403, 106.974366 ))
                .add(new LatLng( -6.917462, 106.973540 ))
                .add(new LatLng( -6.923069, 106.935524 ))
                .add(new LatLng( -6.921044, 106.935655 ))
                .add(new LatLng( -6.920637, 106.931536 ))
                .add(new LatLng( -6.924885, 106.930267 ))
                .add(new LatLng( -6.924244, 106.927421 ))
                .add(new LatLng( -6.924886, 106.927296 ))
                .add(new LatLng( -6.926221, 106.933461 ))
                .add(new LatLng( -6.922923, 106.934035 ))
                .add(new LatLng( -6.923068, 106.935502 ))
                .add(new LatLng( -6.917503, 106.973557 ))
                ;
        PolylineOptions  angkot2 = new PolylineOptions ()
                .add(new LatLng( -6.943416, 106.951852 ))
                .add(new LatLng( -6.937821, 106.953653 ))
                .add(new LatLng( -6.936845, 106.952550 ))
                .add(new LatLng( -6.935253, 106.951085 ))
                .add(new LatLng( -6.932878, 106.950063 ))
                .add(new LatLng( -6.931276, 106.945612 ))
                .add(new LatLng( -6.920729, 106.950055 ))
                .add(new LatLng( -6.923081, 106.935554 ))
                .add(new LatLng( -6.920886, 106.935619 ))
                .add(new LatLng( -6.920728, 106.934305 ))
                .add(new LatLng( -6.920602, 106.931498 ))
                .add(new LatLng( -6.922607, 106.930964 ))
                .add(new LatLng( -6.924878, 106.930265 ))
                .add(new LatLng( -6.924299, 106.927465 ))
                .add(new LatLng( -6.924888, 106.927286 ))
                .add(new LatLng( -6.926263, 106.933490 ))
                .add(new LatLng( -6.922928, 106.934059 ))
                .add(new LatLng( -6.920729, 106.950055 ))
                .add(new LatLng( -6.931276, 106.945612 ))
                .add(new LatLng( -6.932878, 106.950063 ))
                .add(new LatLng( -6.935253, 106.951085 ))
                .add(new LatLng( -6.936845, 106.952550 ))
                .add(new LatLng( -6.937821, 106.953653 ))
                .add(new LatLng( -6.943416, 106.951852 ))
                ;
        PolylineOptions  angkot3 = new PolylineOptions ()
                .add(new LatLng( -6.959538, 106.890866 ))
                .add(new LatLng( -6.957962, 106.902061 ))
                .add(new LatLng( -6.955939, 106.909125 ))
                .add(new LatLng( -6.951948, 106.912243 ))
                .add(new LatLng( -6.947555, 106.915942 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.940862, 106.923185 ))
                .add(new LatLng( -6.938743, 106.923734 ))
                .add(new LatLng( -6.930288, 106.925855 ))
                .add(new LatLng( -6.925604, 106.927057 ))
                .add(new LatLng( -6.925312, 106.925665 ))
                .add(new LatLng( -6.924335, 106.925747 ))
                .add(new LatLng( -6.923198, 106.921904 ))
                .add(new LatLng( -6.925005, 106.921434 ))
                .add(new LatLng( -6.930327, 106.920261 ))
                .add(new LatLng( -6.930617, 106.921013 ))
                .add(new LatLng( -6.930327, 106.920261 ))
                .add(new LatLng( -6.938107, 106.920949 ))
                .add(new LatLng( -6.938743, 106.923734 ))
                .add(new LatLng( -6.940862, 106.923185 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947555, 106.915942 ))
                .add(new LatLng( -6.951948, 106.912243 ))
                .add(new LatLng( -6.955939, 106.909125 ))
                .add(new LatLng( -6.957962, 106.902061 ))
                .add(new LatLng( -6.959538, 106.890866 ))
                ;
        PolylineOptions  angkot4 = new PolylineOptions ()
                .add(new LatLng( -6.959538, 106.890866 ))
                .add(new LatLng( -6.957962, 106.902061 ))
                .add(new LatLng( -6.955939, 106.909125 ))
                .add(new LatLng( -6.951948, 106.912243 ))
                .add(new LatLng( -6.947555, 106.915942 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.940862, 106.923185 ))
                .add(new LatLng( -6.938743, 106.923734 ))
                .add(new LatLng( -6.930288, 106.925855 ))
                .add(new LatLng( -6.925604, 106.927057 ))
                .add(new LatLng( -6.925312, 106.925665 ))
                .add(new LatLng( -6.924335, 106.925747 ))
                .add(new LatLng( -6.924812, 106.927296 ))
                .add(new LatLng( -6.925604, 106.927057 ))
                .add(new LatLng( -6.930288, 106.925855 ))
                .add(new LatLng( -6.938743, 106.923734 ))
                .add(new LatLng( -6.940862, 106.923185 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947555, 106.915942 ))
                .add(new LatLng( -6.951948, 106.912243 ))
                .add(new LatLng( -6.955939, 106.909125 ))
                .add(new LatLng( -6.957962, 106.902061 ))
                .add(new LatLng( -6.959538, 106.890866 ))
                ;
        PolylineOptions  angkot5 = new PolylineOptions ()
                .add(new LatLng( -6.870283, 106.974559 ))
                .add(new LatLng( -6.918612, 106.959857 ))
                .add(new LatLng( -6.919358, 106.955349 ))
                .add(new LatLng( -6.922363, 106.942659 ))
                .add(new LatLng( -6.922790, 106.940079 ))
                .add(new LatLng( -6.923069, 106.935524 ))
                .add(new LatLng( -6.921044, 106.935655 ))
                .add(new LatLng( -6.920637, 106.931536 ))
                .add(new LatLng( -6.922608, 106.930958 ))
                .add(new LatLng( -6.924885, 106.930267 ))
                .add(new LatLng( -6.924244, 106.927421 ))
                .add(new LatLng( -6.924886, 106.927296 ))
                .add(new LatLng( -6.926221, 106.933461 ))
                .add(new LatLng( -6.922923, 106.934035 ))
                .add(new LatLng( -6.923069, 106.935524 ))
                .add(new LatLng( -6.922790, 106.940079 ))
                .add(new LatLng( -6.922363, 106.942659 ))
                .add(new LatLng( -6.919358, 106.955349 ))
                .add(new LatLng( -6.918612, 106.959857 ))
                .add(new LatLng( -6.870283, 106.974559 ))
                ;
        PolylineOptions  angkot6 = new PolylineOptions ()
                .add(new LatLng( -6.911150, 106.945329 ))
                .add(new LatLng( -6.915024, 106.944403 ))
                .add(new LatLng( -6.917665, 106.944246 ))
                .add(new LatLng( -6.918012, 106.945056 ))
                .add(new LatLng( -6.922122, 106.943313 ))
                .add(new LatLng( -6.922363, 106.942659 ))
                .add(new LatLng( -6.922790, 106.940079 ))
                .add(new LatLng( -6.923069, 106.935524 ))
                .add(new LatLng( -6.921044, 106.935655 ))
                .add(new LatLng( -6.920637, 106.931536 ))
                .add(new LatLng( -6.922608, 106.930958 ))
                .add(new LatLng( -6.924885, 106.930267 ))
                .add(new LatLng( -6.924244, 106.927421 ))
                .add(new LatLng( -6.924886, 106.927296 ))
                .add(new LatLng( -6.926221, 106.933461 ))
                .add(new LatLng( -6.922923, 106.934035 ))
                .add(new LatLng( -6.923069, 106.935524 ))
                .add(new LatLng( -6.922790, 106.940079 ))
                .add(new LatLng( -6.922363, 106.942659 ))
                .add(new LatLng( -6.922122, 106.943313 ))
                .add(new LatLng( -6.918012, 106.945056 ))
                .add(new LatLng( -6.917665, 106.944246 ))
                .add(new LatLng( -6.915024, 106.944403 ))
                .add(new LatLng( -6.911150, 106.945329 ))
                ;
        PolylineOptions  angkot7 = new PolylineOptions ()
                .add(new LatLng( -6.959538, 106.890866 ))
                .add(new LatLng( -6.957962, 106.902061 ))
                .add(new LatLng( -6.955939, 106.909125 ))
                .add(new LatLng( -6.951948, 106.912243 ))
                .add(new LatLng( -6.947555, 106.915942 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.940862, 106.923185 ))
                .add(new LatLng( -6.938743, 106.923734 ))
                .add(new LatLng( -6.938107, 106.920949 ))
                .add(new LatLng( -6.932839, 106.920931 ))
                .add(new LatLng( -6.930617, 106.921013 ))
                .add(new LatLng( -6.930327, 106.920261 ))
                .add(new LatLng( -6.925005, 106.921434 ))
                .add(new LatLng( -6.923198, 106.921904 ))
                .add(new LatLng( -6.921418, 106.922264 ))
                .add(new LatLng( -6.920195, 106.915640 ))
                .add(new LatLng( -6.921732, 106.916033 ))
                .add(new LatLng( -6.924133, 106.915198 ))
                .add(new LatLng( -6.925393, 106.918950 ))
                .add(new LatLng( -6.926454, 106.921118 ))
                .add(new LatLng( -6.930327, 106.920261 ))
                .add(new LatLng( -6.930617, 106.921013 ))
                .add(new LatLng( -6.930327, 106.920261 ))
                .add(new LatLng( -6.938107, 106.920949 ))
                .add(new LatLng( -6.938743, 106.923734 ))
                .add(new LatLng( -6.940862, 106.923185 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947555, 106.915942 ))
                .add(new LatLng( -6.951948, 106.912243 ))
                .add(new LatLng( -6.955939, 106.909125 ))
                .add(new LatLng( -6.957962, 106.902061 ))
                .add(new LatLng( -6.959538, 106.890866 ))
                ;
        PolylineOptions  angkot8 = new PolylineOptions ()
                .add(new LatLng( -6.907082, 106.890211 ))
                .add(new LatLng( -6.908075, 106.891649 ))
                .add(new LatLng( -6.912020, 106.897372 ))
                .add(new LatLng( -6.912383, 106.905061 ))
                .add(new LatLng( -6.918017, 106.911602 ))
                .add(new LatLng( -6.919193, 106.915982 ))
                .add(new LatLng( -6.920446, 106.921662 ))
                .add(new LatLng( -6.918341, 106.925848 ))
                .add(new LatLng( -6.919789, 106.927573 ))
                .add(new LatLng( -6.920613, 106.931340 ))
                .add(new LatLng( -6.922577, 106.930966 ))
                .add(new LatLng( -6.924233, 106.930667 ))
                .add(new LatLng( -6.923925, 106.929514 ))
                .add(new LatLng( -6.923477, 106.927593 ))
                .add(new LatLng( -6.923087, 106.925866 ))
                .add(new LatLng( -6.921951, 106.925931 ))
                .add(new LatLng( -6.921538, 106.923313 ))
                .add(new LatLng( -6.921400, 106.922271 ))
                .add(new LatLng( -6.920180, 106.915646 ))
                .add(new LatLng( -6.919193, 106.915982 ))
                .add(new LatLng( -6.918017, 106.911602 ))
                .add(new LatLng( -6.912383, 106.905061 ))
                .add(new LatLng( -6.912020, 106.897372 ))
                .add(new LatLng( -6.908075, 106.891649 ))
                .add(new LatLng( -6.909279, 106.890885 ))
                .add(new LatLng( -6.908156, 106.889378 ))
                .add(new LatLng( -6.907082, 106.890211 ))
                ;
        PolylineOptions  angkot9 = new PolylineOptions ()
                .add(new LatLng( -6.928517, 106.902703 ))
                .add(new LatLng( -6.922989, 106.902968 ))
                .add(new LatLng( -6.921400, 106.905513 ))
                .add(new LatLng( -6.918693, 106.905800 ))
                .add(new LatLng( -6.913905, 106.905664 ))
                .add(new LatLng( -6.918017, 106.911602 ))
                .add(new LatLng( -6.919193, 106.915982 ))
                .add(new LatLng( -6.920446, 106.921662 ))
                .add(new LatLng( -6.918341, 106.925848 ))
                .add(new LatLng( -6.919789, 106.927573 ))
                .add(new LatLng( -6.921923, 106.925953 ))
                .add(new LatLng( -6.923315, 106.926198 ))
                .add(new LatLng( -6.924068, 106.926100 ))
                .add(new LatLng( -6.923051, 106.922025 ))
                .add(new LatLng( -6.921427, 106.922263 ))
                .add(new LatLng( -6.920180, 106.915646 ))
                .add(new LatLng( -6.919193, 106.915982 ))
                .add(new LatLng( -6.918017, 106.911602 ))
                .add(new LatLng( -6.913905, 106.905664 ))
                .add(new LatLng( -6.918693, 106.905800 ))
                .add(new LatLng( -6.921400, 106.905513 ))
                .add(new LatLng( -6.922989, 106.902968 ))
                .add(new LatLng( -6.928517, 106.902703 ))
                ;
        PolylineOptions  angkot10 = new PolylineOptions ()
                .add(new LatLng( -6.870415, 106.951007 ))
                .add(new LatLng( -6.879101, 106.947412 ))
                .add(new LatLng( -6.887593, 106.941900 ))
                .add(new LatLng( -6.889905, 106.940072 ))
                .add(new LatLng( -6.893410, 106.938629 ))
                .add(new LatLng( -6.896331, 106.938520 ))
                .add(new LatLng( -6.903951, 106.937775 ))
                .add(new LatLng( -6.910737, 106.935433 ))
                .add(new LatLng( -6.912957, 106.933670 ))
                .add(new LatLng( -6.914388, 106.933079 ))
                .add(new LatLng( -6.917393, 106.929549 ))
                .add(new LatLng( -6.919777, 106.927575 ))
                .add(new LatLng( -6.920548, 106.931053 ))
                .add(new LatLng( -6.920703, 106.932295 ))
                .add(new LatLng( -6.920745, 106.934318 ))
                .add(new LatLng( -6.920843, 106.935641 ))
                .add(new LatLng( -6.918478, 106.936120 ))
                .add(new LatLng( -6.914727, 106.935608 ))
                .add(new LatLng( -6.910737, 106.935433 ))
                .add(new LatLng( -6.903951, 106.937775 ))
                .add(new LatLng( -6.896331, 106.938520 ))
                .add(new LatLng( -6.893410, 106.938629 ))
                .add(new LatLng( -6.889905, 106.940072 ))
                .add(new LatLng( -6.887593, 106.941900 ))
                .add(new LatLng( -6.879101, 106.947412 ))
                .add(new LatLng( -6.870415, 106.951007 ))
                ;
        PolylineOptions  angkot11 = new PolylineOptions ()
                .add(new LatLng( -6.919688, 106.925380 ))
                .add(new LatLng( -6.918380, 106.926125 ))
                .add(new LatLng( -6.918347, 106.925844 ))
                .add(new LatLng( -6.917707, 106.925680 ))
                .add(new LatLng( -6.914798, 106.927387 ))
                .add(new LatLng( -6.912148, 106.929162 ))
                .add(new LatLng( -6.911280, 106.929085 ))
                .add(new LatLng( -6.907595, 106.928449 ))
                .add(new LatLng( -6.904718, 106.929735 ))
                .add(new LatLng( -6.901609, 106.928109 ))
                .add(new LatLng( -6.901778, 106.926668 ))
                .add(new LatLng( -6.898938, 106.924404 ))
                .add(new LatLng( -6.897278, 106.923559 ))
                .add(new LatLng( -6.895548, 106.923936 ))
                .add(new LatLng( -6.891304, 106.923741 ))
                ;
        PolylineOptions  angkot12 = new PolylineOptions ()
                .add(new LatLng( -6.919784, 106.927561 ))
                .add(new LatLng( -6.920551, 106.931055 ))
                .add(new LatLng( -6.920748, 106.934285 ))
                .add(new LatLng( -6.920823, 106.935615 ))
                .add(new LatLng( -6.918469, 106.936112 ))
                .add(new LatLng( -6.918179, 106.931588 ))
                .add(new LatLng( -6.917395, 106.929556 ))
                .add(new LatLng( -6.915301, 106.932540 ))
                .add(new LatLng( -6.913513, 106.931504 ))
                .add(new LatLng( -6.912150, 106.929154 ))
                .add(new LatLng( -6.910881, 106.926962 ))
                .add(new LatLng( -6.911046, 106.924615 ))
                .add(new LatLng( -6.910214, 106.921995 ))
                .add(new LatLng( -6.916128, 106.919204 ))
                .add(new LatLng( -6.917197, 106.916692 ))
                .add(new LatLng( -6.919208, 106.915988 ))
                .add(new LatLng( -6.919733, 106.919409 ))
                .add(new LatLng( -6.920426, 106.921705 ))
                .add(new LatLng( -6.919439, 106.922787 ))
                .add(new LatLng( -6.918324, 106.926235 ))
                .add(new LatLng( -6.919784, 106.927561 ))
                ;
        PolylineOptions  angkot13 = new PolylineOptions ()
                .add(new LatLng( -6.919784, 106.927561 ))
                .add(new LatLng( -6.921809, 106.926038 ))
                .add(new LatLng( -6.921546, 106.923288 ))
                .add(new LatLng( -6.920613, 106.917922 ))
                .add(new LatLng( -6.920189, 106.915657 ))
                .add(new LatLng( -6.919207, 106.915983 ))
                .add(new LatLng( -6.916103, 106.919189 ))
                .add(new LatLng( -6.910223, 106.921975 ))
                .add(new LatLng( -6.911035, 106.924636 ))
                .add(new LatLng( -6.912162, 106.929146 ))
                .add(new LatLng( -6.914957, 106.932528 ))
                .add(new LatLng( -6.914441, 106.933085 ))
                .add(new LatLng( -6.914782, 106.935580 ))
                .add(new LatLng( -6.918468, 106.936125 ))
                .add(new LatLng( -6.920825, 106.935619 ))
                .add(new LatLng( -6.920735, 106.934278 ))
                .add(new LatLng( -6.920603, 106.931336 ))
                .add(new LatLng( -6.919784, 106.927561 ))
                ;
        PolylineOptions  angkot14 = new PolylineOptions ()
                .add(new LatLng( -6.952250, 106.922068 ))
                .add(new LatLng( -6.951083, 106.923310 ))
                .add(new LatLng( -6.946347, 106.923355 ))
                .add(new LatLng( -6.946483, 106.923804 ))
                .add(new LatLng( -6.943687, 106.924778 ))
                .add(new LatLng( -6.940883, 106.923176 ))
                .add(new LatLng( -6.933434, 106.925138 ))
                .add(new LatLng( -6.930267, 106.925862 ))
                .add(new LatLng( -6.928879, 106.926249 ))
                .add(new LatLng( -6.929031, 106.927389 ))
                .add(new LatLng( -6.926869, 106.928456 ))
                .add(new LatLng( -6.927489, 106.930941 ))
                .add(new LatLng( -6.927472, 106.933305 ))
                .add(new LatLng( -6.926267, 106.933506 ))
                .add(new LatLng( -6.925705, 106.930687 ))
                .add(new LatLng( -6.924918, 106.927277 ))
                .add(new LatLng( -6.927089, 106.926725 ))
                .add(new LatLng( -6.928861, 106.926200 ))
                .add(new LatLng( -6.930267, 106.925862 ))
                .add(new LatLng( -6.933434, 106.925138 ))
                .add(new LatLng( -6.940883, 106.923176 ))
                .add(new LatLng( -6.943687, 106.924778 ))
                .add(new LatLng( -6.946483, 106.923804 ))
                .add(new LatLng( -6.946347, 106.923355 ))
                .add(new LatLng( -6.951083, 106.923310 ))
                .add(new LatLng( -6.952250, 106.922068 ))
                ;
        PolylineOptions  angkot15 = new PolylineOptions ()
                .add(new LatLng( -6.964115, 106.918207 ))
                .add(new LatLng( -6.962308, 106.914573 ))
                .add(new LatLng( -6.961081, 106.914109 ))
                .add(new LatLng( -6.959542, 106.910805 ))
                .add(new LatLng( -6.959357, 106.909020 ))
                .add(new LatLng( -6.955951, 106.909120 ))
                .add(new LatLng( -6.952573, 106.911939 ))
                .add(new LatLng( -6.947671, 106.915940 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.938743, 106.923734 ))
                .add(new LatLng( -6.930288, 106.925855 ))
                .add(new LatLng( -6.928879, 106.926249 ))
                .add(new LatLng( -6.929031, 106.927389 ))
                .add(new LatLng( -6.926869, 106.928456 ))
                .add(new LatLng( -6.927489, 106.930941 ))
                .add(new LatLng( -6.927472, 106.933305 ))
                .add(new LatLng( -6.926267, 106.933506 ))
                .add(new LatLng( -6.925705, 106.930687 ))
                .add(new LatLng( -6.924918, 106.927277 ))
                .add(new LatLng( -6.927089, 106.926725 ))
                .add(new LatLng( -6.928861, 106.926200 ))
                .add(new LatLng( -6.930267, 106.925862 ))
                .add(new LatLng( -6.933434, 106.925138 ))
                .add(new LatLng( -6.940883, 106.923176 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947671, 106.915940 ))
                .add(new LatLng( -6.952573, 106.911939 ))
                .add(new LatLng( -6.955951, 106.909120 ))
                .add(new LatLng( -6.959357, 106.909020 ))
                .add(new LatLng( -6.959542, 106.910805 ))
                .add(new LatLng( -6.961081, 106.914109 ))
                .add(new LatLng( -6.962308, 106.914573 ))
                .add(new LatLng( -6.964115, 106.918207 ))
                ;
        PolylineOptions  angkot16 = new PolylineOptions ()
                .add(new LatLng( -6.975894, 106.913141 ))
                .add(new LatLng( -6.975866, 106.911123 ))
                .add(new LatLng( -6.975790, 106.906812 ))
                .add(new LatLng( -6.974749, 106.904761 ))
                .add(new LatLng( -6.969752, 106.904077 ))
                .add(new LatLng( -6.967127, 106.905975 ))
                .add(new LatLng( -6.963826, 106.907453 ))
                .add(new LatLng( -6.959357, 106.909020 ))
                .add(new LatLng( -6.955951, 106.909120 ))
                .add(new LatLng( -6.952573, 106.911939 ))
                .add(new LatLng( -6.947671, 106.915940 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.938743, 106.923734 ))
                .add(new LatLng( -6.930288, 106.925855 ))
                .add(new LatLng( -6.928879, 106.926249 ))
                .add(new LatLng( -6.929031, 106.927389 ))
                .add(new LatLng( -6.926869, 106.928456 ))
                .add(new LatLng( -6.927489, 106.930941 ))
                .add(new LatLng( -6.927472, 106.933305 ))
                .add(new LatLng( -6.926267, 106.933506 ))
                .add(new LatLng( -6.925705, 106.930687 ))
                .add(new LatLng( -6.924918, 106.927277 ))
                .add(new LatLng( -6.927089, 106.926725 ))
                .add(new LatLng( -6.928861, 106.926200 ))
                .add(new LatLng( -6.930267, 106.925862 ))
                .add(new LatLng( -6.933434, 106.925138 ))
                .add(new LatLng( -6.940883, 106.923176 ))
                .add(new LatLng( -6.943133, 106.920431 ))
                .add(new LatLng( -6.947277, 106.916152 ))
                .add(new LatLng( -6.946363, 106.915070 ))
                .add(new LatLng( -6.947671, 106.915940 ))
                .add(new LatLng( -6.952573, 106.911939 ))
                .add(new LatLng( -6.955951, 106.909120 ))
                .add(new LatLng( -6.959357, 106.909020 ))
                .add(new LatLng( -6.963826, 106.907453 ))
                .add(new LatLng( -6.967127, 106.905975 ))
                .add(new LatLng( -6.969752, 106.904077 ))
                .add(new LatLng( -6.974749, 106.904761 ))
                .add(new LatLng( -6.975790, 106.906812 ))
                .add(new LatLng( -6.975866, 106.911123 ))
                .add(new LatLng( -6.975894, 106.913141 ))
                ;
        PolylineOptions  angkot17 = new PolylineOptions ()
                .add(new LatLng( -6.968414, 106.948370 ))
                .add(new LatLng( -6.966697, 106.942436 ))
                .add(new LatLng( -6.964790, 106.939450 ))
                .add(new LatLng( -6.961800, 106.934710 ))
                .add(new LatLng( -6.953073, 106.933829 ))
                .add(new LatLng( -6.950354, 106.933681 ))
                .add(new LatLng( -6.950854, 106.931198 ))
                .add(new LatLng( -6.949976, 106.934008 ))
                .add(new LatLng( -6.946657, 106.934694 ))
                .add(new LatLng( -6.941798, 106.931226 ))
                .add(new LatLng( -6.934350, 106.931840 ))
                .add(new LatLng( -6.931435, 106.932417 ))
                .add(new LatLng( -6.926258, 106.933466 ))
                .add(new LatLng( -6.925167, 106.928114 ))
                .add(new LatLng( -6.926258, 106.933466 ))
                .add(new LatLng( -6.931435, 106.932417 ))
                .add(new LatLng( -6.934350, 106.931840 ))
                .add(new LatLng( -6.941798, 106.931226 ))
                .add(new LatLng( -6.946657, 106.934694 ))
                .add(new LatLng( -6.949720, 106.934318 ))
                .add(new LatLng( -6.949316, 106.936305 ))
                .add(new LatLng( -6.948195, 106.938691 ))
                .add(new LatLng( -6.949366, 106.936355 ))
                .add(new LatLng( -6.950354, 106.933681 ))
                .add(new LatLng( -6.953073, 106.933829 ))
                .add(new LatLng( -6.961800, 106.934710 ))
                .add(new LatLng( -6.964790, 106.939450 ))
                .add(new LatLng( -6.966697, 106.942436 ))
                .add(new LatLng( -6.968414, 106.948370 ))
                ;
        PolylineOptions  angkot18 = new PolylineOptions ()
                .add(new LatLng( -6.943388, 106.951830 ))
                .add(new LatLng( -6.950736, 106.948753 ))
                .add(new LatLng( -6.955722, 106.948895 ))
                .add(new LatLng( -6.957935, 106.948667 ))
                .add(new LatLng( -6.960169, 106.943231 ))
                .add(new LatLng( -6.960856, 106.940501 ))
                .add(new LatLng( -6.964811, 106.939453 ))
                .add(new LatLng( -6.961800, 106.934710 ))
                .add(new LatLng( -6.953073, 106.933829 ))
                .add(new LatLng( -6.950354, 106.933681 ))
                .add(new LatLng( -6.949366, 106.936355 ))
                .add(new LatLng( -6.948195, 106.938691 ))
                .add(new LatLng( -6.949316, 106.936305 ))
                .add(new LatLng( -6.949720, 106.934318 ))
                .add(new LatLng( -6.946657, 106.934694 ))
                .add(new LatLng( -6.941798, 106.931226 ))
                .add(new LatLng( -6.934350, 106.931840 ))
                .add(new LatLng( -6.931435, 106.932417 ))
                .add(new LatLng( -6.926258, 106.933466 ))
                .add(new LatLng( -6.925167, 106.928114 ))
                .add(new LatLng( -6.926258, 106.933466 ))
                .add(new LatLng( -6.924912, 106.927277 ))
                .add(new LatLng( -6.930271, 106.925875 ))
                .add(new LatLng( -6.931448, 106.932416 ))
                .add(new LatLng( -6.934350, 106.931840 ))
                .add(new LatLng( -6.941798, 106.931226 ))
                .add(new LatLng( -6.946657, 106.934694 ))
                .add(new LatLng( -6.949720, 106.934318 ))
                .add(new LatLng( -6.949316, 106.936305 ))
                .add(new LatLng( -6.948195, 106.938691 ))
                .add(new LatLng( -6.949366, 106.936355 ))
                .add(new LatLng( -6.950354, 106.933681 ))
                .add(new LatLng( -6.953073, 106.933829 ))
                .add(new LatLng( -6.961800, 106.934710 ))
                .add(new LatLng( -6.964790, 106.939450 ))
                .add(new LatLng( -6.960856, 106.940501 ))
                .add(new LatLng( -6.960169, 106.943231 ))
                .add(new LatLng( -6.957935, 106.948667 ))
                .add(new LatLng( -6.955722, 106.948895 ))
                .add(new LatLng( -6.950736, 106.948753 ))
                .add(new LatLng( -6.943388, 106.951830 ))
                ;
        PolylineOptions  angkot19 = new PolylineOptions ()
                .add(new LatLng( -6.924811, 106.929692 ))
                .add(new LatLng( -6.922582, 106.930980 ))
                .add(new LatLng( -6.920684, 106.931335 ))
                .add(new LatLng( -6.920725, 106.934312 ))
                .add(new LatLng( -6.922915, 106.934029 ))
                .add(new LatLng( -6.926199, 106.933526 ))
                .add(new LatLng( -6.931352, 106.932420 ))
                .add(new LatLng( -6.932711, 106.934998 ))
                .add(new LatLng( -6.935086, 106.934744 ))
                .add(new LatLng( -6.937754, 106.933804 ))
                .add(new LatLng( -6.938255, 106.936209 ))
                .add(new LatLng( -6.938228, 106.937301 ))
                .add(new LatLng( -6.936205, 106.937594 ))
                .add(new LatLng( -6.935086, 106.934744 ))
                .add(new LatLng( -6.932711, 106.934998 ))
                .add(new LatLng( -6.931352, 106.932420 ))
                .add(new LatLng( -6.926199, 106.933526 ))
                .add(new LatLng( -6.922915, 106.934029 ))
                .add(new LatLng( -6.920725, 106.934312 ))
                .add(new LatLng( -6.920684, 106.931335 ))
                .add(new LatLng( -6.922582, 106.930980 ))
                .add(new LatLng( -6.924811, 106.929692 ))
                ;
        PolylineOptions  angkot20 = new PolylineOptions ()
                .add(new LatLng( -6.943417, 106.951840 ))
                .add(new LatLng( -6.950711, 106.948878 ))
                .add(new LatLng( -6.951306, 106.946978 ))
                .add(new LatLng( -6.949258, 106.944524 ))
                .add(new LatLng( -6.947412, 106.941922 ))
                .add(new LatLng( -6.946074, 106.942356 ))
                .add(new LatLng( -6.945643, 106.941692 ))
                .add(new LatLng( -6.945401, 106.940146 ))
                .add(new LatLng( -6.944093, 106.939706 ))
                .add(new LatLng( -6.939585, 106.941360 ))
                .add(new LatLng( -6.937059, 106.940647 ))
                .add(new LatLng( -6.936157, 106.937632 ))
                .add(new LatLng( -6.935065, 106.934747 ))
                .add(new LatLng( -6.932634, 106.935020 ))
                .add(new LatLng( -6.931459, 106.932434 ))
                .add(new LatLng( -6.926223, 106.933508 ))
                .add(new LatLng( -6.922929, 106.934050 ))
                .add(new LatLng( -6.920730, 106.934295 ))
                .add(new LatLng( -6.920804, 106.931322 ))
                .add(new LatLng( -6.922620, 106.930970 ))
                .add(new LatLng( -6.924900, 106.930238 ))
                .add(new LatLng( -6.924290, 106.927422 ))
                .add(new LatLng( -6.930266, 106.925885 ))
                .add(new LatLng( -6.931935, 106.928846 ))
                .add(new LatLng( -6.931352, 106.932420 ))
                .add(new LatLng( -6.932711, 106.934998 ))
                .add(new LatLng( -6.935086, 106.934744 ))
                .add(new LatLng( -6.936205, 106.937594 ))
                .add(new LatLng( -6.938228, 106.937301 ))
                .add(new LatLng( -6.938255, 106.936209 ))
                .add(new LatLng( -6.937754, 106.933804 ))
                .add(new LatLng( -6.935086, 106.934744 ))
                .add(new LatLng( -6.932711, 106.934998 ))
                .add(new LatLng( -6.931352, 106.932420 ))
                .add(new LatLng( -6.926199, 106.933526 ))
                .add(new LatLng( -6.922915, 106.934029 ))
                .add(new LatLng( -6.920725, 106.934312 ))
                .add(new LatLng( -6.920684, 106.931335 ))
                .add(new LatLng( -6.922582, 106.930980 ))
                .add(new LatLng( -6.924811, 106.929692 ))
                ;

        PolylineOptions  angkot21 = new PolylineOptions ()
                .add(new LatLng(-6.975631, 106.913136))
                .add(new LatLng(-6.973163, 106.914259))
                .add(new LatLng(-6.970110, 106.918651))
                .add(new LatLng(-6.970917, 106.921715))
                .add(new LatLng(-6.965952, 106.924996))
                .add(new LatLng(-6.965698, 106.930486))
                .add(new LatLng(-6.961889, 106.934696))
                .add(new LatLng(-6.953073, 106.933829))
                .add(new LatLng(-6.950354, 106.933681))
                .add(new LatLng(-6.950854, 106.931198))
                .add(new LatLng(-6.949976, 106.934008))
                .add(new LatLng(-6.946657, 106.934694))
                .add(new LatLng(-6.941798, 106.931226))
                .add(new LatLng(-6.934350, 106.931840))
                .add(new LatLng(-6.931435, 106.932417))
                .add(new LatLng(-6.926258, 106.933466))
                .add(new LatLng(-6.922929, 106.934050))
                .add(new LatLng(-6.920730, 106.934295))
                .add(new LatLng(-6.920804, 106.931322))
                .add(new LatLng(-6.922620, 106.930970))
                .add(new LatLng(-6.924900, 106.930238))
                .add(new LatLng(-6.924290, 106.927422))
                .add(new LatLng(-6.930266, 106.925885))
                .add(new LatLng(-6.931935, 106.928846))
                .add(new LatLng(-6.931352, 106.932420))
                .add(new LatLng(-6.934350, 106.931840))
                .add(new LatLng(-6.941798, 106.931226))
                .add(new LatLng(-6.946657, 106.934694))
                .add(new LatLng(-6.949976, 106.934008))
                .add(new LatLng(-6.950854, 106.931198))
                .add(new LatLng(-6.950354, 106.933681))
                .add(new LatLng(-6.953073, 106.933829))
                .add(new LatLng(-6.961889, 106.934696))
                .add(new LatLng(-6.965698, 106.930486))
                .add(new LatLng(-6.965952, 106.924996))
                .add(new LatLng(-6.970917, 106.921715))
                .add(new LatLng(-6.970110, 106.918651))
                .add(new LatLng(-6.973163, 106.914259))
                .add(new LatLng(-6.975631, 106.913136));

        es.add(angkot1);
        es.add(angkot2);
        es.add(angkot3);
        es.add(angkot4);
        es.add(angkot5);
        es.add(angkot6);
        es.add(angkot7);
        es.add(angkot8);
        es.add(angkot9);
        es.add(angkot10);
        es.add(angkot11);
        es.add(angkot12);
        es.add(angkot13);
        es.add(angkot14);
        es.add(angkot15);
        es.add(angkot16);
        es.add(angkot17);
        es.add(angkot18);
        es.add(angkot19);
        es.add(angkot20);
        es.add(angkot21);

        Polyline polygon =  mMap.addPolyline(es.get(kodeangkot));
        polygon.setColor(Color.BLUE);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(es.get(kodeangkot).getPoints().get(0),15));
    }
}