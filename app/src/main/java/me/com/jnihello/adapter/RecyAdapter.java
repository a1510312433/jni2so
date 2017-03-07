package me.com.jnihello.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.com.jnihello.R;
import me.com.jnihello.bean.RecyBean;

/**
 * Created by caobin on 2017/3/7.
 */

public class RecyAdapter extends RecyclerView.Adapter{
    List<RecyBean> list;

    public RecyAdapter(List<RecyBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyitem,parent,false);
        recyViewHolder viewHolder = new recyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        recyViewHolder recyViewHolder = (RecyAdapter.recyViewHolder) holder;
        recyViewHolder.itemtext.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }
    static class recyViewHolder extends RecyclerView.ViewHolder{
        TextView itemtext;
        public recyViewHolder(View itemView) {
            super(itemView);
            itemtext = ((TextView) itemView.findViewById(R.id.itemtext));
        }
    }
}
