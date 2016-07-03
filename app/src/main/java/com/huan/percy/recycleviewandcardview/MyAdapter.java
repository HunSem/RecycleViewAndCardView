package com.huan.percy.recycleviewandcardview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Percy on 2016/7/3.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private LinkedList<Map<String, Object>> list;

    /**
     * 这里和使用listview时使用的adapter基本一样，都是要传入数据集合的
     *
     * @param list
     */
    public MyAdapter(LinkedList<Map<String, Object>> list) {
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.list_item, null);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.title_tv.setText(list.get(i).get("title").toString());
        viewHolder.content_tv.setText(list.get(i).get("content").toString());
        Log.d("content", "before bind:" +list.get(i).get("title").toString());
        Log.d("content", "after bind:" + viewHolder.title_tv.getText().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title_tv;
        public TextView content_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            title_tv = (TextView) itemView.findViewById(R.id.item_title_tv);
            content_tv = (TextView) itemView.findViewById(R.id.item_content_tv);
        }
    }

    public void add(Map<String, Object> item, int position) {
        list.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Map<String, Object> item) {
        int position = list.indexOf(item);
        list.remove(position);
        notifyItemRemoved(position);
    }

}
