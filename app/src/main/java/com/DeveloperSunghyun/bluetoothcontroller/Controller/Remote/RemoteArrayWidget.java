package com.DeveloperSunghyun.bluetoothcontroller.Controller.Remote;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.DeveloperSunghyun.bluetoothcontroller.R;

import java.util.ArrayList;

public class RemoteArrayWidget extends AppCompatActivity {

    RecyclerView RecyclerView_ItemListView;
    ArrayList<RecyclerViewItem> recyclerViewItems;
    private void id_mapping(){
        RecyclerView_ItemListView = findViewById(R.id.RecyclerView_ItemListView);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote_arraywidget);

        id_mapping();
        RecyclerView_ItemListView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        recyclerViewItems = new ArrayList<>();
        RecyclerViewItem recyclerViewItem = new RecyclerViewItem("텍스트1", 0);

        recyclerViewItems.add(recyclerViewItem);



        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), recyclerViewItems);

        RecyclerView_ItemListView.setAdapter(recyclerViewAdapter);
    }

}

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Context context;
    ArrayList<RecyclerViewItem> recyclerViewItems;

    public RecyclerViewAdapter(Context context, ArrayList<RecyclerViewItem> recyclerViewItems){
        this.context = context;
        this.recyclerViewItems = recyclerViewItems;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.remote_arraywidget_item, parent, false);
        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.TextView_Title.setText(recyclerViewItems.get(position).getTitle());

        switch (recyclerViewItems.get(position).getInput_Type()){
            case 0:{
                holder.Button_InputType1.setVisibility(View.VISIBLE);
                holder.Switch_InputType2.setVisibility(View.GONE);
                holder.SeekBar_InputType3.setVisibility(View.GONE);
                holder.Button_InputType1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "버튼" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            }
            case 1:{
                holder.Button_InputType1.setVisibility(View.GONE);
                holder.Switch_InputType2.setVisibility(View.VISIBLE);
                holder.SeekBar_InputType3.setVisibility(View.GONE);
                holder.Switch_InputType2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Toast.makeText(context, "버튼" + position + isChecked, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            }
            case 3:{
                holder.Button_InputType1.setVisibility(View.GONE);
                holder.Switch_InputType2.setVisibility(View.GONE);
                holder.SeekBar_InputType3.setVisibility(View.VISIBLE);
                holder.SeekBar_InputType3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    int test = 0;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        test = progress;
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(context, "버튼" + position + test, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TextView_Title;
        Button Button_InputType1;
        Switch Switch_InputType2;
        SeekBar SeekBar_InputType3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextView_Title = itemView.findViewById(R.id.TextView_Title);
            Button_InputType1 = itemView.findViewById(R.id.Button_InputType1);
            Switch_InputType2 = itemView.findViewById(R.id.Switch_InputType2);
            SeekBar_InputType3 = itemView.findViewById(R.id.SeekBar_InputType3);
        }
    }
}

class RecyclerViewItem {
    private String Title;//리스트 아이템 명
    private int Input_Type;//제어 타입
    public RecyclerViewItem(String Title, int Input_Type){
        this.Title = Title;
        this.Input_Type = Input_Type;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getInput_Type() {
        return Input_Type;
    }

    public void setInput_Type(int input_Type) {
        Input_Type = input_Type;
    }
}

