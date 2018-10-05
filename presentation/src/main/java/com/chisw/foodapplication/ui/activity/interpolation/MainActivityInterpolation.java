package com.chisw.foodapplication.ui.activity.interpolation;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Interpolator;
import android.widget.Spinner;
import android.widget.TextView;

import com.chisw.foodapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class MainActivityInterpolation extends Activity {

    @BindView(R.id.interpolator_spinner)Spinner interpolatorSpinner;
    @BindView(R.id.duration_spinner)Spinner duratorSpinner;
    @BindView(R.id.textView)TextView textView;

    private static final String PACKAGE = "android.view.animation.";
    private static final String PACKAGE_V4 = "android.support.v4.view.animation.";
    private int duration;
    private Interpolator interpolator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interpolation);
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnItemSelected({R.id.duration_spinner})
    void durationSelected(Spinner spinner, int position) {
        String durationString = (String) spinner.getAdapter().getItem(position);
        switch(durationString) {
            case "100ms":
                duration = 100;
            case "900ms":
                duration = 900;
                break;
            case "1500ms":
                duration = 1500;
                break;
            case "3000ms":
                duration = 3000;
                break;
            default:
                duration = 300;
                break;
        }
        // Kick off transition
        int item = interpolatorSpinner.getSelectedItemPosition();
        onItemSelected(interpolatorSpinner, position);
    }

    String findFullInterpolatorPath(String className) {
        if (className.equals("FastOutLinearInInterpolator")
                || className.equals("FastOutSlowInInterpolator")
                || className.equals("LinearOutSlowInInterpolator"))
            return PACKAGE_V4 + className;
        else if (className.startsWith("-"))
            return null;
        else return PACKAGE + className;
    }

    @OnItemSelected({R.id.interpolator_spinner})
    void onItemSelected(Spinner spinner, int position) {
        String interpolatorName = (String) spinner.getAdapter().getItem(position);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        textView.setTranslationY(metrics.heightPixels);

        try {
            String path = findFullInterpolatorPath(interpolatorName);
            if (path == null)
                return;

            interpolator = (Interpolator) Class.forName(path).newInstance();
            textView.animate().setInterpolator(interpolator)
                    .setDuration(duration)
                    .setStartDelay(500)
                    .translationYBy(-metrics.heightPixels)
                    .start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @OnItemSelected(value=R.id.interpolator_spinner, callback = OnItemSelected.Callback.NOTHING_SELECTED)
    void onNothingSelected() {

    }
}
