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
         String ficha;
         if(jugador == 1){
             ficha = "O";
             this.jugador = 2;
         }else{
             ficha = "X";
             this.jugador = 1;
         }

         if(list.get(fila+35).equals("-")) {
             list.set(fila + 35, ficha);
         }else if(list.get(fila+28).equals("-")){
             list.set(fila+28, ficha);
         }else if(list.get(fila+21).equals("-")){
            list.set(fila+21, ficha);
         }else if(list.get(fila+14).equals("-")){
             list.set(fila+14, ficha);
         }else if(list.get(fila+7).equals("-")){
             list.set(fila+7, ficha);
         }else if(list.get(fila).equals("-")){
             list.set(fila, ficha);
         }else{
             //list.set(fila+35, "O");
         }
         adapter();
     }

    public void verificarJuego(int fila){
        if((list.get(fila+35).equals("O") &&
            list.get(fila+28).equals("O") &&
            list.get(fila+21).equals("O") &&
            list.get(fila+14).equals("O")) ||
           (list.get(fila+35).equals("X") &&
            list.get(fila+28).equals("X") &&
            list.get(fila+21).equals("X") &&
            list.get(fila+14).equals("X"))) {

            Intent i = new Intent(this, Ganador.class);
            startActivity(i);
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
        verificarJuego(fila);
    }
}
