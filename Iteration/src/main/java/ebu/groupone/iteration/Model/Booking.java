package ebu.groupone.iteration.Model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author  ebu6304.groupone 
 * @version 5.0 2022/5/29 15:01
 */ 
public class Booking {
    /**
     * JSON Parameter BookingNumber
     */
    @JSONField(name = "Booking Number")
    private String BookingNumber;
    /**
     * JSON Parameter IDNumber
     */
    @JSONField(name = "ID Number")
    private String IDNumber;
    /**
     * JSON Parameter Surname
     */
    @JSONField(name = "Surname")
    private String Surname;
    /**
     * JSON Parameter BookingTime
     */
    @JSONField(name = "Booking Time")
    private String BookingTime;
    /**
     * JSON Parameter SeatClass
     */
    @JSONField(name = "SeatClass")
    private String SeatClass;
    /**
     * JSON Parameter Location
     */
    @JSONField(name = "Location")
    private String Location;
    /**
     * JSON Parameter Meal
     */
    @JSONField(name = "Meal")
    private String Meal;
    /**
     * JSON Parameter FlightNumber
     */
    @JSONField(name = "Flight Number")
    private String FlightNumber;
    /**
     * JSON Parameter Gate
     */
    @JSONField(name = "Gate")
    private String Gate;
    /**
     * JSON Parameter Belongings
     */
    @JSONField(name = "Belongings")
    private String Belongings;
    /**
     * JSON Parameter Departure
     */
    @JSONField(name = "Departure")
    private String Departure;
    /**
     * JSON Parameter DepartureTime
     */
    @JSONField(name = "DepartureTime")
    private String DepartureTime;
    /**
     * JSON Parameter Status
     */
    @JSONField(name = "Status")
    private String Status = "Unchecked";
    /**
     * JSON Parameter Locate
     */
    @JSONField(name = "Locate")
    private String Locate;


    /**
     * Constructor with 3 Parameters
     * @param BookingNumber Input Parameter BookingNumber
     * @param Surname Input Parameter Surname
     * @param IDNumber Input Parameter IDNumber
     */
    public Booking(String BookingNumber, String Surname, String IDNumber) {
        //super();
        this.BookingNumber = BookingNumber;
        this.Surname = Surname;
        this.IDNumber = IDNumber;
        this.BookingTime = "Unsettled";
        this.SeatClass = "Unsettled";
        this.Meal = "Unsettled";
        this.Location = "Unsettled";
        this.Gate = "Unsettled";
        this.Belongings = "Unsettled";
        this.FlightNumber = "Unsettled";
        this.Departure = "Unsettled";
        this.DepartureTime = "Unsettled";
        this.Status = "Unchecked";
        this.Locate = "Unsettles";
    }

    /**
     * Constructor with 14 Parameters
     * @param BookingNumber Input Parameter BookingNumber
     * @param Surname Input Parameter Surname
     * @param IDNumber Input Parameter IDNumber
     * @param BookingTime Input Parameter BookingTime
     * @param SeatClass Input Parameter SeatClass
     * @param Meal Input Parameter Meal
     * @param FlightNumber Input Parameter FlightNumber
     * @param Gate Input Parameter Gate
     * @param DepartureTime Input Parameter DepartureTime
     * @param Departure Input Parameter Departure
     * @param Location Input Parameter Location
     * @param Belongings Input Parameter Belongings
     * @param Status Input Parameter Status
     * @param Locate Input Parameter Locate
     */
    public Booking(String BookingNumber, String Surname, String IDNumber, String BookingTime, String SeatClass, String Meal, String FlightNumber, String Gate, String DepartureTime, String Departure, String Location, String Belongings, String Status, String Locate) {
        //super();
        this.BookingNumber = BookingNumber;
        this.Surname = Surname;
        this.IDNumber = IDNumber;
        this.BookingTime = BookingTime;
        this.SeatClass = SeatClass;
        this.Meal = Meal;
        this.FlightNumber = FlightNumber;
        this.Gate = Gate;
        this.DepartureTime = DepartureTime;
        this.Departure = Departure;
        this.Location = Location;
        this.Belongings = Belongings;
        this.Status = Status;
        this.Locate = Locate;
    }

    /**
     * Getter for Parameter BookingNumber
     * @return String
     */
    public String getBookingNumber() {
        return BookingNumber;
    }
    /**
     * Setter for Parameter bookingNumber
     * @param bookingNumber Input Parameter bookingNumber for targeting data
     */
    public void setBookingNumber(String bookingNumber) {
        BookingNumber = bookingNumber;
    }
    /**
     * Getter for Parameter IDNumber
     * @return String
     */
    public String getIDNumber() {
        return IDNumber;
    }
    /**
     * Setter for Parameter IDNumber
     * @param IDNumber Input Parameter IDNumber for targeting data
     */
    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }
    /**
     * Getter for Parameter Surname
     * @return String
     */
    public String getSurname() {
        return Surname;
    }
    /**
     * Setter for Parameter surname
     * @param surname Input Parameter surname for targeting data
     */
    public void setSurname(String surname) {
        Surname = surname;
    }
    /**
     * Getter for Parameter BookingTime
     * @return String
     */
    public String getBookingTime() {
        return BookingTime;
    }
    /**
     * Setter for Parameter bookingTime
     * @param bookingTime Input Parameter bookingTime for targeting data
     */
    public void setBookingTime(String bookingTime) {
        BookingTime = bookingTime;
    }
    /**
     * Getter for Parameter SeatClass
     * @return String
     */
    public String getSeatClass() {
        return SeatClass;
    }
    /**
     * Setter for Parameter seatClass
     * @param seatClass Input Parameter seatClass for targeting data
     */
    public void setSeatClass(String seatClass) {
        SeatClass = seatClass;
    }
    /**
     * Getter for Parameter Meal
     * @return String
     */
    public String getMeal() {
        return Meal;
    }
    /**
     * Setter for Parameter meal
     * @param meal Input Parameter meal for targeting data
     */
    public void setMeal(String meal) {
        Meal = meal;
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
     * Getter for Parameter Belongings
     * @return String
     */
    public String getBelongings() {
        return Belongings;
    }
    /**
     * Setter for Parameter belongings
     * @param belongings Input Parameter belongings for targeting data
     */
    public void setBelongings(String belongings) {
        Belongings = belongings;
    }
    /**
     * Getter for Parameter Location
     * @return String
     */
    public String getLocation() {
        return Location;
    }
    /**
     * Setter for Parameter location
     * @param location Input Parameter location for targeting data
     */
    public void setLocation(String location) {
        Location = location;
    }
    /**
     * Getter for Parameter Status
     * @return String
     */
    public String getStatus() {
        return Status;
    }
    /**
     * Setter for Parameter status
     * @param status Input Parameter status for targeting data
     */
    public void setStatus(String status) {
        Status = status;
    }
    /**
     * Getter for Parameter departureTime
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
     * Getter for Parameter departure
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
     * Getter for Parameter locate
     * @return String
     */
    public String getLocate() {
        return Locate;
    }
    /**
     * Setter for Parameter locate
     * @param locate Input Parameter locate for targeting data
     */
    public void setLocate(String locate) {
        Locate = locate;
    }
}

