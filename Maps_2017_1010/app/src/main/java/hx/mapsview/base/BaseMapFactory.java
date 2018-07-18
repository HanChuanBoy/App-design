package hx.mapsview.base;

import android.content.Context;

import hx.mapsview.framework.IMapView;

/**
 * Created by Lenovo on 2017/11/20.
 */

public  abstract class BaseMapFactory implements IMapFactory {
        private Context context;
        public BaseMapFactory(Context context){this.context=context;}
        public Context getContext(){return this.context;}
}
