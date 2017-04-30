package com.thekhaeng.recyclerviewmargindecoration.event;

import android.os.Bundle;

import static com.thekhaeng.recyclerviewmargindecoration.MarginFragment.KEY_BOTTOM_MARGIN;
import static com.thekhaeng.recyclerviewmargindecoration.MarginFragment.KEY_LEFT_MARGIN;
import static com.thekhaeng.recyclerviewmargindecoration.MarginFragment.KEY_RIGHT_MARGIN;
import static com.thekhaeng.recyclerviewmargindecoration.MarginFragment.KEY_SPACE;
import static com.thekhaeng.recyclerviewmargindecoration.MarginFragment.KEY_TOP_MARGIN;

/**
 * Created by thekhaeng on 4/30/2017 AD.
 */

public class MarginData{

    private Bundle bundle;

    public MarginData( Bundle bundle ){
        this.bundle = bundle;
    }

    public Bundle getBundle(){
        return bundle;
    }

    public int getMarginTop(){
        return (int) bundle.getFloat( KEY_TOP_MARGIN );
    }

    public int getMarginBottom(){
        return (int) bundle.getFloat( KEY_BOTTOM_MARGIN );
    }

    public int getMarginLeft(){
        return (int) bundle.getFloat( KEY_LEFT_MARGIN );
    }

    public int getMarginRight(){
        return (int) bundle.getFloat( KEY_RIGHT_MARGIN );
    }

    public int getSpace(){
        return (int) bundle.getFloat( KEY_SPACE );
    }
}
