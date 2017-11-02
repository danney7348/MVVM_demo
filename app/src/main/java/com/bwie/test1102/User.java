package com.bwie.test1102;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 作者： 张少丹
 * 时间：  2017/11/2.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class User extends BaseResponse {
    @BindingAdapter("icon")
    public static void getInternetImage(ImageView iv, String icon) {
        Glide.with(iv.getContext()).load(icon).into(iv);
    }
    public String mobile;
    public String icon;
}
