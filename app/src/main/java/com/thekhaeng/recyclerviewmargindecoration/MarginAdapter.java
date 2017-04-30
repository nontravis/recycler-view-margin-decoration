package com.thekhaeng.recyclerviewmargindecoration;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thekhaeng on 4/13/2017 AD.
 */

public class MarginAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<MarginItem> items;
    private Context context;

    public MarginAdapter( Context context ){
        this.context = context;
        items = new ArrayList<>();
        items.add( new MarginItem( dpToPx( 200 ) ) );
        items.add( new MarginItem( dpToPx( 100 ) ) );
        items.add( new MarginItem( dpToPx( 150 ) ) );
        items.add( new MarginItem( dpToPx( 150 ) ) );
        items.add( new MarginItem( dpToPx( 200 ) ) );
        items.add( new MarginItem( dpToPx( 50 ) ) );
        items.add( new MarginItem( dpToPx( 250 ) ) );
        items.add( new MarginItem( dpToPx( 100 ) ) );
        items.add( new MarginItem( dpToPx( 250 ) ) );
        items.add( new MarginItem( dpToPx( 200 ) ) );
        items.add( new MarginItem( dpToPx( 150 ) ) );
        items.add( new MarginItem( dpToPx( 200 ) ) );
        items.add( new MarginItem( dpToPx( 400 ) ) );
        items.add( new MarginItem( dpToPx( 50 ) ) );
        items.add( new MarginItem( dpToPx( 250 ) ) );
        items.add( new MarginItem( dpToPx( 100 ) ) );
        items.add( new MarginItem( dpToPx( 250 ) ) );
        items.add( new MarginItem( dpToPx( 150 ) ) );
        items.add( new MarginItem( dpToPx( 350 ) ) );
        items.add( new MarginItem( dpToPx( 100 ) ) );
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


    private int dpToPx( int dp ){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round( dp * ( displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT ) );
    }

    class MarginHolder extends RecyclerView.ViewHolder{

        View background;

        MarginHolder( final View itemView ){
            super( itemView );
            this.background = itemView.findViewById( R.id.background );
        }
    }
}
