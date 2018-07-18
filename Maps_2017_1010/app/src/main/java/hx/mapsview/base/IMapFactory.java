package hx.mapsview.base;

import hx.mapsview.framework.IMapView;

/**
 * Created by Lenovo on 2017/11/20.
 */

//抽象工厂接口
public interface IMapFactory {
    //一条流水线;
    IMapView getMapView();
}
