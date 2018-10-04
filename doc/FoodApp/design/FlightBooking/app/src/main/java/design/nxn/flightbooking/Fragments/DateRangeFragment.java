package design.nxn.flightbooking.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarPickerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import design.nxn.flightbooking.R;
import design.nxn.flightbooking.Tools.MyDecorator;
import design.nxn.flightbooking.Tools.MyTimeUtils;
import design.nxn.flightbooking.customfonts.FontConstants;
import design.nxn.flightbooking.customfonts.MyTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DateRangeFragment extends Fragment {
    private CalendarPickerView calendar;
    private ArrayList<Date> range;
    private MyTextView fromDate, toDate, daysNumber;

    public DateRangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_range, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        fromDate = (MyTextView) getView().findViewById(R.id.from_date);
        toDate = (MyTextView) getView().findViewById(R.id.to_date);
        daysNumber = (MyTextView) getView().findViewById(R.id.days_number);
        calendar = (CalendarPickerView) getView().findViewById(R.id.calendar_view);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())

                .inMode(CalendarPickerView.SelectionMode.RANGE);
        calendar.setTypeface(FontConstants.getfontNormal(getActivity()));
        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                range = (ArrayList<Date>) calendar.getSelectedDates();
                fromDate.setText(range.size()>0?(MyTimeUtils.formatDate(range.get(0).getTime(), MyTimeUtils.DATE_FORMAT, true)):"- -");
                toDate.setText(range.size()>0?(MyTimeUtils.formatDate(range.get(range.size() - 1).getTime(), MyTimeUtils.DATE_FORMAT, true)):"- -");
                daysNumber.setText(range.size() + "");
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
        calendar.setDecorators(Arrays.<CalendarCellDecorator>asList(new MyDecorator()));
    }
}
