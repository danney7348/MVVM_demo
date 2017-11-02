package com.bwie.test1102;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 作者： 张少丹
 * 时间：  2017/11/2.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public interface InterfaceApi {
    @POST("user/login")
    @FormUrlEncoded
    Call<BaseResponse<User>> postData(@FieldMap Map<String,String> map);

    @GET("product/getProducts")
    Call<BaseResponse<List<Product>>> getProduct(@Query("pscid") int pscid);
}
