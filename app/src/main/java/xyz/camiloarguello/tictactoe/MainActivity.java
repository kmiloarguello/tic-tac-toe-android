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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView board = findViewById(R.id.board);

        // Adjusting the board with the chips
        board.setScaleY(.9f);
        board.setTranslationY(-85);

        // Starting chips with alpha
        ImageView red1 = findViewById(R.id.redChip);
        ImageView red2 = findViewById(R.id.redChip2);
        ImageView red3 = findViewById(R.id.redChip3);

        ImageView yellow1 = findViewById(R.id.yellowChip);
        ImageView yellow2 = findViewById(R.id.yellowChip2);
        ImageView yellow3 = findViewById(R.id.yellowChip3);

        red2.setAlpha(0f);
        red3.setAlpha(0f);
        yellow1.setAlpha(0f);
        yellow2.setAlpha(0f);
        yellow3.setAlpha(0f);

        red1.animate().alpha(1f).setDuration(500);

        makeToast("First turn for red!");

        turn = 1;
    }

    public void nextMovement(View view){

        EditText posX = findViewById(R.id.posXTextField);
        EditText posY = findViewById(R.id.posYTextField);

        ImageView red1 = findViewById(R.id.redChip);
        ImageView red2 = findViewById(R.id.redChip2);
        ImageView red3 = findViewById(R.id.redChip3);

        ImageView yellow1 = findViewById(R.id.yellowChip);
        ImageView yellow2 = findViewById(R.id.yellowChip2);
        ImageView yellow3 = findViewById(R.id.yellowChip3);

        if(posX.getText().toString().isEmpty() || posY.getText().toString().isEmpty()){
            makeToast("First, fill the positions X and Y!");
        }else{
            // The turn is based on pair and impair numbers
            // Pair numbers are turn for yellow
            // It's incrementing due each button click

            int iPosX = Integer.parseInt(posX.getText().toString());
            int iPosY = Integer.parseInt(posY.getText().toString());

            if( turn == 1){
                red1.animate()
                        .translationX(definePositionMovement(iPosX))
                        .translationY(definePositionMovement(iPosY))
                        .setDuration(1000);

                makeToast("Its turn for the yellow!");

            }else if(turn == 2){
                yellow1.animate().alpha(1f).setDuration(500);
                yellow1.animate()
                        .translationX(definePositionMovement(iPosX))
                        .translationY(definePositionMovement(iPosY))
                        .setDuration(1000);

                makeToast("Its turn for the red!");

            }else if(turn == 3){
                red2.animate().alpha(1f).setDuration(500);
                red2.animate()
                        .translationX(definePositionMovement(iPosX))
                        .translationY(definePositionMovement(iPosY))
                        .setDuration(1000);

                makeToast("Its turn for the yellow!");

            }else if(turn == 4){
                yellow2.animate().alpha(1f).setDuration(500);
                yellow2.animate()
                        .translationX(definePositionMovement(iPosX))
                        .translationY(definePositionMovement(iPosY))
                        .setDuration(1000);

                makeToast("Its turn for the red!");

            }else if(turn == 5){
                red3.animate().alpha(1f).setDuration(500);
                red3.animate()
                        .translationX(definePositionMovement(iPosX))
                        .translationY(definePositionMovement(iPosY))
                        .setDuration(1000);

                makeToast("Its turn for the yellow!");
            }else{
                yellow3.animate().alpha(1f).setDuration(500);
                yellow3.animate()
                        .translationX(definePositionMovement(iPosX))
                        .translationY(definePositionMovement(iPosY))
                        .setDuration(1000);

                makeToast("Finished!");
            }


            turn++;


            /*
            if(turn % 2 == 0) {
                makeToast("Yellow turn");
                yellow.animate()
                        .translationX(definePositionMovement(iPosX))
                        .translationY(definePositionMovement(iPosY))
                        .setDuration(1000);
            }else{
                makeToast("Red turn");
                red.animate()
                        .translationX(definePositionMovement(iPosX))
                        .translationY(definePositionMovement(iPosY))
                        .setDuration(1000);
            }
            */

        }
    }
    private float definePositionMovement(int userPos){
        if(userPos == 1){
            return 0.0f;
        }else if(userPos == 2){
            return 370.0f;
        }else if(userPos == 3){
            return 740.0f;
        }else{
            return 0.0f;
        }
    }
    public void makeToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
