package com.animusdevs.recyclerviewexample2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.animusdevs.recyclerviewexample.R;

public class ListItemViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView tvItemName;
    TextView tvItemDescription;
    Button btnViewItem;
    private ListItemAdapterClickListener mListener;


    public ListItemViewHolder2(View itemView, ListItemAdapterClickListener listener) {
        super(itemView);
        this.mListener=listener;
        tvItemName=itemView.findViewById(R.id.tv_item);
        tvItemDescription=itemView.findViewById(R.id.tv_item_description);
        btnViewItem=itemView.findViewById(R.id.btn_item_click);

        //On Item body click
        itemView.setOnClickListener(this);
        //On Button Click
        btnViewItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(mListener!=null){
            mListener.onListItemClick(v,getAdapterPosition());
        }
    }
}
