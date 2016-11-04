package com.multi_channel_study.demo;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.multi_channel_study.demo.R.id.tv_channel;

public class MainActivity extends AppCompatActivity {

    private TextView mChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChannel = (TextView) findViewById(tv_channel);
        mChannel.setText(getApplicationMetaValue("UMENG_CHANNEL"));
    }

    private String  getApplicationMetaValue(String name) {
        String value= "";
        try {
            ApplicationInfo appInfo =getPackageManager()
                    .getApplicationInfo(getPackageName(),
                            PackageManager.GET_META_DATA);
            value = appInfo.metaData.getString(name);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}
