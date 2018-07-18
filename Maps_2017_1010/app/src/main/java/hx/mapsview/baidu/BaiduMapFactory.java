package hx.mapsview.baidu;

import android.content.Context;

import hx.mapsview.base.BaseMapFactory;
import hx.mapsview.framework.IMapView;

/**
 * Created by Lenovo on 2017/11/20.
 */

public class BaiduMapFactory extends BaseMapFactory {
    private IMapView mapView;
    public BaiduMapFactory(Context context){
        super(context);
    }
    public IMapView getMapView(){
        if(null==mapView)
        {
            mapView=new BaiduMapView(getContext());
        }
        return mapView;
    }
}
