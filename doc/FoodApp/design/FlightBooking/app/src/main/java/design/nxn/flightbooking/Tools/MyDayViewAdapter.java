package design.nxn.flightbooking.Tools;

import android.view.LayoutInflater;
import android.view.View;

import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.DayViewAdapter;

import design.nxn.flightbooking.R;
import design.nxn.flightbooking.customfonts.MyTextView;

/**
 * Created by Attila on 5/7/2017.
 */

public class MyDayViewAdapter implements DayViewAdapter {
    @Override
    public void makeCellView(CalendarCellView parent) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_view_custom, null);
        parent.addView(layout);
        parent.setDayOfMonthTextView((MyTextView) layout.findViewById(R.id.day_view));
    }
}