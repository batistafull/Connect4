package activity.demot.connect4;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnPlay;
    private ImageView imageView;
    private TextView txt1;
    private ImageButton imgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imgportada);
        btnPlay = (ImageButton) findViewById(R.id.play);
        imgBtn = (ImageButton) findViewById(R.id.puntuacion);
        txt1 = (TextView) findViewById(R.id.acerca);
        txt1.setOnClickListener(this);
        imgBtn.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.music);
        mp.start();
        getSupportActionBar().hide();
    }

    @Override
    public void onClick(View v) {
        int btnId = v.getId();
        Intent intent = null;
        switch (btnId){
            case R.id.play:
                intent = new Intent(this, Jugar.class);
            break;
            case R.id.puntuacion:
                intent = new Intent(this, Puntuacion.class);
            break;
            case R.id.acerca:
                intent = new Intent(this, Acerca.class);
            break;
        }
        startActivity(intent);
    }
}
