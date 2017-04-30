package com.thekhaeng.recyclerviewmargin;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Px;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import static android.view.View.SCROLLBARS_OUTSIDE_OVERLAY;

/**
 * Created by thekhaeng on 4/30/2017 AD.
 */

abstract class BaseLayoutMargin extends RecyclerView.ItemDecoration{

    private final MarginDelegate marginDelegate;
    private final int spanCount;
    private final int spacing;
    private OnClickLayoutMarginItemListener listener;
    private int marginTop = 0;
    private int marginBottom = 0;
    private int marginLeft = 0;
    private int marginRight = 0;


    BaseLayoutMargin( int spanCount, @Px int spacing ){
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.marginDelegate = new MarginDelegate( spanCount, spacing );
    }

    void setOnClickLayoutMarginItemListener( OnClickLayoutMarginItemListener listener ){
        this.listener = listener;
    }

    void setPadding( RecyclerView rv, @Px int margin ){
        this.setPadding(rv, margin, margin, margin, margin );
    }

    void setPadding( RecyclerView rv,
                     @Px int marginTop,
                     @Px int marginBottom,
                     @Px int marginLeft,
                     @Px int marginRight ){
        rv.setClipToPadding( false );
        rv.setScrollBarStyle( SCROLLBARS_OUTSIDE_OVERLAY );
        rv.setPadding( marginLeft, marginTop, marginRight, marginBottom );
    }

    MarginDelegate getMarginDelegate(){
        return marginDelegate;
    }

    void calculateMargin( Rect outRect, int position, int spanCurrent, int itemCount ){
        marginDelegate.calculateMargin( outRect, position, spanCurrent, itemCount );
    }

    public int getSpacing(){
        return spacing;
    }

    public int getSpanCount(){
        return spanCount;
    }

    void setupClickLayoutMarginItem( Context context,
                                     View view,
                                     int position,
                                     int spanCurrent,
                                     RecyclerView.State state ){
        if( listener != null )
            view.setOnClickListener( onClickItem( context, view, position, spanCurrent, state ) );
    }

    @NonNull
    private View.OnClickListener onClickItem( final Context context, final View view, final int position, final int currentSpan, final RecyclerView.State state ){
        return new View.OnClickListener(){
            @Override
            public void onClick( View v ){
                if( listener != null )
                    listener.onClick( context, view, position, currentSpan, state );
            }
        };
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, RecyclerView parent, RecyclerView.State state ){
        super.getItemOffsets( outRect, view, parent, state );
    }

    private boolean isMargin(){
        return marginTop != 0 || marginBottom != 0 || marginLeft != 0 || marginRight != 0;
    }

}
