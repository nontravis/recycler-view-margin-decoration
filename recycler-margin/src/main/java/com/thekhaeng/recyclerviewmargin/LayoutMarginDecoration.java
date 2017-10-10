package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.Px;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by thekhaeng on 4/6/2017 AD.
 */

public class LayoutMarginDecoration extends BaseLayoutMargin{

    public LayoutMarginDecoration( @Px int spacing ){
        super( 1, spacing );
    }

    public LayoutMarginDecoration( int spanCount, @Px int spacing ){
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
        super.getItemOffsets( outRect, view, parent, state );
        boolean isRTL = parent.getContext().getResources().getBoolean( R.bool.is_right_to_left );
        int orientation = OrientationHelper.VERTICAL;
        boolean isInverse = false;

        int position = parent.getChildAdapterPosition( view );

        int spanCurrent = position % getSpanCount();
        if( parent.getLayoutManager() instanceof StaggeredGridLayoutManager ){
            orientation = ( (StaggeredGridLayoutManager) parent.getLayoutManager() ).getOrientation();
            isInverse = ( (StaggeredGridLayoutManager) parent.getLayoutManager() ).getReverseLayout();
            StaggeredGridLayoutManager.LayoutParams lp = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
            spanCurrent = lp.getSpanIndex();
        }else if( parent.getLayoutManager() instanceof GridLayoutManager ){
            orientation = ( (GridLayoutManager) parent.getLayoutManager() ).getOrientation();
            isInverse = ( (GridLayoutManager) parent.getLayoutManager() ).getReverseLayout();
            GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
            spanCurrent = lp.getSpanIndex();
            if( isRTL && orientation == OrientationHelper.VERTICAL  ){
                spanCurrent = getSpanCount() - spanCurrent - 1;
            }
        }else if( parent.getLayoutManager() instanceof LinearLayoutManager ){
            orientation = ( (LinearLayoutManager) parent.getLayoutManager() ).getOrientation();
            isInverse = ( (LinearLayoutManager) parent.getLayoutManager() ).getReverseLayout();
            position = parent.getChildAdapterPosition( view ); // item position
            spanCurrent = 0;
        }

        if( isRTL && orientation == OrientationHelper.HORIZONTAL ){
            position = state.getItemCount() - position - 1;
        }

        setupClickLayoutMarginItem( parent.getContext(), view, position, spanCurrent, state );
        calculateMargin(
                outRect,
                position,
                spanCurrent,
                state.getItemCount(),
                orientation,
                isInverse,
                isRTL );
    }

}
