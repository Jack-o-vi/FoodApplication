package design.nxn.flightbooking.Tools;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import design.nxn.flightbooking.R;

/**
 * Created by Attila on 5/7/2017.
 */

public class CustomCalendarCell extends LinearLayout {

    public static final int RIGHT = 0;
    public static final int LEFT = 0;
    private int mDirection = RIGHT;

    public CustomCalendarCell(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public int getDirection() {
        return mDirection;
    }

    public void setDirection(int direction) {
        if (mDirection != direction) {
            mDirection = direction;
            refreshDrawableState();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if (direction == RIGHT) {
                setBackground(getResources().getDrawable(R.drawable.right_range));
            } else {
                setBackground(getResources().getDrawable(R.drawable.left_range));
            }
        }
    }

}
