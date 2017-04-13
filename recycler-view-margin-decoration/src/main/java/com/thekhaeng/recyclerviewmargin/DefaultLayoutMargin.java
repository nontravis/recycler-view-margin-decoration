package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.Px;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by thekhaeng on 4/6/2017 AD.
 */

public class DefaultLayoutMargin extends RecyclerView.ItemDecoration{

    private final MarginDelegate marginDelegate;
    private int spanCount;

    public DefaultLayoutMargin( int spanCount, @Px int spacing ){
        this( spanCount, spacing, true );
    }

    public DefaultLayoutMargin( int spanCount, @Px int spacing, boolean includeEdge ){
        this.marginDelegate = new MarginDelegate( spanCount, spacing, includeEdge );
        this.spanCount = spanCount;
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, RecyclerView parent, RecyclerView.State state ){
        int position = parent.getChildAdapterPosition( view );
        int spanCurrent = position % spanCount;
        if( parent.getLayoutManager() instanceof StaggeredGridLayoutManager ){
            StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            spanCurrent = lp.getSpanIndex();
        }else if( parent.getLayoutManager() instanceof GridLayoutManager ){
            GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            spanCurrent = lp.getSpanIndex();
        }else if( parent.getLayoutManager() instanceof LinearLayoutManager ){
        }
        marginDelegate.calculateMargin( outRect, position, spanCurrent );
    }
}
