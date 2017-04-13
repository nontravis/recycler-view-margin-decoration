package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.Px;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by thekhaeng on 4/6/2017 AD.
 */

public class GridLayoutMargin extends RecyclerView.ItemDecoration{

    private final MarginDelegate marginDelegate;

    public GridLayoutMargin( int spanCount, @Px int spacing ){
        this( spanCount, spacing, true );
    }

    public GridLayoutMargin( int spanCount, @Px int spacing, boolean includeEdge ){
        this.marginDelegate = new MarginDelegate( spanCount, spacing, includeEdge );
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, RecyclerView parent, RecyclerView.State state ){
        if( parent.getLayoutManager() instanceof GridLayoutManager ){
            GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            int position = parent.getChildAdapterPosition( view );
            int spanCurrent = lp.getSpanIndex();
            marginDelegate.calculateMargin( outRect, position, spanCurrent );
        }else{
            throw new IllegalArgumentException( "Parent is not GridLayoutManager." );
        }

    }
}
