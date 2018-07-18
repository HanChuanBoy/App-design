package hx.mapsview.gaode;

import android.content.Context;

import hx.mapsview.baidu.BaiduMapView;
import hx.mapsview.base.BaseMapFactory;
import hx.mapsview.framework.IMapView;

/**
 * Created by Lenovo on 2017/11/20.
 */

public class GaodeMapFactory extends BaseMapFactory {
    private IMapView mapView;
    public GaodeMapFactory(Context context){
        super(context);
    }
    public IMapView getMapView(){
        if(null==mapView)
        {
            mapView=new GaodeMapView(getContext());
        }
        return mapView;
    }
}
