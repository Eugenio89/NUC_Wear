package au.com.codeka.steptastic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Datos extends WearableActivity implements OnClickListener {

    private TextView mTextView;

//*********************
    EditText editText;
    EditText editText2;
    EditText editText3;
    Button button;
    RadioGroup radioGroup;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
//*********************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();

        //**************************************************
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);

        button = (Button) findViewById(R.id.Save);
        button.setOnClickListener(this);
        loadSavedPreferences();
        //***********************************************

    }

//**********************************************************************************************
        private void loadSavedPreferences() {
            SharedPreferences sharedPreferences = PreferenceManager
                    .getDefaultSharedPreferences(this);

            boolean radioButtonMaleValue = sharedPreferences.getBoolean("Male_Value", false);
            boolean radioButtonFemaleValue = sharedPreferences.getBoolean("Female_Value", false);

            String altura = sharedPreferences.getString("storedHeight", "Height (m)");
            editText.setText(altura);

            String peso = sharedPreferences.getString("storedWeight", "Weight (Kg)");
            editText2.setText(peso);

            String edad = sharedPreferences.getString("storedAge", "Age (Years)");
            editText3.setText(edad);

            if (radioButtonMaleValue) {
                radioButtonMale.setChecked(true); //revisaras esto
            } else {
                radioButtonMale.setChecked(false);
            }

            if (radioButtonFemaleValue) {
                radioButtonFemale.setChecked(true); //revisaras esto
            } else {
                radioButtonFemale.setChecked(false);
            }

        }
//***********************************************************************************************

    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }



    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }




//    public void OnClickSave (View view){
//
//
////************************************************************************************************
//        savePreferences("storedHeight", editText.getText().toString());
////************************************************************************************************
//
//        Intent intent = new Intent(this, StepsActivity.class); //Esta era la buena
//        startActivity(intent);
//    }

//**************************************************************************************************
    @Override
    public void onClick(View view) {
        savePreferences("storedHeight", editText.getText().toString());
        savePreferences("storedWeight", editText2.getText().toString());
        savePreferences("storedAge", editText3.getText().toString());

        savePreferences("Male_Value", radioButtonMale.isChecked());
        savePreferences("Female_Value", radioButtonFemale.isChecked());

        Intent intent = new Intent(this, StepsActivity.class);
        startActivity(intent);
    }
//**************************************************************************************************
}
