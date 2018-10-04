package design.nxn.flightbooking.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import design.nxn.flightbooking.R;
import design.nxn.flightbooking.customfonts.FontConstants;
import design.nxn.flightbooking.customfonts.MyTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private ImageView rightArrow, leftArrow;
    private int[] classTypeRadiobuttons = {R.id.economy_check, R.id.premium_economy_check, R.id.business_class_check, R.id.first_class_check};
    private MyTextView adultText, childText, infantText;
    private LinearLayout adultSubb, adultAdd, childSubb, childAdd, infantSubb, infantAdd;
    private int adultNumber = 1;
    private int childNumer = 0;
    private int infantNumber = 0;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rightArrow = (ImageView) getView().findViewById(R.id.right_arrow);
        leftArrow = (ImageView) getView().findViewById(R.id.left_arrow);
        ((CheckBox) getView().findViewById(R.id.round_trip_check)).setTypeface(FontConstants.getfontNormal(getActivity()));
        ((CheckBox) getView().findViewById(R.id.round_trip_check)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    leftArrow.setVisibility(View.VISIBLE);
                    LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dpToPx(20));
                    llp.setMargins(0, 0, 0, dpToPx(-5));
                    LinearLayout.LayoutParams llp2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dpToPx(20));
                    llp2.setMargins(0, dpToPx(-5), 0, 0);
                    leftArrow.setLayoutParams(llp2);
                    rightArrow.setLayoutParams(llp);
                } else {
                    leftArrow.setVisibility(View.GONE);
                    LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, dpToPx(20));
                    llp.setMargins(0, 0, 0, 0);
                    rightArrow.setLayoutParams(llp);
                }
            }
        });
        initClassRadiobuttons();
        initPersonconfiguration();
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private void initClassRadiobuttons() {
        for (int i = 0; i < classTypeRadiobuttons.length; ++i) {
            ((RadioButton) getView().findViewById(classTypeRadiobuttons[i])).setTypeface(FontConstants.getfontNormal(getActivity()));
            final int finalI = i;
            ((RadioButton) getView().findViewById(classTypeRadiobuttons[i])).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        for (int j = 0; j < classTypeRadiobuttons.length; ++j) {
                            if (j != finalI) {
                                ((RadioButton) getView().findViewById(classTypeRadiobuttons[j])).setChecked(false);
                            }
                        }
                    }
                }
            });
        }
    }

    private void initPersonconfiguration() {

        adultText = (MyTextView) getView().findViewById(R.id.adult_number_text);
        childText = (MyTextView) getView().findViewById(R.id.child_number_text);
        infantText = (MyTextView) getView().findViewById(R.id.infant_number_text);
        adultSubb = (LinearLayout) getView().findViewById(R.id.adult_subb);
        adultAdd = (LinearLayout) getView().findViewById(R.id.adult_add);
        childSubb = (LinearLayout) getView().findViewById(R.id.child_subb);
        childAdd = (LinearLayout) getView().findViewById(R.id.child_add);
        infantSubb = (LinearLayout) getView().findViewById(R.id.infant_subb);
        infantAdd = (LinearLayout) getView().findViewById(R.id.infant_add);
        adultSubb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adultNumber > 1) {
                    --adultNumber;
                    adultText.setText(adultNumber + "");
                }
            }
        });
        adultAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adultNumber < 7) {
                    ++adultNumber;
                    adultText.setText(adultNumber + "");
                }
            }
        });
        childSubb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (childNumer > 0) {
                    --childNumer;
                    childText.setText(childNumer + "");
                }
            }
        });
        childAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (childNumer < 5) {
                    ++childNumer;
                    childText.setText(childNumer + "");
                }
            }
        });
        infantSubb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (infantNumber > 0) {
                    --infantNumber;
                    infantText.setText(infantNumber + "");
                }
            }
        });
        infantAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (infantNumber < 5) {
                    ++infantNumber;
                    infantText.setText(infantNumber + "");
                }
            }
        });
    }
}
