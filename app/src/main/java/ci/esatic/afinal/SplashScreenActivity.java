package ci.esatic.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent[] intents = new Intent[1];
                intents[0] = new Intent(getApplicationContext(), MainActivity.class);
                startActivities(intents);
                finish();
            }
        };
        new Handler().postDelayed(runnable , 3000);

    }
}