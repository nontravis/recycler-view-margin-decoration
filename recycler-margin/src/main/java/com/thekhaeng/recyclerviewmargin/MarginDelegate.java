package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.Px;

/**
 * Created by thekhaeng on 4/13/2017 AD.
 */

class MarginDelegate{

    private final int spanCount;
    private final int spaceItem;
    private int topMargin = 0;
    private int bottomMargin = 0;
    private int leftMargin = 0;
    private int rightMargin = 0;

    MarginDelegate( int spanCount, @Px int spaceItem ){
        this.spanCount = spanCount;
        this.spaceItem = spaceItem;
    }

    void setMargin( @Px int top, @Px int bottom, @Px int start, @Px int end ){
        this.topMargin = top;
        this.bottomMargin = bottom;
        this.leftMargin = start;
        this.rightMargin = end;
    }

    boolean isMargin(){
        return topMargin != 0 || bottomMargin != 0 || leftMargin != 0 || rightMargin != 0;
    }

    void calculateMargin( Rect outRect,
                          int position,
                          int spanCurrent,
                          int itemCount ){
        if( isMargin() ){
            outRect.left = spaceItem - spanCurrent * spaceItem / spanCount;
            if( outRect.left == spaceItem && spanCurrent % spanCount == 0 )
                outRect.left = leftMargin;
            outRect.right = ( spanCurrent + 1 ) * spaceItem / spanCount;
            if( outRect.right == spaceItem && spanCurrent % spanCount == spanCount-1 )
                outRect.right = rightMargin;

            if( position < spanCount ) outRect.top = topMargin;
            outRect.bottom = spaceItem;

            int lastRowCount = itemCount % spanCount;
            if( itemCount % spanCount == 0 ) lastRowCount = spanCount;
            if( position > itemCount - lastRowCount - 1 ) outRect.bottom = bottomMargin;
        }else{
            outRect.left = spanCurrent * spaceItem / spanCount;
            outRect.right = spaceItem - ( spanCurrent + 1 ) * spaceItem / spanCount;
            if( position >= spanCount ) outRect.top = spaceItem;
        }
    }
}
