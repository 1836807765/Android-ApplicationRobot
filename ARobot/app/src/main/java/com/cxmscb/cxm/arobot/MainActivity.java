package com.cxmscb.cxm.arobot;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    PackageManager packageManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packageManager = this.getPackageManager();
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent);
    }

    public void meituan(View view) {
        MyApplication.getInstance().setFlag(true);
        MyApplication.getInstance().setParams("鸡块");
        Intent intent = packageManager.getLaunchIntentForPackage("com.sankuai.meituan");//"jp.co.johospace.jorte"就是我们获得要启动应用的包名
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getInstance().setFlag(false);
    }
}
