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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropInChip(View view){
        ImageView counter = (ImageView) view;

        counter.setScaleX(0f);
        counter.setScaleY(0f);

        counter.setImageResource(R.drawable.red);

        counter.animate()
                .scaleX(1f)
                .scaleY(1f)
                .rotation(360f)
                .setDuration(500);
    }

}
