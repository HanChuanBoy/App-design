package hx.startaidl.hx.aidl.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.io.IOException;

import hx.aidl.IAddition;
import hx.startaidl.R;
import hx.startaidl.hx.aidl.utils.MediaExtractorManager;


public class MainActivity extends AppCompatActivity {
    IAddition mService;
    private static final String SDCARD_PATH =Environment.getExternalStorageDirectory().getPath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("hx.aidl", "hx.aidl.AdditionService"));
        Log.v("%s", "aa");

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.v("%s", "bb"+name+service);
                mService = IAddition.Stub.asInterface(service);
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.v("%s", "cc");
            }
        }, Context.BIND_AUTO_CREATE);
    }
    public void add(View view) throws RemoteException {
        EditText et1 = (EditText) findViewById(R.id.et_num1);
        EditText et2 = (EditText) findViewById(R.id.et_num2);

        TextView tv = (TextView) findViewById(R.id.tv);

        int x = Integer.parseInt(et1.getText().toString());
        int y = Integer.parseInt(et2.getText().toString());
        int result = mService.add(x, y);
        tv.setText(result + "");
        MediaExtractorManager mediaExtractorManager = MediaExtractorManager.getInstance();
        StringBuilder folder = new StringBuilder(SDCARD_PATH);
        Log.v("add SDCARDPATH %s",SDCARD_PATH);
        mediaExtractorManager.exactorMediaFile(folder,new StringBuilder("video.mp4"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
