package com.DeveloperSunghyun.bluetoothcontroller.Controller.Remote;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.DeveloperSunghyun.bluetoothcontroller.R;
import com.DeveloperSunghyun.bluetoothcontroller.DP_Conversion;

import java.util.ArrayList;

public class RemoteKeyPad extends AppCompatActivity {

    GridView GridView_button;
    GridViewAdapter gridViewAdapter;
    ArrayList<ViewItem> viewItems;


    void id_mapping(){
        GridView_button = findViewById(R.id.GridView_button);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote_keypad);

        id_mapping();

        viewItems = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            viewItems.add(new ViewItem("번호" + (i + 1), 1, 0));
        }

        gridViewAdapter = new GridViewAdapter(viewItems);

        GridView_button.setAdapter(gridViewAdapter);


    }

}

class GridViewAdapter extends BaseAdapter {
    ArrayList<ViewItem> viewItems;
    public GridViewAdapter(ArrayList<ViewItem> viewItems){
        this.viewItems = viewItems;
    }

    @Override
    public int getCount() {
        return viewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.remote_keypad_item, parent, false);

        Button button = view.findViewById(R.id.Button_Item);

        DP_Conversion dpConversion = new DP_Conversion(context);

        button.setText(viewItems.get(position).getString());
        button.setTextSize(dpConversion.Conversion(7));

        return view;
    }
}

class ViewItem{
    String string;
    int value_on, value_off;

    public ViewItem(String string, int value_on, int value_off){
        this.string = string;
        this.value_on = value_on;
        this.value_off = value_off;
    }
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getValue_on() {
        return value_on;
    }

    public void setValue_on(int value_on) {
        this.value_on = value_on;
    }

    public int getValue_off() {
        return value_off;
    }

    public void setValue_off(int value_off) {
        this.value_off = value_off;
    }
}