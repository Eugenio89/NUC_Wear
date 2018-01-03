package au.com.codeka.steptastic;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class VeryActive extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_very_active);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }

    public void BabySpinach (View view){
        Intent intent = new Intent(this, JuiceBabySpinach.class);
        startActivity(intent);
    }

    public void Carrot (View view){
        Intent intent = new Intent(this, JuiceCarrot.class);
        startActivity(intent);
    }

    public void Cabbage (View view){
        Intent intent = new Intent(this, JuiceCabbage.class);
        startActivity(intent);
    }

    public void DetoxGreen (View view){
        Intent intent = new Intent(this, JuiceDetoxGreen.class);
        startActivity(intent);
    }

    public void TangyTomato (View view){
        Intent intent = new Intent(this, JuiceTangyTomato.class);
        startActivity(intent);
    }

    public void CarrotAndCelery (View view){
        Intent intent = new Intent(this, JuiceCarrotAndCelery.class);
        startActivity(intent);
    }

}
