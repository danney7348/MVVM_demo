package com.bwie.test1102;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * 作者： 张少丹
 * 时间：  2017/11/2.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class Product {
    public String title;
    public String icon="https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg";

    @BindingAdapter("icon")
    public static void display(ImageView iv, String icon) {
        Glide.with(iv.getContext()).load(icon).into(iv);
    }
    public void click(View view){
        Toast.makeText(view.getContext(), "我被点击了", Toast.LENGTH_SHORT).show();
    }
}
