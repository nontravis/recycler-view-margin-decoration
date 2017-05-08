package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.Px;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by thekhaeng on 4/6/2017 AD.
 */

public class GridLayoutMargin extends BaseLayoutMargin{


    public GridLayoutMargin( int spanCount, @Px int spacing ){
        super( spanCount, spacing );
    }

    @Override
    public void setPadding( RecyclerView rv, @Px int margin ){
        super.setPadding( rv, margin );
    }

    @Override
    public void setPadding( RecyclerView rv, @Px int top, @Px int bottom, @Px int left, @Px int right ){
        super.setPadding( rv, top, bottom, left, right );
    }

    @Override
    public void setOnClickLayoutMarginItemListener( OnClickLayoutMarginItemListener listener ){
        super.setOnClickLayoutMarginItemListener( listener );
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, RecyclerView parent, RecyclerView.State state ){
        if( parent.getLayoutManager() instanceof GridLayoutManager ){
            super.getItemOffsets( outRect, view, parent, state );
            GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            int position = parent.getChildAdapterPosition( view );
            int spanCurrent = lp.getSpanIndex();
            int orientation = ( (GridLayoutManager) parent.getLayoutManager() ).getOrientation();
            boolean isInverse = ( (GridLayoutManager) parent.getLayoutManager() ).getReverseLayout();
            calculateMargin( outRect, position, spanCurrent, state.getItemCount(), orientation, isInverse );
            setupClickLayoutMarginItem( parent.getContext(), view, position, spanCurrent, state );
        }else{
            throw new RuntimeException( "Parent view is not GridLayoutManager." );
        }

    }
}
