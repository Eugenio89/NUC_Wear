package au.com.codeka.steptastic;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class LightlyActive extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightly_active);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }

    public void KaleJuice (View view){
        Intent intent = new Intent(this, JuiceKale.class);
        startActivity(intent);
    }

    public void SpinachJuice (View view){
        Intent intent = new Intent(this, JuiceSpinach.class);
        startActivity(intent);
    }

    public void MultivitaminJuice (View view){
        Intent intent = new Intent(this, JuiceMultivitamin.class);
        startActivity(intent);
    }

    public void PomegranateJuice (View view){
        Intent intent = new Intent(this, JuicePomegranate.class);
        startActivity(intent);
    }

    public void BellPepperJuice (View view){
        Intent intent = new Intent(this, JuiceBellPepper.class);
        startActivity(intent);
    }


}
