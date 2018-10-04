package com.example.jonathan.runtimeexectest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jonathan.runtimeexectest.utils.ConstUtils;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = ConstUtils.APP_TAG + MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    Log.d(TAG, "onCreate");

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Runtime rt = Runtime.getRuntime();

    Process proc = null;
    String command = null;

    try {
      command = "dpm set-device-owner com.payjoy.status/.AdminReceiver";

      proc = rt.exec(command);
    } catch (IOException e) {
      e.printStackTrace();
    }

    int exitVal = 0;
    try {
      exitVal = proc.waitFor();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Log.v(TAG, "onCreate: command=[" + command + "], exitVal=[" + exitVal + "]");

    Log.v(TAG, "onCreate: end");
  }
}
