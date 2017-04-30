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
    public void setMargin( @Px int margin ){
        super.setMargin( margin );
    }

    @Override
    public void setMargin( @Px int marginTop, @Px int marginBottom, @Px int marginLeft, @Px int marginRight ){
        super.setMargin( marginTop, marginBottom, marginLeft, marginRight );
    }

    @Override
    public void setOnClickLayoutMarginItemListener( OnClickLayoutMarginItemListener listener ){
        super.setOnClickLayoutMarginItemListener( listener );
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, final RecyclerView parent, RecyclerView.State state ){
        if( parent.getLayoutManager() instanceof LinearLayoutManager ){
            int position = parent.getChildAdapterPosition( view ); // item position
            int spanCurrent = 0;
            setupClickLayoutMarginItem( parent.getContext(), view, position, spanCurrent, state );
            calculateMargin( outRect, position, spanCurrent, state.getItemCount() );
        }else{
            throw new RuntimeException( "Parent view is not LinearLayoutManager." );
        }
    }
}
