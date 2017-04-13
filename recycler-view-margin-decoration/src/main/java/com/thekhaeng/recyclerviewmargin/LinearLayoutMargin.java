package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.Px;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by thekhaeng on 4/6/2017 AD.
 */

public class LinearLayoutMargin extends RecyclerView.ItemDecoration{

    private final MarginDelegate marginDelegate;

    public LinearLayoutMargin(@Px int spacing ){
        this.marginDelegate = new MarginDelegate( 1, spacing, true );
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, RecyclerView parent, RecyclerView.State state ){
        if (parent.getLayoutManager() instanceof LinearLayoutManager ){
            int position = parent.getChildAdapterPosition( view ); // item position
            int spanCount = 1;
            int spanCurrent = 0;
            marginDelegate.calculateMargin( outRect, position, spanCurrent );
        }else{
            throw new IllegalArgumentException("Parent is not LinearLayoutManager.");
        }
    }
}
