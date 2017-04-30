package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.Px;

/**
 * Created by thekhaeng on 4/13/2017 AD.
 */

class MarginDelegate{

    private final int spanCount;
    private final int spaceItem;

    MarginDelegate( int spanCount, @Px int spaceItem ){
        this.spanCount = spanCount;
        this.spaceItem = spaceItem;
    }

    void calculateMargin( Rect outRect,
                          int position,
                          int spanCurrent,
                          int itemCount ){
        outRect.left = spanCurrent * spaceItem / spanCount;
        outRect.right = spaceItem - ( spanCurrent + 1 ) * spaceItem / spanCount;
        if( position >= spanCount ) outRect.top = spaceItem;
    }
}
