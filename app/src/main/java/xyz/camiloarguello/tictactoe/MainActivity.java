package xyz.camiloarguello.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int turn;
    boolean[] boxes = {false,false,false,false,false,false,false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn = 1;
    }

    public void dropInChip(View view){
        ImageView counter = (ImageView) view;

        // Getting item by tag
        int tappedBox = Integer.parseInt(counter.getTag().toString());

        // If the box tapped has not tapped before
        if(!boxes[tappedBox]){

            // Set the tapped box to true to prevent being tapped again
            boxes[tappedBox] = true;

            // If it's pair number puts the reds. Otherwise puts yellows
            if(turn % 2 == 0){
                counter.setImageResource(R.drawable.red);
            }else{
                counter.setImageResource(R.drawable.yellow);
            }

            counter.setScaleX(0f);
            counter.setScaleY(0f);
            counter.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .rotation(360f)
                    .setDuration(500);
            turn++;

        }

    }

}
