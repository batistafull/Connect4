package activity.demot.connect4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Puntuacion extends AppCompatActivity {
    SharedPreferences prefs;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);
        getSupportActionBar().hide();
        textView = (TextView) findViewById(R.id.text1);
        SharedPreferences prefs = getSharedPreferences("Historial", Context.MODE_PRIVATE);
        textView.setText(prefs.getString("puntuacion", ""));
    }

}
