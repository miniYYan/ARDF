package com.lfp.androidrapiddevelopmentframework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lfp.androidrapiddevelopmentframework.base.BaseActivity;
import com.lfp.androidrapiddevelopmentframework.demo.ADemo_BaseRecyclerViewAdapter;
import com.lfp.androidrapiddevelopmentframework.demo.DemoEntrance;
import com.lfp.ardf.adapter.BaseRecyclerViewAdapter;
import com.lfp.ardf.adapter.SimpleRecyclerViewAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiFuPing on 2018/5/9.
 */
public class MainActivity extends BaseActivity {

    SimpleRecyclerViewAdapter<DemoEntrance> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.view_ReyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(mAdapter = new SimpleRecyclerViewAdapter(VHolder.class, R.layout.activity_main_listitem));

        /*配置demo*/
        List<DemoEntrance> arrays = new ArrayList<>();
        arrays.add(new ADemo_BaseRecyclerViewAdapter.Demo("RecyclerViewAdapter", getAppFk()));

        mAdapter.setAndUpdata(arrays);

    }


    private static final class VHolder extends BaseRecyclerViewAdapter.BaseViewHolder<DemoEntrance> implements View.OnClickListener {
        TextView mTV_Info;

        public VHolder(View itemView) {
            super(itemView);
            mTV_Info = itemView.findViewById(R.id.view_Info);
            mTV_Info.setOnClickListener(this);
        }

        @Override
        public void onUpdateUI(DemoEntrance data) {
            mTV_Info.setText(data.getInfo());
        }

        @Override
        public void onClick(View v) {
            getSaveData().enter();
        }
    }


    public static final void main(String... arg) {
       String json = "{\"MsgId\":\"306\",\"Code\":101,\"Message\":\"查询数据成功\",\"Value\":[],\"Sign\":\"0d1070cf5920135d31607a3f06014e81\"}";


        Mode model = new Gson().fromJson(json, Mode.class);
        System.err.println(new Gson().toJson(model));
    }

    public static final class Mode {
        String MsgId;
        String Code;
        String Message;
        boolean test;

    }
}