package com.thekhaeng.recyclerviewmargin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by thekhaeng on 4/30/2017 AD.
 */

public interface OnClickLayoutMarginItemListener{
    void onClick( Context context, View v, int position, int spanIndex, RecyclerView.State state );
}
