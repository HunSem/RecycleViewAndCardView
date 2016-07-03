package com.huan.percy.recycleviewandcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinkedList<Map<String, Object>> products=new LinkedList<Map<String, Object>>();
    private String content = "美女说：非著名程序员公众号是东半球最好的技术分享公众号\n" +
            "    美女说：非著名程序员公众号是东半球最好的技术分享公众号\n" +
            "    美女说：非著名程序员公众号是东半球最好的技术分享公众号\n" +
            "    美女说：非著名程序员公众号是东半球最好的技术分享公众号\n" +
            "    美女说：非著名程序员公众号是东半球最好的技术分享公众号\n" +
            "    美女说：非著名程序员公众号是东半球最好的技术分享公众号";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVar();
        initView();
    }

    private void initView() {
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        //设置并列2行的layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        //设置线性布局的layoutManager
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //recyclerView.setLayoutManager(linearLayoutManager);

        //设置adapter
        MyAdapter adapter=new MyAdapter(products);
        recyclerView.setAdapter(adapter);
    }

    //新建一些数据
    private void initVar() {
        for (int i = 0; i<20; i++){
            Map<String, Object> listItem = new HashMap<String, Object>();
            if (i % 2 == 0){
                listItem.put("title", "非著名程序员 "+ i);
                listItem.put("content",  content+ i);
            } else {
                listItem.put("title", "title "+ i);
                listItem.put("content", "content" + i);
            }

            products.add(listItem);
        }
    }
}
