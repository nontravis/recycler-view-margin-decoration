package com.thekhaeng.recyclerviewmargindecoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;


public class MarginStateButton extends AppCompatButton{

    public static final int TOP = 0;
    public static final int START = 1;
    public static final int END = 2;
    public static final int BOTTOM = 3;

    private int[] margins = new int[]{
            R.dimen.margin_no,
            R.dimen.margin_small,
            R.dimen.margin,
            R.dimen.margin_large,
            R.dimen.margin_extra_large
    };
    private int[] positionStrings = new int[]{
            R.string.button_top,
            R.string.button_start,
            R.string.button_end,
            R.string.button_bottom
    };
    private int[] dpStrings = new int[]{
            R.string.button_0_DP,
            R.string.button_4_DP,
            R.string.button_8_DP,
            R.string.button_16_DP,
            R.string.button_32_DP
    };

    private float margin;
    private int currentIndex = 2;
    private int position;
    private OnClickMarginStateButtonListener listener;

    public interface OnClickMarginStateButtonListener{
        void onClick();
    }

    public MarginStateButton( Context context ){
        super( context );
        init();
    }

    public MarginStateButton( Context context, AttributeSet attrs ){
        super( context, attrs );
        initWithAttrs( attrs, 0, 0 );
        init();
    }

    public MarginStateButton( Context context, AttributeSet attrs, int defStyleAttr ){
        super( context, attrs, defStyleAttr );
        initWithAttrs( attrs, defStyleAttr, 0 );
        init();
    }

    @Override
    public Parcelable onSaveInstanceState(){
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState( superState );
        ss.position = this.position;
        ss.currentIndex = this.currentIndex;
        ss.margin = this.margin;
        return ss;
    }

    @Override
    public void onRestoreInstanceState( Parcelable state ){
        if( !( state instanceof SavedState ) ){
            super.onRestoreInstanceState( state );
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState( ss.getSuperState() );
        this.position = ss.position;
        this.currentIndex = ss.currentIndex;
        this.margin = ss.margin;
        init();
    }

    public void setOnClickMarginStateButtonListener( OnClickMarginStateButtonListener listener){
        this.listener = listener;
    }


    private void init(){
        setSaveEnabled( true );
        setOnClickListener( onClick() );
        margin = getMargin( margins[currentIndex] );
        setText( positionStrings[position], dpStrings[currentIndex] );
    }

    private void setText( @StringRes int idString, @StringRes int dpString ){
        setText( getString( idString ) + " " + getString( dpString ) );
    }

    private String getString( @StringRes int id ){
        return getContext().getResources().getString( id );
    }

    public float getMargin(){
        return margin;
    }

    private float getMargin( @DimenRes int id ){
        return getContext().getResources().getDimension( id );
    }

    private void initWithAttrs( AttributeSet attrs, int defStyleAttr, int defStyleRes ){
        TypedArray a = getContext().obtainStyledAttributes(
                attrs,
                R.styleable.MarginStateButton,
                defStyleAttr,
                defStyleRes );
        try{
            position = a.getInt( R.styleable.MarginStateButton_position, TOP );
        }finally{
            a.recycle();
        }
    }

    @NonNull
    private OnClickListener onClick(){
        return new OnClickListener(){
            @Override
            public void onClick( View v ){
                currentIndex = ( ++currentIndex ) % margins.length;
                setText( positionStrings[position], dpStrings[currentIndex] );
                margin = getMargin( margins[currentIndex] );
                if( listener != null ){
                    listener.onClick();
                }
            }
        };
    }

    private static class SavedState extends BaseSavedState{
        private float margin;
        private int currentIndex = 1;
        private int position;

        SavedState( Parcelable superState ){
            super( superState );
        }

        private SavedState( Parcel in ){
            super( in );
            this.margin = in.readFloat();
            this.currentIndex = in.readInt();
            this.position = in.readInt();
        }
        @Override
        public void writeToParcel( Parcel out, int flags ){
            super.writeToParcel( out, flags );
            out.writeFloat( this.margin );
            out.writeInt( this.currentIndex );
            out.writeInt( this.position );
        }

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>(){
            public SavedState createFromParcel( Parcel in ){
                return new SavedState( in );
            }

            public SavedState[] newArray( int size ){
                return new SavedState[size];
            }
        };
    }


}
