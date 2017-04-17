package com.thekhaeng.recyclerviewmargindecoration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thekhaeng.recyclerviewmargin.GridLayoutMargin;
import com.thekhaeng.recyclerviewmargin.LinearLayoutMargin;
import com.thekhaeng.recyclerviewmargin.StaggeredGridLayoutMargin;

import static com.thekhaeng.recyclerviewmargindecoration.MainActivity.PagerStateAdapter.GRID;
import static com.thekhaeng.recyclerviewmargindecoration.MainActivity.PagerStateAdapter.LINEAR;
import static com.thekhaeng.recyclerviewmargindecoration.MainActivity.PagerStateAdapter.STAGGERED_GRID;

public class MarginFragment extends Fragment{
    private final static String TAG = MarginFragment.class.getSimpleName();
    public static final String BUNDLE_SAVE_DATA = "bundle_save_data";
    public static final String KEY_LAYOUT = "key_layout";

    public MarginFragment(){
        super();
    }

    public static MarginFragment newInstance( int layout ){
        MarginFragment fragment = new MarginFragment();
        Bundle args = new Bundle();
        args.putInt( KEY_LAYOUT, layout );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ){
        View rootView = inflater.inflate( R.layout.fragment_margin, container, false );
        initInstance( rootView, savedInstanceState );
        return rootView;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState ){
        super.onActivityCreated( savedInstanceState );
    }

    @SuppressWarnings( "UnusedParameters" )
    private void initInstance( View rootView, Bundle savedInstanceState ){
        RecyclerView rvMargin = (RecyclerView) rootView.findViewById( R.id.rv_margin );
        int itemSpace = (int) getResources().getDimension( R.dimen.default_padding_margin_extra_large );
        switch( getArguments().getInt( KEY_LAYOUT ) ){
            case LINEAR:
                rvMargin.setLayoutManager( new LinearLayoutManager( getContext() ) );
                rvMargin.addItemDecoration( new LinearLayoutMargin( itemSpace ) );
//                rvMargin.addItemDecoration( new DefaultLayoutMargin( 1, itemSpace, true ) );
                break;
            case GRID:
                int gridSpan = 3;
                rvMargin.setLayoutManager( new GridLayoutManager( getContext(), gridSpan ) );
                rvMargin.addItemDecoration( new GridLayoutMargin( gridSpan, itemSpace ) );
//                rvMargin.addItemDecoration( new DefaultLayoutMargin( gridSpan, itemSpace, true ) );
                break;
            case STAGGERED_GRID:
                int stagSpan = 3;
                rvMargin.setLayoutManager( new StaggeredGridLayoutManager( stagSpan, StaggeredGridLayoutManager.VERTICAL ) );
                rvMargin.addItemDecoration( new StaggeredGridLayoutMargin( stagSpan, itemSpace ) );
//                rvMargin.addItemDecoration( new DefaultLayoutMargin( stagSpan, itemSpace, true ) );
                break;
        }
        rvMargin.setAdapter( new MarginAdapter() );
    }

}
