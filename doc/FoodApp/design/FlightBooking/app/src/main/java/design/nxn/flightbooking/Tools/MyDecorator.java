package design.nxn.flightbooking.Tools;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;

import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarCellView;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Attila on 5/7/2017.
 */

public class MyDecorator implements CalendarCellDecorator {
    @Override
    public void decorate(CalendarCellView cellView, Date date) {
//        Calendar calendar = Calendar.getInstance();
//        Calendar nextYear = Calendar.getInstance();
//        nextYear.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        String dateString = Integer.toString(date.getDate());
//        Random random = new Random();
//        int price = random.nextInt(2000) + 10;
//        SpannableString string = new SpannableString(dateString + "\n" + price + "$");
//        string.setSpan(new RelativeSizeSpan(0.6f), dateString.length(), string.length(),
//                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        cellView.getDayOfMonthTextView().setText(dateString);
//        if (cellView.isCurrentMonth())
//            if (date.getTime() < calendar.getTimeInMillis()) {
//                cellView.getDayOfMonthTextView().setText(dateString);
//            } else {
//                if (date.getTime() > nextYear.getTimeInMillis()) {
//                    cellView.getDayOfMonthTextView().setText(dateString);
//                } else
//                    cellView.getDayOfMonthTextView().setText(string);
//            }
//        else {
//            cellView.getDayOfMonthTextView().setText(dateString);
//        }

    }

}