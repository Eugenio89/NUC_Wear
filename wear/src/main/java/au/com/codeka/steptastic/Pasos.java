package au.com.codeka.steptastic;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

import static au.com.codeka.steptastic.StepsActivity.EXTRA_PASOS;
import static au.com.codeka.steptastic.StepsActivity.steps;


public class Pasos extends WearableActivity {


    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasos);


        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();



        //Desde aqui trato de recibir el numero de pasos
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String steps = extras.getString("EXTRA_PASOS");
        }
        //Hasta aqui




    }





    public void ObtenerPasos (View view){
    //Do something when the button is clicked

        TextView textView = findViewById(R.id.textViewPasos);
        //textView.setText("Hola");
        textView.setText(String.format("Steps: %d", steps));
        //textView.setText();

    }



}
