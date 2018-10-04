package design.nxn.flightbooking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import design.nxn.flightbooking.Fragments.DateRangeFragment;
import design.nxn.flightbooking.Fragments.FlightListFragment;
import design.nxn.flightbooking.Fragments.MainFragment;
import design.nxn.flightbooking.Fragments.OverviewFragment;

public class MainActivity extends AppCompatActivity {
    private int[] airplane_images = {R.id.airplane_image_1, R.id.airplane_image_2, R.id.airplane_image_3, R.id.airplane_image_4};
    private int[] bigDots = {R.id.center_1, R.id.center_2, R.id.center_3, R.id.center_4};
    private int pageNumber = 0;
    private final int MAIN_FRAGMENT = 0;
    private final int DATE_RANGE_FRAGMENT = 1;
    private final int FLIGHT_LIST_FRAGMENT = 2;
    private final int OVERVIEW_FRAGMENT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAirplaneImages();
        if (pageNumber == airplane_images.length - 1) {
            findViewById(R.id.next_button).setVisibility(View.GONE);
        } else if (pageNumber == 0) {
            findViewById(R.id.back_button).setVisibility(View.GONE);
        }
        changeFragment(MAIN_FRAGMENT);
    }

    public void backClick(View view) {
        if (pageNumber > 0)
            pageNumber -= 1;
        initAirplaneImages();
        ((Button)findViewById(R.id.next_button)).setText(R.string.next);
        if (pageNumber == 0) {
            findViewById(R.id.back_button).setVisibility(View.GONE);
        }
        changeFragment(pageNumber);
    }

    public void nextClick(View view) {
        if (pageNumber < airplane_images.length - 1)
            pageNumber += 1;
        initAirplaneImages();
        findViewById(R.id.back_button).setVisibility(View.VISIBLE);
        if (pageNumber == airplane_images.length - 1) {
            ((Button)findViewById(R.id.next_button)).setText(R.string.pay);
        }
        changeFragment(pageNumber);
    }

    private void initAirplaneImages() {
        for (int i = 0; i < airplane_images.length; ++i) {
            if (i == pageNumber) {
                findViewById(airplane_images[i]).setVisibility(View.VISIBLE);
                findViewById(bigDots[i]).setVisibility(View.INVISIBLE);
            } else {
                findViewById(airplane_images[i]).setVisibility(View.GONE);
                findViewById(bigDots[i]).setVisibility(View.VISIBLE);
            }
        }
    }

    private void changeFragment(int fragmentType) {
        Fragment newFragment;
        switch (fragmentType) {
            case MAIN_FRAGMENT:
                newFragment = new MainFragment();
                break;
            case DATE_RANGE_FRAGMENT:
                newFragment = new DateRangeFragment();
                break;
            case FLIGHT_LIST_FRAGMENT:
                newFragment = new FlightListFragment();
                break;
            case OVERVIEW_FRAGMENT:
                newFragment = new OverviewFragment();
                break;
            default:
                newFragment = new MainFragment();
                break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, newFragment);
//        transaction.addToBackStack(null);

        transaction.commit();
    }
}
