package design.nxn.flightbooking.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import design.nxn.flightbooking.Flight;
import design.nxn.flightbooking.R;
import design.nxn.flightbooking.Tools.CheckableLinearLayout;
import design.nxn.flightbooking.customfonts.MyTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FlightListFragment extends Fragment {
    private LinearLayout lisLayout;
    private ArrayList<View> views;

    public FlightListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flight_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        views = new ArrayList<>();
        lisLayout = (LinearLayout) getView().findViewById(R.id.list_layout);
        views.add(getSticky(R.string.cheapest));
        views.add(getView(new Flight()));
        views.add(getSticky(R.string.fastest));
        views.add(getView(new Flight()));
        views.add(getSticky(R.string.all_flights));
        views.add(getView(new Flight()));
//        views.add(getView(new Flight()));
//        views.add(getView(new Flight()));
        for (View vw : views) {
            lisLayout.addView(vw);
        }
    }

    private View getView(Flight flight) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View v = inflater.inflate(R.layout.flight_list_item, null);
//        ((MyTextView) v.findViewById(R.id.price_text)).setText(flight.getPrice() + "$");
//        ((MyTextView) v.findViewById(R.id.stops_text)).setText(flight.getStops() + "");
//        ((MyTextView) v.findViewById(R.id.start_city_name)).setText(flight.getDepart_city_name());
//        ((MyTextView) v.findViewById(R.id.start_city_name_2)).setText(flight.getDepart_city_name_2());
//        ((MyTextView) v.findViewById(R.id.start_shorted_city_name)).setText(flight.getDepart_country());
//        ((MyTextView) v.findViewById(R.id.start_shorted_city_name_2)).setText(flight.getDepart_country_2());
//        ((MyTextView) v.findViewById(R.id.start_airport_name)).setText(flight.getDepart_airport_name());
//        ((MyTextView) v.findViewById(R.id.start_airport_name_2)).setText(flight.getDepart_airport_name_2());
//        ((MyTextView) v.findViewById(R.id.start_time_text)).setText(flight.getDepart_time());
//        ((MyTextView) v.findViewById(R.id.start_time_text_2)).setText(flight.getDepart_time_2());
        (v.findViewById(R.id.checkable_layout)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (View vw : views) {
                    try {
                        ((CheckableLinearLayout) vw.findViewById(R.id.checkable_layout)).setChecked(false);
                        ((MyTextView)vw.findViewById(R.id.selected)).setVisibility(View.GONE);
                    } catch (Exception e) {

                    }
                    ((CheckableLinearLayout) view).setChecked(true);
                    ((MyTextView)v.findViewById(R.id.selected)).setVisibility(View.VISIBLE);
                }
            }
        });
        return v;
    }

    private View getSticky(int textId) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View v = inflater.inflate(R.layout.flight_list_sticky, null);
        ((MyTextView) v.findViewById(R.id.title)).setText(getString(textId));
//        ((MyTextView) v.findViewById(R.id.stops_text)).setText(flight.getStops() + "");
//        ((MyTextView) v.findViewById(R.id.start_city_name)).setText(flight.getDepart_city_name());
//        ((MyTextView) v.findViewById(R.id.start_city_name_2)).setText(flight.getDepart_city_name_2());
//        ((MyTextView) v.findViewById(R.id.start_shorted_city_name)).setText(flight.getDepart_country());
//        ((MyTextView) v.findViewById(R.id.start_shorted_city_name_2)).setText(flight.getDepart_country_2());
//        ((MyTextView) v.findViewById(R.id.start_airport_name)).setText(flight.getDepart_airport_name());
//        ((MyTextView) v.findViewById(R.id.start_airport_name_2)).setText(flight.getDepart_airport_name_2());
//        ((MyTextView) v.findViewById(R.id.start_time_text)).setText(flight.getDepart_time());
//        ((MyTextView) v.findViewById(R.id.start_time_text_2)).setText(flight.getDepart_time_2());
        return v;
    }
}
