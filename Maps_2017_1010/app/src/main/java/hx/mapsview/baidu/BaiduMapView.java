package hx.mapsview.baidu;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.baidu.mapapi.map.MapView;

import hx.mapsview.base.BaseMapView;

/**
 * Created by Lenovo on 2017/11/5.
 */
public class BaiduMapView extends BaseMapView {
    private MapView mapView;
    public BaiduMapView(Context context){
        super(context);
    }
    public Context getContext(){
        return super.getContext();
    }
    private  MapView getMapView(){
        if(mapView==null){
            this.mapView=new MapView(getContext());
        }
        return this.mapView;
    }
    @Override
    public View getView() {
        return getMapView();
    }

    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    public void onResume(){
       getMapView().onResume();
    }
    public void onPause(){
        getMapView().onPause();
    }
    public void onDestroy(){
        getMapView().onDestroy();
    }
}
