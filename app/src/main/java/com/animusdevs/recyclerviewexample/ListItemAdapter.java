package com.animusdevs.recyclerviewexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemViewHolder> {
    private List<ListItemClass>  mItemArrayList;
    private ListItemClickListener mListener;

    interface ListItemClickListener{
        void onViewItemClick(ListItemClass listItemClass);
        void onItemClick(ListItemClass listItemClass);
    }

    public ListItemAdapter(List<ListItemClass> mItemArrayList, ListItemClickListener mListener) {
        this.mItemArrayList = mItemArrayList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout,parent,false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListItemViewHolder holder, int position) {
        holder.tvItemName.setText(mItemArrayList.get(holder.getAdapterPosition()).getItemName());
        holder.tvItemDescription.setText(mItemArrayList.get(holder.getAdapterPosition()).getItemDescription());

        //We can set on click listener for the button here (there are also other ways to do this!)
        holder.btnViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call the interface method here
                mListener.onViewItemClick(mItemArrayList.get(holder.getAdapterPosition()));
            }
        });

        //Let's also implement another click listener for the body
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(mItemArrayList.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemArrayList!=null?mItemArrayList.size():0;
    }
}
