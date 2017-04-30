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
        super.setPadding(rv, margin );
    }

    @Override
    public void setPadding( RecyclerView rv, @Px int marginTop, @Px int marginBottom, @Px int marginLeft, @Px int marginRight ){
        super.setPadding(rv, marginTop, marginBottom, marginLeft, marginRight );
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
            calculateMargin( outRect, position, spanCurrent, state.getItemCount() );
            setupClickLayoutMarginItem( parent.getContext(), view, position, spanCurrent, state );
        }else{
            throw new RuntimeException( "Parent view is not GridLayoutManager." );
        }

    }
}
