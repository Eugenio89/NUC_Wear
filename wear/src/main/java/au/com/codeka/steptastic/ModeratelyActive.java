package au.com.codeka.steptastic;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.TextView;

public class ModeratelyActive extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moderately_active);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }

    public void AppleJuice (View view){
        Intent intent = new Intent(this, JuiceApple.class);
        startActivity(intent);
    }

    public void WheatgrassJuice (View view){
        Intent intent = new Intent(this, JuiceWheatgrass.class);
        startActivity(intent);
    }

    public void CelebCeleryJuice (View view){
        Intent intent = new Intent(this, JuiceCelebCelery.class);
        startActivity(intent);
    }

    public void PearJuice (View view){
        Intent intent = new Intent(this, JuicePear.class);
        startActivity(intent);
    }


}
