package com.thekhaeng.recyclerviewmargindecoration;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ViewPager rvContainer = (ViewPager) findViewById( R.id.container );
        TabLayout tabLayout = (TabLayout) findViewById( R.id.tabs );

        tabLayout.setupWithViewPager( rvContainer );
        PagerStateAdapter pagerAdapter = new PagerStateAdapter( getSupportFragmentManager() );
        rvContainer.setAdapter( pagerAdapter );
    }


    static class PagerStateAdapter extends FragmentStatePagerAdapter{
        private final static String TAG = PagerStateAdapter.class.getSimpleName();
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
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch( position ){
                case 0:
                    return MarginFragment.newInstance( LINEAR );
                case 1:
                    return MarginFragment.newInstance( GRID );
                case 2:
                    return MarginFragment.newInstance( STAGGERED_GRID );
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
