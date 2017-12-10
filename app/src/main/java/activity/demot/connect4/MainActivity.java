package activity.demot.connect4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton btnPlay;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imgportada);
        btnPlay = (ImageButton) findViewById(R.id.play);
        btnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int btnId = v.getId();
        Intent intent = null;
        switch (btnId){
            case R.id.play:
                intent = new Intent(this, Jugar.class);
            break;
        }
        startActivity(intent);
    }
}
