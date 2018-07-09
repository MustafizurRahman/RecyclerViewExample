package com.animusdevs.recyclerviewexample2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animusdevs.datamodel.ListItemClass;
import com.animusdevs.recyclerviewexample.ListItemAdapter;
import com.animusdevs.recyclerviewexample.R;

import java.util.List;

public class ListItemAdapter2 extends RecyclerView.Adapter<ListItemViewHolder2> {
    private List<ListItemClass> mItemArrayList;
    private ListItemAdapterClickListener mListener;


    public ListItemAdapter2(List<ListItemClass> mItemArrayList) {
        this.mItemArrayList = mItemArrayList;
    }

    @NonNull
    @Override
    public ListItemViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout,parent,false);
        return new ListItemViewHolder2(view,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder2 holder, int position) {
        holder.tvItemName.setText(mItemArrayList.get(holder.getAdapterPosition()).getItemName());
        holder.tvItemDescription.setText(mItemArrayList.get(holder.getAdapterPosition()).getItemDescription());
    }

    @Override
    public int getItemCount() {
        return mItemArrayList!=null?mItemArrayList.size():0;
    }

    public void addItem(){
        mItemArrayList.add(0,new ListItemClass("Item name "
                +(mItemArrayList.size()+1),"Item description "+(mItemArrayList.size()+1)));
        notifyDataSetChanged();
    }


    public void removeItem(int position){
        mItemArrayList.remove(position);
        notifyItemRemoved(position);
    }

    public void setOnItemClickListener(ListItemAdapterClickListener listener){
        this.mListener=listener;
    }
}
