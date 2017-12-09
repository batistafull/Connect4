package activity.demot.connect4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Jugar extends AppCompatActivity implements View.OnClickListener{


    private GridView gridView;
    private List<String> list;
    private int jugador;
    private String ficha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        jugador = 1;
        ((Button) findViewById(R.id.btn1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn7)).setOnClickListener(this);
        formarJuego();


    }
     public void formarJuego(){
         for(int i=0;i<42;i++){
             list.add("-");
         }
         adapter();
     }

     public void adapter(){
         gridView.setAdapter(new ArrayAdapter<>(this, R.layout.ficha_item, list));
     }

     public void actualizarJuego(int jugador, int fila){
         if(jugador == 1){
             this.ficha = "O";
             this.jugador = 2;
         }else{
             this.ficha = "X";
             this.jugador = 1;
         }

         if(list.get(fila+35).equals("-")) {
             list.set(fila + 35, this.ficha);
         }else if(list.get(fila+28).equals("-")){
             list.set(fila+28, this.ficha);
         }else if(list.get(fila+21).equals("-")){
            list.set(fila+21, this.ficha);
         }else if(list.get(fila+14).equals("-")){
             list.set(fila+14, this.ficha);
         }else if(list.get(fila+7).equals("-")){
             list.set(fila+7, this.ficha);
         }else if(list.get(fila).equals("-")){
             list.set(fila, this.ficha);
         }
         adapter();
     }

    public void verificarJuego(int fila, String jugador){
        int j = 0;
        for(int x = 35; x >= 0; x -= 7)
        if(((list.get(fila+x).equals(jugador)))) {
            j+=1;
            if(j == 4){
                Intent i = new Intent(this, Ganador.class);
                startActivity(i);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int btnId = v.getId();
        int fila = 0;
        switch (btnId){
            case R.id.btn1:
                fila = 0;
                actualizarJuego(this.jugador,fila);
                break;
            case R.id.btn2:
                fila = 1;
                actualizarJuego(this.jugador,fila);
                break;
            case R.id.btn3:
                fila = 2;
                actualizarJuego(this.jugador,fila);
                break;
            case R.id.btn4:
                fila = 3;
                actualizarJuego(this.jugador,fila);
                break;
            case R.id.btn5:
                fila = 4;
                actualizarJuego(this.jugador,fila);
                break;
            case R.id.btn6:
                fila = 5;
                actualizarJuego(this.jugador,fila);
                break;
            case R.id.btn7:
                fila = 6;
                actualizarJuego(this.jugador,fila);
                break;
        }
        verificarJuego(fila, this.ficha);
    }
}
