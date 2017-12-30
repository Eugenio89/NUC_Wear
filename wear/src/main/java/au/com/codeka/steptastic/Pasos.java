package au.com.codeka.steptastic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.CollationElementIterator;
import java.text.DecimalFormat;

import static au.com.codeka.steptastic.StepsActivity.EXTRA_PASOS;
import static au.com.codeka.steptastic.StepsActivity.steps;


public class Pasos extends WearableActivity {


    //***************************************************************************************



    //***************************************************************************************

//    final long initialStepsNoChange = steps;


    private TextView mTextView;
    boolean aux = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasos);


        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();

        long realSteps = 0;
        TextView textView = findViewById(R.id.textViewPasos);
        textView.setText(String.format("Steps: %d", realSteps));


        //Desde aqui trato de recibir el numero de pasos
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String steps = extras.getString("EXTRA_PASOS");
        }
        //Hasta aqui

        //final long initialStepsNoChange = steps;



//************************************RESET********************************************************
        final Button button = findViewById(R.id.ResetSteps);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                aux = false;

                long realSteps = 0;
                TextView textView = findViewById(R.id.textViewPasos);
                textView.setText(String.format("Steps: %d", realSteps));

            }
        });

//***********************************START*********************************************************
        final Button button2 = findViewById(R.id.StartWalk);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                aux = true;
                final long initialStepsNoChange = steps;
                TextView textView = findViewById(R.id.textViewPasos);



                        final Handler handler =new Handler();
                        final Runnable r1 = new Runnable() {
                            public void run()
                            {
                                if (aux == true) {
                                    handler.postDelayed(this, 1000);

                                    long realSteps = steps - initialStepsNoChange;

                                    TextView textView = findViewById(R.id.textViewPasos);
                                    textView.setText(String.format("Steps: %d", realSteps));

                                    if (aux == false) {

                                        realSteps = 0;
                                        textView.setText(String.format("Steps: %d", realSteps));

                                        handler.removeCallbacks(null);
                                        handler.removeCallbacksAndMessages(null);
                                        Pasos.super.onStop();

                                    }
                                }
                            }
                        };
                        handler.postDelayed(r1, 0000);


                    if (aux == false) {
                        long realSteps = 0;
                        //TextView textView = findViewById(R.id.textViewPasos);
                        textView.setText(String.format("Steps: %d", realSteps));
                        Pasos.super.onStop();
                    }



            }
        });
//**************************************************************************************************


    }




//*****************Update Number of Steps when the Button is Clicked********************************

//    public void ObtenerPasos (View view) {
    //Do something when the button is clicked

    //TextView textView = findViewById(R.id.textViewPasos);
    //textView.setText(String.format("Steps: %d", steps));


//        final long initialStepsNoChange = steps;
//
//
//
//        while (aux = false)
//        {
//            long realSteps = steps - initialStepsNoChange;
//
//            TextView textView = findViewById(R.id.textViewPasos);
//            textView.setText(String.format("Steps: %d", realSteps));
//
//
//        }


//        final Handler handler =new Handler();
//        final Runnable r1 = new Runnable() {
//            public void run()
//            {
//                handler.postDelayed(this, 1000);

//                long realSteps = steps - initialStepsNoChange;
//
//                TextView textView = findViewById(R.id.textViewPasos);
//                textView.setText(String.format("Steps: %d", realSteps));


//            }
//        };
//        handler.postDelayed(r1, 0000);
//
//    }
//**************************************************************************************************







//    public void ResetSteps (View view){
//        //Do something on Reset Button CLick
//
//                final Handler handler =new Handler();
//                handler.removeCallbacksAndMessages(null);
//
//                long realSteps = 0;
//
//                TextView textView = findViewById(R.id.textViewPasos);
//                textView.setText(String.format("Steps: %d", realSteps));
//
//    }
//**************************************************************************************************


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





        //**************** Perform Medical Indices Calculations ***********************************

        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        boolean radioButtonMaleValue = sharedPreferences.getBoolean("Male_Value", false);
        boolean radioButtonFemaleValue = sharedPreferences.getBoolean("Female_Value", false);

        String altura = sharedPreferences.getString("storedHeight", "Height (m)");

//        editText.setText(altura);

        String peso = sharedPreferences.getString("storedWeight", "Weight (Kg)");
//        editText2.setText(peso);

        String edad = sharedPreferences.getString("storedAge", "Age (Years)");
//        editText3.setText(edad);

//        if (radioButtonMaleValue) {
////            radioButtonMale.setChecked(true); //revisaras esto
//        } else {
////            radioButtonMale.setChecked(false);
//        }
//
//        if (radioButtonFemaleValue) {
////            radioButtonFemale.setChecked(true); //revisaras esto
//        } else {
////            radioButtonFemale.setChecked(false);
//        }


        //*************************BMI*************************************************************

        TextView tvBMI = (TextView) findViewById(R.id.textViewBMI);

        double bmi;
        double pesoDouble;
        double alturaDouble;

        pesoDouble = Double.parseDouble(peso);
        alturaDouble = Double.parseDouble(altura);

        bmi = pesoDouble/(alturaDouble * alturaDouble);
        tvBMI.setText(new DecimalFormat("##.###").format(bmi));
        //tvBMI.setText(Double.toString(bmi));

        //*********************************BMR*****************************************************

        TextView tvBMR = (TextView) findViewById(R.id.textViewBMR);
//
        double bmr;
        double edadDouble;
        double tdee;
//
        pesoDouble = Double.parseDouble(peso);
        alturaDouble = Double.parseDouble(altura);
        edadDouble = Double.parseDouble(edad);
//
//        bmr = (10*pesoDouble) + (6.25 * alturaDouble * 100) - (5 * edadDouble) + 5;
//        tvBMR.setText(new DecimalFormat("##.###").format(bmr));

        //****************************Check Radio Buttons******************************************

        if (radioButtonMaleValue) {
            bmr = (10*pesoDouble) + (6.25 * alturaDouble * 100) - (5 * edadDouble) + 5;
            tvBMR.setText(new DecimalFormat("##.###").format(bmr));

            //TDEE Depend on Activity Factor (Number of Steps)
            //**************************************************************************************

            TextView tvTDEE = (TextView) findViewById(R.id.textViewTDEE);

            if (stepsInteger <= 5000) {
                tdee = bmr * 1.2;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            else if (stepsInteger > 5000 && stepsInteger <= 6000){
                tdee = bmr * 1.375;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            else if (stepsInteger > 6000 && stepsInteger <= 7000){
                tdee = bmr * 1.55;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            else if (stepsInteger > 7000 && stepsInteger <= 8000){
                tdee = bmr * 1.752;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            else if (stepsInteger > 8000){
                tdee = bmr * 1.9;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            //**************************************************************************************



        } else {

        }

        if (radioButtonFemaleValue) {
            bmr = (10*pesoDouble) + (6.25 * alturaDouble * 100) - (5 * edadDouble) - 161;
            tvBMR.setText(new DecimalFormat("##.###").format(bmr));

            //TDEE Depend on Activity Factor (Number of Steps)
            //**************************************************************************************

            TextView tvTDEE = (TextView) findViewById(R.id.textViewTDEE);

            if (stepsInteger <= 5000) {
                tdee = bmr * 1.2;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            else if (stepsInteger > 5000 && stepsInteger <= 6000){
                tdee = bmr * 1.375;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            else if (stepsInteger > 6000 && stepsInteger <= 7000){
                tdee = bmr * 1.55;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            else if (stepsInteger > 7000 && stepsInteger <= 8000){
                tdee = bmr * 1.752;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            else if (stepsInteger > 8000){
                tdee = bmr * 1.9;
                tvTDEE.setText(new DecimalFormat("##.###").format(tdee));
            }
            //**************************************************************************************

        } else {

        }

        //*****************************************************************************************


        //*************************************TDEE************************************************

//        tdee = bmr * 1.2;
//        tvTDEE.setText(new DecimalFormat("##.###").format(tdee));

    }



//*************************************************************************************************

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
