package com.bwie.test1102;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.zip.Inflater;

/**
 * 作者： 张少丹
 * 时间：  2017/11/2.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class MyBaseAda<T> extends BaseAdapter {
    private Context context;
    private List<T> list;
    private LayoutInflater inflater;
    private int layoutId;
    private int variableId;

    public MyBaseAda(Context context, List<T> list, int layoutId, int variableId) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewDataBinding dataBinding;
        if(view == null){
            dataBinding = DataBindingUtil.inflate(inflater,layoutId,viewGroup,false);
        }else {
            dataBinding = DataBindingUtil.getBinding(view);
        }
        dataBinding.setVariable(variableId,list.get(i));
        return dataBinding.getRoot();
    }
}
