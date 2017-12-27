package au.com.codeka.steptastic;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }



    public void GetStartedButton (View view){
        Intent intent = new Intent(this, StepsActivity.class); //Esta era la buena
        startActivity(intent);
    }

    public void InsertDataButton (View view){
        Intent intent = new Intent(this, Datos.class); //Esta era la buena
        startActivity(intent);
    }



}
