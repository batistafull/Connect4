package activity.demot.connect4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ganador extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences prefs;
    private Button btnOtro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);
        getSupportActionBar().hide();
        SharedPreferences prefs = getSharedPreferences("Historial", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("puntuacion", "100");
        editor.commit();
        btnOtro = (Button) findViewById(R.id.btnOtra);
        btnOtro.setOnClickListener(this);
    }
    @Override
    public void onBackPressed (){
    }

    @Override
    public void onClick(View v) {
        int boton = v.getId();
        Intent intent = null;
        switch (boton){
            case R.id.btnOtra:
                intent = new Intent(this, MainActivity.class);
            break;
        }
        startActivity(intent);
    }
}
