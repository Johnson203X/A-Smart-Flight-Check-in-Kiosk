package ebu.groupone.iteration.Model;

import com.alibaba.fastjson.annotation.JSONField;
import ebu.groupone.iteration.BackEnd.BookingIO;
import ebu.groupone.iteration.Control.BookingDataControl;

import java.util.ArrayList;

/**
 * 
 * @author  ebu6304.groupone 
 * @version 5.0 2022/5/29 15:01
 */ 
public class Flight {
    /**
     * JSON Parameter FlightNumber
     */
    @JSONField(name = "FlightNumber")
    private String FlightNumber;
    /**
     * JSON Parameter Airways
     */
    @JSONField(name = "Airways")
    private String Airways;
    /**
     * JSON Parameter Departure
     */
    @JSONField(name = "Departure")
    private String Departure;
    /**
     * JSON Parameter Destination
     */
    @JSONField(name = "Destination")
    private String Destination;
    /**
     * JSON Parameter Gate
     */
    @JSONField(name = "Gate")
    private String Gate;
    /**
     * JSON Parameter DepartureTime
     */
    @JSONField(name = "DepartureTime")
    private String DepartureTime;
    /**
     * JSON Parameter PassengerList
     */
    @JSONField(name = "PassengerList")
    private String PassengerList;
    /**
     * JSON Parameter Percentage
     */
    @JSONField(name = "Percentage")
    private String Percentage;

    /**
     * Constructor without parameter
     */
    public Flight() {
        this.FlightNumber = "";
        this.Airways = "";
        this.Departure = "";
        this.Destination = "";
        this.Gate = "";
        this.DepartureTime = "";
        this.PassengerList = "";
        this.Percentage = "";
    }

    /**
     * Initializing a flight object
     * @param FlightNumber Input Parameter FlightNumber to target data
     */
    public void intialize(String FlightNumber) {
        this.FlightNumber = FlightNumber;
        this.Airways = "British Airways";
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> arrayList = bookingIO.SearchByFlightNumber(FlightNumber);
        Booking booking = (Booking) arrayList.get(0);
        this.Departure = booking.getDeparture();
        this.Destination = booking.getLocation();
        this.Gate = booking.getGate();
        this.DepartureTime = booking.getDepartureTime();
        BookingDataControl bookingDataControl = new BookingDataControl();
        this.PassengerList = bookingDataControl.getPassengerList_Status(FlightNumber);
        this.Percentage = bookingDataControl.getPassengerList_Percentage(FlightNumber);
    }

    /**
     * Getter for Parameter FlightNumber
     * @return String
     */
    public String getFlightNumber() {
        return FlightNumber;
    }
    /**
     * Setter for Parameter flightNumber
     * @param flightNumber Input Parameter flightNumber for targeting data
     */
    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }
    /**
     * Getter for Parameter Airways
     * @return String
     */
    public String getAirways() {
        return Airways;
    }
    /**
     * Setter for Parameter airways
     * @param airways Input Parameter airways for targeting data
     */
    public void setAirways(String airways) {
        Airways = airways;
    }
    /**
     * Getter for Parameter Departure
     * @return String
     */
    public String getDeparture() {
        return Departure;
    }
    /**
     * Setter for Parameter departure
     * @param departure Input Parameter departure for targeting data
     */
    public void setDeparture(String departure) {
        Departure = departure;
    }
    /**
     * Getter for Parameter Destination
     * @return String
     */
    public String getDestination() {
        return Destination;
    }
    /**
     * Setter for Parameter destination
     * @param destination Input Parameter destination for targeting data
     */
    public void setDestination(String destination) {
        Destination = destination;
    }
    /**
     * Getter for Parameter Gate
     * @return String
     */
    public String getGate() {
        return Gate;
    }
    /**
     * Setter for Parameter gate
     * @param gate Input Parameter gate for targeting data
     */
    public void setGate(String gate) {
        Gate = gate;
    }
    /**
     * Getter for Parameter DepartureTime
     * @return String
     */
    public String getDepartureTime() {
        return DepartureTime;
    }
    /**
     * Setter for Parameter departureTime
     * @param departureTime Input Parameter departureTime for targeting data
     */
    public void setDepartureTime(String departureTime) {
        DepartureTime = departureTime;
    }
    /**
     * Getter for Parameter PassengerList
     * @return String
     */
    public String getPassengerList() {
        return PassengerList;
    }
    /**
     * Setter for Parameter passengerList
     * @param passengerList Input Parameter passengerList for targeting data
     */
    public void setPassengerList(String passengerList) {
        PassengerList = passengerList;
    }
    /**
     * Getter for Parameter Percentage
     * @return String
     */
    public String getPercentage() {
        return Percentage;
    }
    /**
     * Setter for Parameter percentage
     * @param percentage Input Parameter percentage for targeting data
     */
    public void setPercentage(String percentage) {
        Percentage = percentage;
    }
}
