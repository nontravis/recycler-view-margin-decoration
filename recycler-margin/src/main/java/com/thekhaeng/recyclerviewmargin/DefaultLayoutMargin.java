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

public class DefaultLayoutMargin extends BaseLayoutMargin{

    public DefaultLayoutMargin( int spanCount, @Px int spacing ){
        super( spanCount, spacing );
    }

    @Override
    public void setPadding( RecyclerView rv, @Px int margin ){
        super.setPadding(rv, margin );
    }

    @Override
    public void setPadding( RecyclerView rv, @Px int top, @Px int bottom, @Px int left, @Px int right ){
        super.setPadding(rv, top, bottom, left, right );
    }

    @Override
    public void setOnClickLayoutMarginItemListener( OnClickLayoutMarginItemListener listener ){
        super.setOnClickLayoutMarginItemListener( listener );
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, RecyclerView parent, RecyclerView.State state ){
        super.getItemOffsets( outRect, view, parent, state );
        int position = parent.getChildAdapterPosition( view );
        int spanCurrent = position % getSpanCount();
        if( parent.getLayoutManager() instanceof StaggeredGridLayoutManager ){
            StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            spanCurrent = lp.getSpanIndex();
        }else if( parent.getLayoutManager() instanceof GridLayoutManager ){
            GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            spanCurrent = lp.getSpanIndex();
        }else if( parent.getLayoutManager() instanceof LinearLayoutManager ){
            position = parent.getChildAdapterPosition( view ); // item position
            spanCurrent = 0;
        }
        setupClickLayoutMarginItem( parent.getContext(), view, position, spanCurrent, state );

        calculateMargin( outRect, position, spanCurrent, state.getItemCount() );
    }

}
