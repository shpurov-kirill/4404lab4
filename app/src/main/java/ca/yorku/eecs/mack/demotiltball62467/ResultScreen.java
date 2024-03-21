package ca.yorku.eecs.mack.demotiltball62467;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class ResultScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();
        int lapsDone = intent.getIntExtra("laps_done", 0);
        double lapTime = intent.getDoubleExtra("Lap_time", 0);
        int wallHits = intent.getIntExtra("wall_hits", 0);
        double pathWidth = intent.getDoubleExtra("pathWidth", 0);
        TextView laps = this.findViewById(R.id.lapNumberText);
        laps.setText("Laps = " + lapsDone);
        TextView lap_time = this.findViewById(R.id.lapTimeText);
        lap_time.setText(String.format("Lap time = %.2fs (mean/lap)", lapTime));
        TextView wall_hits = this.findViewById(R.id.wallHitText);
        wall_hits.setText("Wall hits = " + wallHits);
        TextView pathperc = this.findViewById(R.id.percentInPathText);
        pathperc.setText(String.format("In-path time = %.1f%", pathWidth));
    }
}
