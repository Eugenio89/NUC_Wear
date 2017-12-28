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




    public void buttonCalculations (View view){


        //************** Match Steps with Activity Factor Level ***********************************
        Integer stepsInteger = (int) (long) steps;

        if (stepsInteger <= 5000) {
            TextView tvActivity = (TextView) findViewById(R.id.textViewActivityLevel);
            tvActivity.setText("Sedentary");
        }
        else if (stepsInteger > 5000 && stepsInteger <= 6000){
            TextView tvActivity = (TextView) findViewById(R.id.textViewActivityLevel);
            tvActivity.setText("Lightly Active");
        }
        else if (stepsInteger > 6000 && stepsInteger <= 7000){
            TextView tvActivity = (TextView) findViewById(R.id.textViewActivityLevel);
            tvActivity.setText("Moderately Active");
        }
        else if (stepsInteger > 7000 && stepsInteger <= 8000){
            TextView tvActivity = (TextView) findViewById(R.id.textViewActivityLevel);
            tvActivity.setText("Very Active");
        }
        else if (stepsInteger > 8000){
            TextView tvActivity = (TextView) findViewById(R.id.textViewActivityLevel);
            tvActivity.setText("Extremely Active");
        }
        //*****************************************************************************************


//        Intent intent = new Intent(this, StepsActivity.class); //Esta era la buena
//        startActivity(intent);
    }




    public void recommendJuices (View view) {

        //******************** Open the Recommended Recipe List ***********************************
        Integer stepsInteger = (int) (long) steps;

        if (stepsInteger <= 5000) {
            Intent intent = new Intent(this, Sedentary.class); //Esta era la buena
            startActivity(intent);
        } else if (stepsInteger > 5000 && stepsInteger <= 6000) {
            Intent intent = new Intent(this, LightlyActive.class); //Esta era la buena
            startActivity(intent);
        } else if (stepsInteger > 6000 && stepsInteger <= 7000) {
            Intent intent = new Intent(this, ModeratelyActive.class); //Esta era la buena
            startActivity(intent);
        } else if (stepsInteger > 7000 && stepsInteger <= 8000) {
            Intent intent = new Intent(this, VeryActive.class); //Esta era la buena
            startActivity(intent);
        } else if (stepsInteger > 8000) {
            Intent intent = new Intent(this, ExtremelyActive.class); //Esta era la buena
            startActivity(intent);
        }
        //*****************************************************************************************
    }






}
