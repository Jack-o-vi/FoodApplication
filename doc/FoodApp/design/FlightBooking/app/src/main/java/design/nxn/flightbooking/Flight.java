package design.nxn.flightbooking;

/**
 * Created by Attila on 5/12/2017.
 */

public class Flight {
    private int price;
    private int stops;

    private String depart_time;
    private String return_time;
    private String depart_time_2;
    private String return_time_2;

    private String airline_name = "";
    private String airline_code = "";
    private String airline_name_2 = "";
    private String airline_code_2 = "";

    private String duration;
    private String duration_2;

    private String depart_country = "";
    private String arrive_country = "";
    private String depart_country_2 = "";
    private String arrive_country_2 = "";

    private String depart_city_name = "";
    private String arrive_city_name = "";
    private String depart_city_name_2 = "";
    private String arrive_city_name_2 = "";

    private String depart_airport_name = "";
    private String arrive_airport_name = "";
    private String depart_airport_name_2 = "";
    private String arrive_airport_name_2 = "";
    private boolean selected = false;

    public Flight(int price, int stops, String depart_time, String return_time, String depart_time_2, String return_time_2, String airline_name, String airline_code, String airline_name_2, String airline_code_2, String duration, String duration_2, String depart_country, String arrive_country, String depart_country_2, String arrive_country_2, String depart_city_name, String arrive_city_name, String depart_city_name_2, String arrive_city_name_2, String depart_airport_name, String arrive_airport_name, String depart_airport_name_2, String arrive_airport_name_2) {
        this.price = price;
        this.stops = stops;
        this.depart_time = depart_time;
        this.return_time = return_time;
        this.depart_time_2 = depart_time_2;
        this.return_time_2 = return_time_2;
        this.airline_name = airline_name;
        this.airline_code = airline_code;
        this.airline_name_2 = airline_name_2;
        this.airline_code_2 = airline_code_2;
        this.duration = duration;
        this.duration_2 = duration_2;
        this.depart_country = depart_country;
        this.arrive_country = arrive_country;
        this.depart_country_2 = depart_country_2;
        this.arrive_country_2 = arrive_country_2;
        this.depart_city_name = depart_city_name;
        this.arrive_city_name = arrive_city_name;
        this.depart_city_name_2 = depart_city_name_2;
        this.arrive_city_name_2 = arrive_city_name_2;
        this.depart_airport_name = depart_airport_name;
        this.arrive_airport_name = arrive_airport_name;
        this.depart_airport_name_2 = depart_airport_name_2;
        this.arrive_airport_name_2 = arrive_airport_name_2;
    }

    public Flight() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public String getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(String depart_time) {
        this.depart_time = depart_time;
    }

    public String getReturn_time() {
        return return_time;
    }

    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }

    public String getDepart_time_2() {
        return depart_time_2;
    }

    public void setDepart_time_2(String depart_time_2) {
        this.depart_time_2 = depart_time_2;
    }

    public String getReturn_time_2() {
        return return_time_2;
    }

    public void setReturn_time_2(String return_time_2) {
        this.return_time_2 = return_time_2;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getAirline_code() {
        return airline_code;
    }

    public void setAirline_code(String airline_code) {
        this.airline_code = airline_code;
    }

    public String getAirline_name_2() {
        return airline_name_2;
    }

    public void setAirline_name_2(String airline_name_2) {
        this.airline_name_2 = airline_name_2;
    }

    public String getAirline_code_2() {
        return airline_code_2;
    }

    public void setAirline_code_2(String airline_code_2) {
        this.airline_code_2 = airline_code_2;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDuration_2() {
        return duration_2;
    }

    public void setDuration_2(String duration_2) {
        this.duration_2 = duration_2;
    }

    public String getDepart_country() {
        return depart_country;
    }

    public void setDepart_country(String depart_country) {
        this.depart_country = depart_country;
    }

    public String getArrive_country() {
        return arrive_country;
    }

    public void setArrive_country(String arrive_country) {
        this.arrive_country = arrive_country;
    }

    public String getDepart_country_2() {
        return depart_country_2;
    }

    public void setDepart_country_2(String depart_country_2) {
        this.depart_country_2 = depart_country_2;
    }

    public String getArrive_country_2() {
        return arrive_country_2;
    }

    public void setArrive_country_2(String arrive_country_2) {
        this.arrive_country_2 = arrive_country_2;
    }

    public String getDepart_city_name() {
        return depart_city_name;
    }

    public void setDepart_city_name(String depart_city_name) {
        this.depart_city_name = depart_city_name;
    }

    public String getArrive_city_name() {
        return arrive_city_name;
    }

    public void setArrive_city_name(String arrive_city_name) {
        this.arrive_city_name = arrive_city_name;
    }

    public String getDepart_city_name_2() {
        return depart_city_name_2;
    }

    public void setDepart_city_name_2(String depart_city_name_2) {
        this.depart_city_name_2 = depart_city_name_2;
    }

    public String getArrive_city_name_2() {
        return arrive_city_name_2;
    }

    public void setArrive_city_name_2(String arrive_city_name_2) {
        this.arrive_city_name_2 = arrive_city_name_2;
    }

    public String getDepart_airport_name() {
        return depart_airport_name;
    }

    public void setDepart_airport_name(String depart_airport_name) {
        this.depart_airport_name = depart_airport_name;
    }

    public String getArrive_airport_name() {
        return arrive_airport_name;
    }

    public void setArrive_airport_name(String arrive_airport_name) {
        this.arrive_airport_name = arrive_airport_name;
    }

    public String getDepart_airport_name_2() {
        return depart_airport_name_2;
    }

    public void setDepart_airport_name_2(String depart_airport_name_2) {
        this.depart_airport_name_2 = depart_airport_name_2;
    }

    public String getArrive_airport_name_2() {
        return arrive_airport_name_2;
    }

    public void setArrive_airport_name_2(String arrive_airport_name_2) {
        this.arrive_airport_name_2 = arrive_airport_name_2;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
