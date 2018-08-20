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
    boolean isActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn = 0;
        LinearLayout layout = findViewById(R.id.playAgainLayout);
        layout.setTranslationY(-1000f);
    }

    public void dropInChip(View view){
        ImageView counter = (ImageView) view;

        // Getting item by tag
        int tappedBox = Integer.parseInt(counter.getTag().toString());

        // If the box tapped has not tapped before
        if(boxes[tappedBox] == 2 && isActive){

            // Set the tapped box to true to prevent being tapped again
            boxes[tappedBox] = turn;

            // If it's pair number puts the reds. Otherwise puts yellows
            if(turn == 0){
                counter.setImageResource(R.drawable.red);
                decideWinner("Red Won!",R.color.redColor);
                turn = 1;
            }else{
                counter.setImageResource(R.drawable.yellow);
                decideWinner("Yellow won!",R.color.yellowColor);
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
    public void decideWinner(String message, int color){

        for (int[] winPos : winPossibilities){
            if(     boxes[winPos[0]] == boxes[winPos[1]] &&
                    boxes[winPos[1]] == boxes[winPos[2]] &&
                    boxes[winPos[0]] != 2 ){

                // If someone wins the game becomes inactive
                isActive = false;

                // Set message in Layout
                TextView winnerMessage = findViewById(R.id.textWinner);
                winnerMessage.setText(message);

                // Show layout
                LinearLayout layout = findViewById(R.id.playAgainLayout);
                layout.setBackgroundColor(getResources().getColor(color));
                layout.setVisibility(View.VISIBLE);
                layout.animate().translationYBy(1000f).setDuration(500);
            }else{
                // When neither yellow nor red won
                boolean gameIsOver = true;

                // Only game is Over when the array boxes has values different of 2
                for(int boxState : boxes){
                    if(boxState == 2) gameIsOver = false;
                }
                if(gameIsOver){
                    // Set message in Layout
                    TextView winnerMessage = findViewById(R.id.textWinner);
                    winnerMessage.setText("It's a draw");

                    // Show layout
                    LinearLayout layout = findViewById(R.id.playAgainLayout);
                    layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    layout.animate().translationYBy(1000f).setDuration(500);
                    layout.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    // Reset the game
    public void playAgain(View view){
        LinearLayout layout = findViewById(R.id.playAgainLayout);
        layout.animate().translationYBy(-1000f).setDuration(500);
        layout.setVisibility(View.INVISIBLE);
        turn = 0;
        isActive = true;
        for(int i=0;i<boxes.length;i++){
            boxes[i] = 2;
        }
        GridLayout grid = findViewById(R.id.gridLayout);

        for(int i=0;i<grid.getChildCount();i++){
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }
    }
}
