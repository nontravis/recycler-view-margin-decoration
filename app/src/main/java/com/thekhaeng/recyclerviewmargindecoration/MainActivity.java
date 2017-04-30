package com.thekhaeng.recyclerviewmargindecoration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hwangjr.rxbus.RxBus;
import com.thekhaeng.recyclerviewmargindecoration.event.MarginData;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity{

    private MarginStateButton btnTop;
    private MarginStateButton btnBottom;
    private MarginStateButton btnStart;
    private MarginStateButton btnEnd;
    private MarginStateButton btnSpace;

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btnTop = (MarginStateButton) findViewById( R.id.btn_top );
        btnBottom = (MarginStateButton) findViewById( R.id.btn_bottom );
        btnStart = (MarginStateButton) findViewById( R.id.btn_start );
        btnEnd = (MarginStateButton) findViewById( R.id.btn_end );
        btnSpace = (MarginStateButton) findViewById( R.id.btn_space );
        ViewPager rvContainer = (ViewPager) findViewById( R.id.container );
        TabLayout tabLayout = (TabLayout) findViewById( R.id.tabs );

        tabLayout.setupWithViewPager( rvContainer );
        PagerStateAdapter pagerAdapter = new PagerStateAdapter( getSupportFragmentManager() );
        rvContainer.setAdapter( pagerAdapter );

        btnSpace.setOnClickMarginStateButtonListener( onClickMarginStateButton() );
        btnTop.setOnClickMarginStateButtonListener( onClickMarginStateButton() );
        btnBottom.setOnClickMarginStateButtonListener( onClickMarginStateButton() );
        btnEnd.setOnClickMarginStateButtonListener( onClickMarginStateButton() );
        btnStart.setOnClickMarginStateButtonListener( onClickMarginStateButton() );
    }

    @NonNull
    private MarginStateButton.OnClickMarginStateButtonListener onClickMarginStateButton(){
        return new MarginStateButton.OnClickMarginStateButtonListener(){
            @Override
            public void onClick(){
                RxBus.get().post( new MarginData( createMarginBundleData() ) );
            }
        };
    }

    @NonNull
    private Bundle createMarginBundleData(){
        Bundle args = new Bundle();
        args.putFloat( MarginFragment.KEY_SPACE, btnSpace.getMargin() );
        args.putFloat( MarginFragment.KEY_TOP_MARGIN, btnTop.getMargin() );
        args.putFloat( MarginFragment.KEY_LEFT_MARGIN, btnStart.getMargin() );
        args.putFloat( MarginFragment.KEY_RIGHT_MARGIN, btnEnd.getMargin() );
        args.putFloat( MarginFragment.KEY_BOTTOM_MARGIN, btnBottom.getMargin() );
        return args;
    }

    class PagerStateAdapter extends FragmentStatePagerAdapter{
        private static final int TOTAL_PAGE = 3;
        static final int LINEAR = 1;
        static final int GRID = 2;
        static final int STAGGERED_GRID = 3;
        private final WeakReference<FragmentManager> fm;

        PagerStateAdapter( FragmentManager fragmentManager ){
            super( fragmentManager );
            fm = new WeakReference<>( fragmentManager );
        }

        @Override
        public Fragment getItem( int position ){
            Bundle args = createMarginBundleData();
            switch( position ){
                case 0:
                    args.putInt( MarginFragment.KEY_LAYOUT, LINEAR );
                    return MarginFragment.newInstance( args );
                case 1:
                    args.putInt( MarginFragment.KEY_LAYOUT, GRID );
                    return MarginFragment.newInstance( args );
                case 2:
                    args.putInt( MarginFragment.KEY_LAYOUT, STAGGERED_GRID );
                    return MarginFragment.newInstance( args );
                default:
                    throw new NullPointerException( "Position more than 2." );
            }
        }

        @Override
        public int getCount(){
            return TOTAL_PAGE;
        }

        @Override
        public CharSequence getPageTitle( int position ){
            switch( position ){
                case 0:
                    return "Linear";
                case 1:
                    return "Grid";
                case 2:
                    return "StaggeredGrid";
            }
            return null;
        }
    }

}
