package ca.yorku.eecs.mack.demotiltball62467;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class ResultScreen extends Activity {
    private int lapsDone;
    private String lapTime;
    private int wallHits;
    private double pathWidth;
    TextView laps;
    TextView lap_time;
    TextView wall_hits;
    TextView pathperc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();
        Bundle b = getIntent().getExtras();
        Log.i("messages", "got to resu");

        lapsDone = b.getInt("laps_done", 0);
        lapTime = b.getString("lap_time");
        wallHits = b.getInt("wall_hits", 0);
        pathWidth = b.getDouble("pathwidth", 0);


        laps = findViewById(R.id.lapNumberText);
        String laptext = "Laps = " + lapsDone;
        laps.setText(laptext);
        lap_time = findViewById(R.id.lapTimeText);
        Log.i("messages", "time = " + lapTime);
        String laptext2 = "Lap time = "+lapTime+"s (mean/lap)";
        lap_time.setText(laptext2);
        wall_hits = findViewById(R.id.wallHitText);
        String wallhitext = "Wall hits = " + wallHits;
        wall_hits.setText(wallhitext);
        pathperc = findViewById(R.id.percentInPathText);
        String pwid = String.format(Locale.CANADA,   "In-path time = %.1f%%", pathWidth);
        pathperc.setText(pwid);
    }

    public void clickExit2(View view)
    {
       // Intent intent = new Intent(Intent.ACTION_MAIN);
        Intent intent = new Intent(ResultScreen.this, DemoTiltBallSetup.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        //intent.addCategory(Intent.CATEGORY_HOME);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //clear activity stack
        startActivity(intent); //kill
        finish();
        System.exit(0);
    }
    public void clickSetup2(View view)
    {

        // start experiment activity
        Intent i = new Intent(ResultScreen.this, DemoTiltBallSetup.class);
        i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);
        finish();

        // comment out (return to setup after clicking BACK in main activity
        //finish();
    }
}
