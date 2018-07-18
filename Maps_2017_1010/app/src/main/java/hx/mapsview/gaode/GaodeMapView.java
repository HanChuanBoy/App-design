package hx.mapsview.gaode;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.amap.api.maps2d.MapView;

import hx.mapsview.base.BaseMapView;

/**
 * Created by Lenovo on 2017/11/5.
 */
public class GaodeMapView extends BaseMapView {
    private MapView mapView;
    public GaodeMapView(Context context)
    {
        super(context);
    }
    @Override
    public View getView() {
        return getMapView();
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapView().onCreate(savedInstanceState);
    }

    public MapView getMapView() {
        if(mapView==null){
            this.mapView=new MapView(getContext());
        }
        return mapView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getMapView().onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getMapView().onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        getMapView().onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle OutState) {
        super.onSaveInstanceState(OutState);
        getMapView().onSaveInstanceState(OutState);
    }
}
