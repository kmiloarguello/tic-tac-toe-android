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

        turn = 1;
    }

    public void nextMovement(View view){

        EditText posX = findViewById(R.id.posXTextField);
        EditText posY = findViewById(R.id.posYTextField);
        ImageView red = findViewById(R.id.redChip);
        ImageView yellow = findViewById(R.id.yellowChip);

        if(posX.getText().toString().isEmpty() || posY.getText().toString().isEmpty()){
            makeToast("First, fill the positions X and Y!");
        }else{
            // The turn is based on pair and impair numbers
            // Pair numbers are turn for yellow
            // It's incrementing due each button click
            turn++;

            int iPosX = Integer.parseInt(posX.getText().toString());
            int iPosY = Integer.parseInt(posY.getText().toString());

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
