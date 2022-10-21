package com.milonsheikh.databindingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.milonsheikh.databindingrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding myBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myBinding.recyclerView.setLayoutManager(linearLayoutManager);

        populateData();
    }

    private void populateData() {
        List<DataModel> dataModelList = new ArrayList<>();

        dataModelList.add(new DataModel("Android Oreo", "8.1"));
        dataModelList.add(new DataModel("Android Pie", "9.0"));
        dataModelList.add(new DataModel("Android Nougat", "7.0"));
        dataModelList.add(new DataModel("Android Marshmallow", "6.0"));

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataModelList, this);
        myBinding.setMyAdapter(myRecyclerViewAdapter);
    }

}