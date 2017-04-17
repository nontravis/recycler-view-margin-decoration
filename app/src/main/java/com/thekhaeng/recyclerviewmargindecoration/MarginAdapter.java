package com.thekhaeng.recyclerviewmargindecoration;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thekhaeng on 4/13/2017 AD.
 */

public class MarginAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<MarginItem> items;

    public MarginAdapter(){
        items = new ArrayList<>();
        items.add( new MarginItem( 600 ) );
        items.add( new MarginItem( 200 ) );
        items.add( new MarginItem( 300 ) );
        items.add( new MarginItem( 300 ) );
        items.add( new MarginItem( 400 ) );
        items.add( new MarginItem( 100 ) );
        items.add( new MarginItem( 700 ) );
        items.add( new MarginItem( 200 ) );
        items.add( new MarginItem( 500 ) );
        items.add( new MarginItem( 600 ) );
        items.add( new MarginItem( 300 ) );
        items.add( new MarginItem( 400 ) );
        items.add( new MarginItem( 800 ) );
        items.add( new MarginItem( 100 ) );
        items.add( new MarginItem( 500 ) );
        items.add( new MarginItem( 200 ) );
        items.add( new MarginItem( 500 ) );
        items.add( new MarginItem( 300 ) );
        items.add( new MarginItem( 700 ) );
        items.add( new MarginItem( 200 ) );
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType ){
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.holder_margin, parent, false );
        return new MarginHolder( view );
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position ){
        MarginHolder marginHolder = (MarginHolder) holder;
        MarginItem marginItem = items.get( position );
        ViewGroup.LayoutParams layoutParams = marginHolder.background.getLayoutParams();
        layoutParams.height = marginItem.getHeight();
        marginHolder.background.setLayoutParams( layoutParams );
    }

    public static class MarginHolder extends RecyclerView.ViewHolder{

        View background;

        public MarginHolder( final View itemView ){
            super( itemView );
            this.background = itemView.findViewById( R.id.background );
            itemView.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick( View v ){
                    Toast.makeText( itemView.getContext(), "item: " + getAdapterPosition(), Toast.LENGTH_SHORT ).show();
                }
            } );
        }
    }
}
