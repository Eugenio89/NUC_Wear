package au.com.codeka.steptastic;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class ExtremelyActive extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extremely_active);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }

    public void PurpleCabbage (View view){
        Intent intent = new Intent(this, JuicePurpleCabbage.class);
        startActivity(intent);
    }

    public void Grape (View view){
        Intent intent = new Intent(this, JuiceGrape.class);
        startActivity(intent);
    }

    public void Orange (View view){
        Intent intent = new Intent(this, JuiceOrange.class);
        startActivity(intent);
    }
}
