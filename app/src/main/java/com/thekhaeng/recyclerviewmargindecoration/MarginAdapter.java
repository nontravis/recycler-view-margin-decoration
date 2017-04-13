package com.thekhaeng.recyclerviewmargindecoration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by thekhaeng on 4/13/2017 AD.
 */

public class MarginAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    @Override
    public int getItemCount(){
        return 20;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType ){
        View view =  LayoutInflater.from( parent.getContext() ).inflate( R.layout.holder_margin, parent, false );
        return new MarginHolder( view );
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position ){

    }

    public static class MarginHolder extends RecyclerView.ViewHolder{

        public MarginHolder( View itemView ){
            super( itemView );
        }
    }
}
