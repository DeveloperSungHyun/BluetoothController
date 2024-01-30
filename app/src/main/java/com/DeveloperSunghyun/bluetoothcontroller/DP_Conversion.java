package com.DeveloperSunghyun.bluetoothcontroller;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class DP_Conversion {
    int dpi;
    float density;
    public DP_Conversion(Context context){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);

        dpi = displayMetrics.densityDpi;
        density = displayMetrics.density; // density에는 dip/160 값이 들어 있음.
    }
    public float Conversion(int dp){
        return dp * density + 0.5f;
    }
}
