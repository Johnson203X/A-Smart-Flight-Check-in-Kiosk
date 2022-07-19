package ebu.groupone.iteration.Control;

import ebu.groupone.iteration.BackEnd.BookingIO;
import ebu.groupone.iteration.Model.Booking;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class of Manipulating the data stored in file, Top level services
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:19
 */
public class BookingDataControl {

    /**
     * Obtaining the Latest Data of given arrayList
     * @param arrayList Input param for processing the latest data
     * @return Booking
     */
    public Booking _GainLatestData(ArrayList<Object> arrayList) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_BookingTime = new Date();
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Booking HistoryBooking = (Booking) arrayList.get(i);
            int Result = 0;
            try {
                Result = Latest_BookingTime.compareTo(sdf.parse(HistoryBooking.getBookingTime()));
                if (Result == -1) {
                    index = i;
                    Latest_BookingTime = sdf.parse(HistoryBooking.getBookingTime());
                } else if (Result == 1) {
                    index = i;
                } else {
                    continue;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return (Booking) arrayList.get(index);
    }

    /**
     * Obtaining the Booking format Data with Param Surname
     * @param Surname Input param of the customer surname
     * @return Booking
     */
    public String _GetBookingNumber_WithSurname(String Surname) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchBySurname(Surname));
        return booking.getBookingNumber();
    }

    /**
     * Obtaining the Booking format Data with Param IDNumber
     * @param IDNumber Input param of the customer IDNumber
     * @return Booking
     */
    public String _GetBookingNumber_WithIDNumber(String IDNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByIDNumber(IDNumber));
        return booking.getBookingNumber();
    }

    /**
     * Obtaining customer's Surname with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetSurName(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getSurname();
    }

    /**
     * Obtaining customer's ID Number with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetIDNumber(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getIDNumber();
    }

    /**
     * Obtaining customer's Booking Time with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetBookingTime(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getBookingTime();
    }

    /**
     * Obtaining customer's Meal and Drink with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetMeal(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getMeal();
    }

    /**
     * Obtaining customer's Cabin and Seat with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetSeatClass(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getSeatClass();
    }

    /**
     * Obtaining customer's Destination Airport with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetLocation(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getLocation();
    }

    /**
     * Obtaining customer's Flight Number with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetFlightNumber(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getFlightNumber();
    }

    /**
     * Obtaining customer's Gate Info with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetGate(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getGate();
    }

    /**
     * Obtaining customer's Luggage Code with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetBelongings(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getBelongings();
    }

    /**
     * Obtaining customer's Check-in status with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetStatus(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getStatus();
    }

    /**
     * Obtaining customer's Departure Airport with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetDeparture(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getDeparture();
    }

    /**
     * Obtaining customer's Departure Time with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetDepartureTime(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getDepartureTime();
    }

    /**
     * Obtaining customer's Location on Plane with Param BookingNumber
     * @param BookingNumber Input param of the customer BookingNumber
     * @return String
     */
    public String _GetLocate(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        return booking.getLocate();
    }


    /**
     * Setting the Surname of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param SurName Input param of Setting Surname Content
     */
    public void _SetSurName(String BookingNumber, String SurName) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setSurname(SurName);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the IDNumber of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param IDNumber Input param of Setting IDNumber Content
     */
    public void _SetIDNumber(String BookingNumber, String IDNumber) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setIDNumber(IDNumber);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the BookingNumber of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     */
    public void _SetBookingTime(String BookingNumber) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the FlightNumber of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param FlightNumber Input param of Setting FlightNumber Content
     */
    public void _SetFlightNumber(String BookingNumber, String FlightNumber) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setFlightNumber(FlightNumber);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the Gate of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param Gate Input param of Setting Gate Content
     */
    public void _SetGate(String BookingNumber, String Gate) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setGate(Gate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the Belongings of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param Belongings Input param of Setting Belongings Content
     */
    public void _SetBelongings(String BookingNumber, String Belongings) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setBelongings(Belongings);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the Status of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param Status Input param of Setting Status Content
     */
    public void _SetStatus(String BookingNumber, String Status) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setStatus(Status);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the Meal of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param Meal Input param of Setting Meal Content
     */
    public void _SetMeal(String BookingNumber, String Meal) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setMeal(Meal);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the SeatClass of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param SeatClass Input param of Setting SeatClass Content
     */
    public void _SetSeatClass(String BookingNumber, String SeatClass) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setSeatClass(SeatClass);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the Location of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param Location Input param of Setting Location Content
     */
    public void _SetLocation(String BookingNumber, String Location) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setLocation(Location);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the Departure of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param Departure Input param of Setting Departure Content
     */
    public void _SetDeparture(String BookingNumber, String Departure) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setDeparture(Departure);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the DepartureTime of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param DepartureTime Input param of Setting DepartureTime Content
     */
    public void _SetDepartureTime(String BookingNumber, String DepartureTime) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setDeparture(DepartureTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }

    /**
     * Setting the Locate of Customer information with Input Param BookingNumber to find data
     * @param BookingNumber Input param of finding relevant target
     * @param Locate Input param of Setting Locate Content
     */
    public void _SetLocate(String BookingNumber, String Locate) {
        ArrayList<Object> array = new ArrayList<Object>();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingData = new BookingDataControl();
        Booking booking = bookingData._GainLatestData(bookingIO.SearchByBookingNumber(BookingNumber));
        booking.setLocate(Locate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        booking.setBookingTime(sdf.format(Latest_Update));
        array.add(booking);
        bookingIO.WriteOut(array);
    }


    /**
     * Obtaining the Flight List from all file data and returning in ArrayList of String format
     * @return ArrayList
     */
    public ArrayList<String> getFlightList() {
        ArrayList<String> return_list = new ArrayList<String>();
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> arrayList = bookingIO.ReadAll();
        for (int i = 0; i < arrayList.size(); i++) {
            Booking booking = (Booking) arrayList.get(i);
            String FlightNum = booking.getFlightNumber();
            if (!(FlightNum.equals("Null") || FlightNum.equals("Unsettled"))) {
                if (return_list.size() == 0) {
                    return_list.add(FlightNum);
                } else {
                    int token = 0;
                    for (int j = 0; j < return_list.size(); j++) {
                        if (FlightNum.equals(return_list.get(j))) {
                            token = 0;
                        } else {
                            token++;
                        }
                    }
                    if (token == return_list.size())
                        return_list.add(FlightNum);
                }
            }
        }
        return return_list;
    }

    /**
     * Obtaining the PassengerList_Status and returning in String format
     * @param FlightNumber Input param to locate the target flight data
     * @return String
     */
    public String getPassengerList_Status(String FlightNumber) {
        int CheckedNum = 0;
        int UncheckedNum = 0;
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> arrayList = bookingIO.SearchByFlightNumber(FlightNumber);
        ArrayList<Booking> duplicate_arrayList = new ArrayList<Booking>();
        for (int i = 0; i < arrayList.size(); i++) {
            Booking booking = (Booking) arrayList.get(i);
            Validation validation = new Validation();
            booking = validation.duplicateData(booking);
            boolean token = false;
            for (int j = 0; j < i; j++) {
                if (duplicate_arrayList.get(j).getBookingNumber().equals(booking.getBookingNumber())) {
                    token = true;
                }
            }
            duplicate_arrayList.add(booking);
            if (!token) {
                if (booking.getStatus().equals("Checked"))
                    CheckedNum++;
                else
                    UncheckedNum++;
            }
        }
        String return_String = Integer.toString(CheckedNum) + " / " + Integer.toString(CheckedNum + UncheckedNum);
        return return_String;
    }

    /**
     * Obtaining the getPassengerList_Percentage and returning in String format
     * @param FlightNumber Input param to locate the target flight data
     * @return String
     */
    public String getPassengerList_Percentage(String FlightNumber) {
        int CheckedNum = 0;
        int UncheckedNum = 0;
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> arrayList = bookingIO.SearchByFlightNumber(FlightNumber);
        ArrayList<Booking> duplicate_arrayList = new ArrayList<Booking>();
        for (int i = 0; i < arrayList.size(); i++) {
            Booking booking = (Booking) arrayList.get(i);
            Validation validation = new Validation();
            booking = validation.duplicateData(booking);
            boolean token = false;
            for (int j = 0; j < i; j++) {
                if (duplicate_arrayList.get(j).getBookingNumber().equals(booking.getBookingNumber())) {
                    token = true;
                }
            }
            duplicate_arrayList.add(booking);
            if (!token) {
                if (booking.getStatus().equals("Checked"))
                    CheckedNum++;
                else
                    UncheckedNum++;
            }
        }
        double percentage = ((double) CheckedNum) / ((double) (CheckedNum + UncheckedNum));
        double Zoom_percentage = percentage * 100;
        DecimalFormat df = new DecimalFormat("0");
        String return_String = df.format(Zoom_percentage) + "%";
        return return_String;
    }

}
