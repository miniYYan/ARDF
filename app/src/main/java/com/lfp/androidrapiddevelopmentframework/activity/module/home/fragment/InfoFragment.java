package com.lfp.androidrapiddevelopmentframework.activity.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lfp.androidrapiddevelopmentframework.R;
import com.lfp.androidrapiddevelopmentframework.base.BaseFragment;
import com.lfp.ardf.util.AssetsUtil;
import com.lfp.ardf.util.StatusBarUtil;

/**
 * 展示信息<br/>
 * Created by LiFuPing on 2018/6/4.
 */
public class InfoFragment extends BaseFragment {

    public static final Fragment newInstance() {
        InfoFragment fragment = new InfoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_info, null);
    }

    TextView mTV_Info;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StatusBarUtil.fitLayoutAtFullScreen(view.findViewById(R.id.layout_Actionabr), true);
        mTV_Info = view.findViewById(R.id.view_Info);

        mTV_Info.setText(AssetsUtil.getString("README.txt"));
    }
}
