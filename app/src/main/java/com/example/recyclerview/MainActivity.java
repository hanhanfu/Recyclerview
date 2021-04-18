package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.recyclerview.adapters.ListViewAdapters;
import com.example.recyclerview.beans.Datas;
import com.example.recyclerview.beans.ItemBean;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;
    private List<ItemBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (RecyclerView) this.findViewById(R.id.recycler_view);

        initData();
    }

    private void initData() {
        mData = new ArrayList<>();
        for(int i = 0; i< Datas.icons.length; i++){
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title ="我是重庆邮电大学第" + i + "张照片";
            mData.add(data);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        ListViewAdapters adapter = new ListViewAdapters(mData);
        list.setAdapter(adapter);
    }



}