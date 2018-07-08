package com.animusdevs.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListItemViewHolder extends RecyclerView.ViewHolder {
    TextView tvItemName;
    TextView tvItemDescription;
    Button btnViewItem;

    public ListItemViewHolder(View itemView) {
        super(itemView);
        tvItemName=itemView.findViewById(R.id.tv_item);
        tvItemDescription=itemView.findViewById(R.id.tv_item_description);
        btnViewItem=itemView.findViewById(R.id.btn_item_click);

    }
}
