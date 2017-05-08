package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.IntRange;
import android.support.annotation.Px;
import android.support.v7.widget.OrientationHelper;

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
                          int itemCount,
                          @IntRange( from = 0, to = 1 ) int orientation,
                          boolean isReverse ){
        if( orientation == OrientationHelper.VERTICAL ){
            outRect.left = spanCurrent * spaceItem / spanCount;
            outRect.right = spaceItem - ( spanCurrent + 1 ) * spaceItem / spanCount;
            if( isReverse ){
                if( position >= spanCount ) outRect.bottom = spaceItem;
            }else{
                if( position >= spanCount ) outRect.top = spaceItem;
            }
        }else if( orientation == OrientationHelper.HORIZONTAL ){
            outRect.top = spanCurrent * spaceItem / spanCount;
            outRect.bottom = spaceItem - ( spanCurrent + 1 ) * spaceItem / spanCount;
            if( isReverse ){
                if( position >= spanCount ) outRect.right = spaceItem;
            }else{
                if( position >= spanCount ) outRect.left = spaceItem;
            }
        }
    }
}
