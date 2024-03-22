package ca.yorku.eecs.mack.demotiltball62467;

import static android.app.PendingIntent.getActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Stack;

public class ResultScreen extends Activity {


    private static final int RESULT_CLOSE_ALL = 1;
    private TextView laps;
    private TextView lap_time;
    private TextView wall_hits;
    private TextView pathperc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Log.i("MYDEBUG", "Got here! (result activity)");
        assert b != null;
        int lapsDone = b.getInt("laps_done", 0);
        double lapTime = b.getDouble("lap_time", 0);
        int wallHits = b.getInt("wall_hits", 0);
        double pathWidth = b.getDouble("path_width", 0);
        Log.i("MYDEBUG", "Got here! (setThings)");

        laps = (TextView) findViewById(R.id.lapNumberText);
        lap_time = (TextView) findViewById(R.id.lapTimeText);
        wall_hits = (TextView) findViewById(R.id.wallHitText);
        pathperc = (TextView) findViewById(R.id.percentInPathText);

        String lapTextDisplay = "Laps = " + lapsDone;
        laps.setText(lapTextDisplay);
        Log.i("MYDEBUG", "Got here! (laptime set)");

        String laptimeTextDisplay = String.format("Lap time = %.2fs (mean/lap)", lapTime);
        lap_time.setText(laptimeTextDisplay);
        Log.i("MYDEBUG", "Got here! (format success)");

        String wallhit = "Wall hits = " + wallHits;
        wall_hits.setText(wallhit);
        String pathpercText = String.format("In-path time = %.1f%%", pathWidth);
        Log.i("MYDEBUG", "Got here! (im never using string.format again)");
        pathperc.setText(pathpercText);
    }
    public void clickExit2(View view)
    {
        this.finish();//try activityname.finish instead of this
        Intent intent = new Intent(getApplicationContext(), DemoTiltBall62467Activity.class);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void clickSetup2(View view)
    {
        Intent i = new Intent(getApplicationContext(), DemoTiltBallSetup.class);
        startActivity(i);
    }}
