package com.thekhaeng.recyclerviewmargindecoration;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity{

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        Handler handler = new Handler();
        handler.postDelayed( new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent( SplashActivity.this, MainActivity.class );
                startActivity( intent );
                finish();
                overridePendingTransition( R.anim.fade_in, R.anim.fade_out );
            }
        }, 600 );
    }
}
