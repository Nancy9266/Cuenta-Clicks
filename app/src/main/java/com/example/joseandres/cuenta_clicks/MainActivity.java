package com.example.joseandres.cuenta_clicks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Button> botones;//Agrupamos nuestros botones.
    private List<TextView> contadores;//Agrupamos nuestros textviews.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rl_main = (RelativeLayout) findViewById(R.id.rl_main);
        botones = new ArrayList<>();
        contadores = new ArrayList<>();
        for (int i = 0; i < rl_main.getChildCount(); i++) {
            try {
                botones.add((Button) rl_main.getChildAt(i));
            } catch (Exception e) {
                contadores.add((TextView) rl_main.getChildAt(i));
            }
        }
        //View.OnClickListener: Para procesar notificaciones de click.
        botones.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            //La clase View define interfaces que deben cumplir los diferentes
            // tipos de Listeners.
            public void onClick(View v) {
                incrementar(contadores.get(0));
            }
        });
        //View.OnLongClickListener: Para procesar las notificaciones de click mantenido.
        botones.get(1).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return incrementar(contadores.get(1));
            }
        });
        //View.OnFocusChangeListener: Para procesar la adquisición o pérdida del foco.
        botones.get(2).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                incrementar(contadores.get(2));
            }
        });
        //View.OnKeyListener: Para procesar las pulsaciones de teclas físicas
        // del dispositivo. Sólo se reciben estas notificaciones si el elemento
        // tiene el foco mientras se realiza la pulsación.
        botones.get(3).setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return incrementar(contadores.get(3));
            }
        });
        //View.OnTouchListener: Cuando el usuario toca, pulsando o liberando, un elemento.
        botones.get(4).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return incrementar(contadores.get(4));
            }
        });
    }
    private boolean incrementar(TextView tv) {
        tv.setText(String.valueOf(1 + Integer.valueOf(tv.getText().toString())));
        return true;
    }
}
