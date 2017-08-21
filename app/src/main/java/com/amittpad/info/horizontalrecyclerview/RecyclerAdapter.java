package com.amittpad.info.horizontalrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 29-07-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    List<RecyclerPojo> recyclerPojos;
    Context context;

    public RecyclerAdapter(List<RecyclerPojo> itemList, Context context) {
        this.recyclerPojos = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RecyclerPojo recyclerPojo = recyclerPojos.get(position);
        holder.textView.setText(recyclerPojo.getText());
        holder.imageView.setImageResource(recyclerPojo.getIcon());
    }

    @Override
    public int getItemCount() {
        return recyclerPojos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        LinearLayout view;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.top_rcv_child_text);
            imageView = (ImageView) itemView.findViewById(R.id.top_rcv_child_icon);
            view = (LinearLayout) itemView;
        }
    }
}
