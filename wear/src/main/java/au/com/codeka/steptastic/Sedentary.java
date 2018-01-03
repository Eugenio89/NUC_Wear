package au.com.codeka.steptastic;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class Sedentary extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sedentary);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();

    }

    public void buttonCelery (View view){
        Intent intent = new Intent(this, JuiceCelery.class);
        startActivity(intent);
    }

    public void buttonTomato (View view){
        Intent intent = new Intent(this, JuiceTomato.class);
        startActivity(intent);
    }

    public void buttonDreamyCarrot (View view){
        Intent intent = new Intent(this, JuiceDreamyCarrot.class);
        startActivity(intent);
    }


}
