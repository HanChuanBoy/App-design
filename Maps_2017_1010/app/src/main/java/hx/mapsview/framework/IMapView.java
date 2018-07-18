package hx.mapsview.framework;

import android.os.Bundle;
import android.view.View;

/**
 * Created by Lenovo on 2017/11/5.
 */
//角色1:找到相同点;
public interface IMapView {
    View getView();
    void onCreate(Bundle savedInstanceState);
    void onResume();
    void onPause();
    void onDestroy();
    void onSaveInstanceState(Bundle OutState);
}
