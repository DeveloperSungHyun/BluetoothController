package com.DeveloperSunghyun.bluetoothcontroller.FragmentView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.DeveloperSunghyun.bluetoothcontroller.Controller.Remote.RemoteButton;
import com.DeveloperSunghyun.bluetoothcontroller.Controller.Remote.RemoteKeyPad;
import com.DeveloperSunghyun.bluetoothcontroller.R;
import com.DeveloperSunghyun.bluetoothcontroller.RecyclerView.ItemData;
import com.DeveloperSunghyun.bluetoothcontroller.RecyclerView.RecyclerViewManager;


import java.util.ArrayList;

public class Controller_FragmentView extends Fragment {

    View Button_test;

    Intent intent;

    RecyclerViewManager recyclerViewManager;
    RecyclerView RecyclerView_Remote;
    ArrayList<ItemData> Remote_List;

    ItemData itemData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.controller_fragment_view, container, false);

        Button_test = view.findViewById(R.id.Button_test);
        RecyclerView_Remote = view.findViewById(R.id.RecyclerView_Remote);

        Remote_List = new ArrayList<>();

        itemData = new ItemData(new Intent(getContext(), RemoteButton.class), R.drawable.remote_button);
        Remote_List.add(itemData);

        recyclerViewManager = new RecyclerViewManager(getContext(), RecyclerView_Remote,1,  Remote_List);

        Button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RemoteKeyPad.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
