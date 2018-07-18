package hx.mapsview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;


import com.amap.api.maps2d.MapView;

import hx.mapsview.baidu.BaiduMapFactory;
import hx.mapsview.baidu.BaiduMapView;
import hx.mapsview.base.IMapFactory;
import hx.mapsview.framework.IMapView;
import hx.mapsview.gaode.GaodeMapFactory;
import hx.mapsview.gaode.GaodeMapView;

public class MainActivity extends AppCompatActivity {
    private IMapView mMapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
       /* mMapView=new BaiduMapView(this);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        frameLayout.addView(mMapView.getView());*/
       //测试高德地图;
       //   mMapView=(MapView)findViewById(R.id.bmapView);
       // mMapView.onCreate(savedInstanceState);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        IMapFactory factory=new GaodeMapFactory(this);
        mMapView = factory.getMapView();
        frameLayout.addView(mMapView.getView());
        mMapView.onCreate(savedInstanceState);
    }
    @Override
    protected void onPause() {
        super.onPause();
        // activity 暂停时同时暂停地图控件
        mMapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // activity 恢复时同时恢复地图控件
       mMapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // activity 销毁时同时销毁地图控件
      //  MapView.setMapCustomEnable(false);
       mMapView.onDestroy();
    }
}
