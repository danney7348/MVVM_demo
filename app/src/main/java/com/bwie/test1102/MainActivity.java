package com.bwie.test1102;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ViewDataBinding binding;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initData();
        lv = findViewById(R.id.lv);
        initProducts();
    }

    private void initProducts() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.zhaoapi.cn/")
                .build();
        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
        Call<BaseResponse<List<Product>>> product = interfaceApi.getProduct(1);
        product.enqueue(new Callback<BaseResponse<List<Product>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Product>>> call, Response<BaseResponse<List<Product>>> response) {

                MyBaseAda adapter = new MyBaseAda(MainActivity.this,response.body().data,R.layout.lv_item,BR.product);
                lv.setAdapter(adapter);
                lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "我是条目:"+i, Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Product>>> call, Throwable t) {

            }
        });
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://120.27.23.105/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfaceApi interfaceApi = retrofit.create(InterfaceApi.class);
        Map<String,String> p = new HashMap<>();
        p.put("mobile","15297526557");
        p.put("password","123456");
        Call<BaseResponse<User>> baseResponseCall = interfaceApi.postData(p);
        baseResponseCall.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(Call<BaseResponse<User>> call, Response<BaseResponse<User>> response) {
                binding.setVariable(BR.user,response.body().data);
            }
            @Override
            public void onFailure(Call<BaseResponse<User>> call, Throwable t) {

            }
        });
    }

}
