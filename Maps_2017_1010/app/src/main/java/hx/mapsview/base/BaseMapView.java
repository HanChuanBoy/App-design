package hx.mapsview.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import hx.mapsview.framework.IMapView;

/**
 * Created by Lenovo on 2017/11/5.
 */

public abstract class BaseMapView implements IMapView {

    private Context context;
    public  BaseMapView(Context context){
       this.context=context;
    }

    public  Context getContext(){
        return this.context;
    }
    public  void onCreate(Bundle savedInstanceState){

    }
    public void onResume(){

    }
    public void onPause(){

    }
    public void onDestroy(){

    }
    public void onSaveInstanceState(Bundle OutState){

    }
}
