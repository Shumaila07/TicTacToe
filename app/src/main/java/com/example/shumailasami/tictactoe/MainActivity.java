package com.example.shumailasami.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myActivePlayer =0;
    //0 for cross and 1 for circle

    //My game state
    //Default game state
    int [] myGameState={3,3,3,3,3,3,3,3,3};

    public void imageTapped(View view)
    {
        ImageView myTapped=(ImageView) view;

        Log.i( "tag of","image is"+myTapped.getTag().toString() );
        int tappedimageTag=Integer.parseInt(myTapped.getTag().toString());

        if(myGameState[tappedimageTag] == 3) {
            myGameState[tappedimageTag]=myActivePlayer;

            if (myActivePlayer == 0) {
                myTapped.setImageResource( R.drawable.cross );
                myTapped.animate().rotation( 360 ).setDuration( 1000 );
                myActivePlayer = 1;
            } else {
                myTapped.setImageResource( R.drawable.circle );
                myActivePlayer = 0;

            }
        }
        else
            Toast.makeText(getApplicationContext(),"this place is filled already",Toast.LENGTH_LONG  ).show();

    }


    public void playAgain(View view)
    {
        //Log.i( "msg","play again tapped" );
        //set gameState again back 2

        for(int i=0;i<myGameState.length;i++)
        {
            myGameState[i]=3;

        }

        //set activePlayer 0 again
        myActivePlayer=0;

        //change all images to ic_launcher
        LinearLayout linearLayout=(LinearLayout) findViewById( R.id.line1 );
        for(int i=0;i<linearLayout.getChildCount();i++)
        {
            ((ImageView)linearLayout.getChildAt( i )).setImageResource( R.mipmap.ic_launcher );
        }

        LinearLayout linearLayout1=(LinearLayout) findViewById( R.id.line2 );
        for(int i=0;i<linearLayout1.getChildCount();i++)
        {
            ((ImageView)linearLayout1.getChildAt( i )).setImageResource( R.mipmap.ic_launcher );
        }

        LinearLayout linearLayout2=(LinearLayout) findViewById( R.id.line3 );
        for(int i=0;i<linearLayout2.getChildCount();i++)
        {
            ((ImageView)linearLayout2.getChildAt( i )).setImageResource( R.mipmap.ic_launcher );
        }




    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
}
