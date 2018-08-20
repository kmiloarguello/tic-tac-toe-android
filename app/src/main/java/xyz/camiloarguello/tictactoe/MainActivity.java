package xyz.camiloarguello.tictactoe;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int turn;
    int[] boxes = {2,2,2,2,2,2,2,2,2};
    int[][] winPossibilities = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn = 0;
    }

    public void dropInChip(View view){
        ImageView counter = (ImageView) view;

        // Getting item by tag
        int tappedBox = Integer.parseInt(counter.getTag().toString());

        // If the box tapped has not tapped before
        if(boxes[tappedBox] == 2){

            // Set the tapped box to true to prevent being tapped again
            boxes[tappedBox] = turn;

            // If it's pair number puts the reds. Otherwise puts yellows
            if(turn == 0){
                counter.setImageResource(R.drawable.red);
                decideWinner("Red Won!");
                turn = 1;
            }else{
                counter.setImageResource(R.drawable.yellow);
                decideWinner("Yellow won!");
                turn = 0;
            }

            counter.setScaleX(0f);
            counter.setScaleY(0f);
            counter.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .rotation(360f)
                    .setDuration(500);

        }
    }
    public void decideWinner(String message){
        for (int[] winPos : winPossibilities){
            if(     boxes[winPos[0]] == boxes[winPos[1]] &&
                    boxes[winPos[1]] == boxes[winPos[2]] &&
                    boxes[winPos[0]] != 2 ){

                // Set message in Layout
                TextView winnerMessage = findViewById(R.id.textWinner);
                winnerMessage.setText(message);

                // Show layout
                LinearLayout layout = findViewById(R.id.playAgainLayout);
                layout.setVisibility(View.VISIBLE);

            }
        }
    }
    // Reset the game
    public void playAgain(View view){
        LinearLayout layout = findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        turn = 0;
        for(int i=0;i<boxes.length;i++){
            boxes[i] = 2;
        }
        GridLayout grid = findViewById(R.id.gridLayout);

        for(int i=0;i<grid.getChildCount();i++){
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }
    }
}
