package com.thekhaeng.recyclerviewmargin;

import android.graphics.Rect;
import android.support.annotation.Px;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by thekhaeng on 4/6/2017 AD.
 */

public class LinearLayoutMargin extends BaseLayoutMargin{


    public LinearLayoutMargin( @Px int spacing ){
        super( 1, spacing );
    }

    @Override
    public void setPadding( RecyclerView rv, @Px int padding ){
        super.setPadding( rv, padding );
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
    public void getItemOffsets( Rect outRect, View view, final RecyclerView parent, RecyclerView.State state ){
        if( parent.getLayoutManager() instanceof LinearLayoutManager ){
            super.getItemOffsets( outRect, view, parent, state );
            int position = parent.getChildAdapterPosition( view ); // item position
            int spanCurrent = 0;
            setupClickLayoutMarginItem( parent.getContext(), view, position, spanCurrent, state );
            int orientation = ( (LinearLayoutManager) parent.getLayoutManager() ).getOrientation();
            boolean isInverse = ( (LinearLayoutManager) parent.getLayoutManager() ).getReverseLayout();
            calculateMargin( outRect, position, spanCurrent, state.getItemCount(), orientation, isInverse );
        }else{
            throw new RuntimeException( "Parent view is not LinearLayoutManager." );
        }
    }
}
