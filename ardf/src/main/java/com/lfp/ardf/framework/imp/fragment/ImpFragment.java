package com.lfp.ardf.framework.imp.fragment;


import com.lfp.ardf.framework.I.IAppFramework;

/**
 * 框架接入
 * Created by LiFuPing on 2018/5/11.
 */
public class ImpFragment extends Imp3NetRequestFragment implements IAppFramework {
    @Override
    public IAppFramework getAppFk() {
        return this;
    }
}
