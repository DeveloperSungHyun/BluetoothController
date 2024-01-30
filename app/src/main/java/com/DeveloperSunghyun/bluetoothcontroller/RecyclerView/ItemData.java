package com.DeveloperSunghyun.bluetoothcontroller.RecyclerView;

import android.content.Intent;

public class ItemData {
    public Intent intent;
    public int image;

    public ItemData(Intent intent, int image){
        this.intent = intent;
        this.image = image;
    }

}
