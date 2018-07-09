package com.animusdevs.recyclerviewexample2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.animusdevs.datamodel.ListItemClass;
import com.animusdevs.recyclerviewexample.ListItemAdapter;
import com.animusdevs.recyclerviewexample.MainActivity;
import com.animusdevs.recyclerviewexample.R;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity implements ListItemAdapterClickListener,
    View.OnClickListener{
    private List<ListItemClass> mItemArrayList;
    private ListItemAdapter2 mAdapter;
    private RecyclerView mRecyclerView;
    private FloatingActionButton mFloatingActionBack;
    private FloatingActionButton mFloatingActionAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name)+"2");
        }

        mFloatingActionBack=findViewById(R.id.fab);
        mFloatingActionAdd=findViewById(R.id.fab_add_item);
        mFloatingActionBack.setOnClickListener(this);
        mFloatingActionAdd.setOnClickListener(this);


        mItemArrayList=new ArrayList<>();
        loadSomeItems();

        mAdapter=new ListItemAdapter2(mItemArrayList);
        //Set the on click listener for this adapter
        mAdapter.setOnItemClickListener(this);

        mRecyclerView=findViewById(R.id.rv_item_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_add_item:
                mAdapter.addItem();
                mRecyclerView.smoothScrollToPosition(0);
                break;
            case R.id.fab:
                startActivity(new Intent(FirstActivity.this, MainActivity.class));
                break;
        }
    }

    @Override
    public void onListItemClick(View view, int adapterPosition) {
        //We have to identify the view which can be done by the id
        switch (view.getId()){
            case R.id.btn_item_click:
                Toast.makeText(this,"Showing "
                        +mItemArrayList.get(adapterPosition).getItemName(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                mAdapter.removeItem(adapterPosition);
                break;
            default:
                //This is the body click
                Toast.makeText(this,mItemArrayList.get(adapterPosition).getItemName()+":\n"
                        +mItemArrayList.get(adapterPosition).getItemDescription(),Toast.LENGTH_SHORT).show();

        }
    }

    private void loadSomeItems(){
        //This will load 20 items in the array list
        for(int i=1;i<=20;i++){
            mItemArrayList.add(new ListItemClass("Item Name: "+i,"Item description "+ i));
        }
    }
}
