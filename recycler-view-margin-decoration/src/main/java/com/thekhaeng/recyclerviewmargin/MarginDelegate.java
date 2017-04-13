package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;

/**
 * Created by thekhaeng on 4/13/2017 AD.
 */

class MarginDelegate{

    private final int spanCount;
    private final int spacing;
    private final boolean includeEdge;

    MarginDelegate( int spanCount, int spacing, boolean includeEdge ){
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    void calculateMargin( Rect outRect,
                          int position,
                          int spanCurrent ){
        if( includeEdge ){
            outRect.left = spacing - spanCurrent * spacing / spanCount;
            outRect.right = ( spanCurrent + 1 ) * spacing / spanCount;
            if( position < spanCount ){
                outRect.top = spacing;
                outRect.bottom = spacing;
            }
            outRect.bottom = spacing;
        }else{
            outRect.left = spanCurrent * spacing / spanCount;
            outRect.right = spacing - ( spanCurrent + 1 ) * spacing / spanCount;
            if( position >= spanCount ){
                outRect.top = spacing;
            }
        }
    }
}
