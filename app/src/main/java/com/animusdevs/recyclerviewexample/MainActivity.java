package com.animusdevs.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListItemAdapter.ListItemClickListener {
    private RecyclerView mRecyclerView;
    private List<ListItemClass> mItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Let's load some data for our list
        //Technically this data can either be from a network call
        //Or Storage or by any other means based on the application
        mItemArrayList=new ArrayList<>();
        loadSomeItems();

        mRecyclerView=findViewById(R.id.rv_item_list);
        //Setup a layout manager for the recycler view
        //I am using linear layout manager but it can be grid layout with different span count as well
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        //Set the adapter, we are using the context for listener
        //because we already implemented the interface in this class
        mRecyclerView.setAdapter(new ListItemAdapter(mItemArrayList,this));

        //If we don't implement the interface in this class itself then the
        //following commented code can be used

        /*
        mRecyclerView.setAdapter(new ListItemAdapter(mItemArrayList, new ListItemAdapter.ListItemClickListener() {
            @Override
            public void onListItemClick(ListItemClass listItemClass) {
                //Implement the click procedure here
            }
        }));
        */


    }


    @Override
    public void onViewItemClick(ListItemClass listItemClass) {
        //Recycler view item click implemented here
        //TODO: Implement your own code
        //We are going to show a toast that the relevant item was clicked
        Toast.makeText(this,"Showing "+listItemClass.getItemName(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(ListItemClass listItemClass) {
        Toast.makeText(this,listItemClass.getItemName()+":\n"
                +listItemClass.getItemDescription(),Toast.LENGTH_SHORT).show();

    }

    private void loadSomeItems(){
        //This will load 20 items in the array list
        for(int i=1;i<=20;i++){
            mItemArrayList.add(new ListItemClass("Item Name: "+i,"Item description "+ i));
        }
    }
}
