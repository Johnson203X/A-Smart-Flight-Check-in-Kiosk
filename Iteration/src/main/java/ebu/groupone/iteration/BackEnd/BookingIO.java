package ebu.groupone.iteration.BackEnd;

import ebu.groupone.iteration.Model.Booking;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class of handling the IO of Booking format Data, the highest level
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:20
 */ 
public class BookingIO {

    /**
     * Filepath to the storage file
     */
    private final String filePath = "Data/file.json";

    /**
     * Return all the in file data in ArrayList form which BookingNumber equals to param
     * @param BookingNumber Search Param BookingNumber
     * @return ArrayList
     */
    public ArrayList<Object> SearchByBookingNumber(String BookingNumber) {
        JsonIO jsonIO = new JsonIO();
        ArrayList<Object> WriteOutArray = new ArrayList<Object>();
        ArrayList<Object> ReadInArray = jsonIO.ReadIn(filePath, Booking.class);
        for (int i = 0; i < ReadInArray.size(); i++) {
            Booking booking = (Booking) ReadInArray.get(i);
            if (booking.getBookingNumber().equals(BookingNumber)) {
                WriteOutArray.add(booking);
            }
        }
        return WriteOutArray;
    }

    /**
     * Return all the in file data in ArrayList form which Surname equals to param
     * @param Surname Search Param Surname
     * @return ArrayList
     */
    public ArrayList<Object> SearchBySurname(String Surname) {
        JsonIO jsonIO = new JsonIO();
        ArrayList<Object> WriteOutArray = new ArrayList<Object>();
        ArrayList<Object> ReadInArray = jsonIO.ReadIn(filePath, Booking.class);
        for (int i = 0; i < ReadInArray.size(); i++) {
            Booking booking = (Booking) ReadInArray.get(i);
            if (booking.getSurname().equals(Surname)) {
                WriteOutArray.add(booking);
            }
        }
        return WriteOutArray;
    }

    /**
     * Return all the in file data in ArrayList form which IDNumber equals to param
     * @param IDNumber Search Param IDNumber
     * @return ArrayList
     */
    public ArrayList<Object> SearchByIDNumber(String IDNumber) {
        JsonIO jsonIO = new JsonIO();
        ArrayList<Object> WriteOutArray = new ArrayList<Object>();
        ArrayList<Object> ReadInArray = jsonIO.ReadIn(filePath, Booking.class);
        for (int i = 0; i < ReadInArray.size(); i++) {
            Booking booking = (Booking) ReadInArray.get(i);
            if (booking.getIDNumber().equals(IDNumber)) {
                WriteOutArray.add(booking);
            }
        }
        return WriteOutArray;
    }

    /**
     * Return all the in file data in ArrayList form which FlightNumber equals to param
     * @param FlightNumber Search Param FlightNumber
     * @return ArrayList
     */
    public ArrayList<Object> SearchByFlightNumber(String FlightNumber) {
        JsonIO jsonIO = new JsonIO();
        ArrayList<Object> WriteOutArray = new ArrayList<Object>();
        ArrayList<Object> ReadInArray = jsonIO.ReadIn(filePath, Booking.class);
        for (int i = 0; i < ReadInArray.size(); i++) {
            Booking booking = (Booking) ReadInArray.get(i);
            if (booking.getFlightNumber().equals(FlightNumber)) {
                WriteOutArray.add(booking);
            }
        }
        return WriteOutArray;
    }

    /**
     * Return all the in file data in ArrayList form
     * @return ArrayList
     */
    public ArrayList<Object> ReadAll() {
        JsonIO jsonIO = new JsonIO();
        ArrayList<Object> WriteOutArray = new ArrayList<Object>();
        ArrayList<Object> ReadInArray = jsonIO.ReadIn(filePath, Booking.class);
        for (int i = 0; i < ReadInArray.size(); i++) {
            Booking booking = (Booking) ReadInArray.get(i);
            WriteOutArray.add(booking);
        }
        return WriteOutArray;
    }

    /**
     * @param OutputArray Add the output array to the back of the storage file
     */
    public void WriteOut(ArrayList<Object> OutputArray) {
        JsonIO jsonIO = new JsonIO();
        ArrayList<Object> arrayList = jsonIO.ReadIn(filePath, Booking.class);
        for (int i = 0; i < OutputArray.size(); i++) {
            arrayList.add(OutputArray.get(i));
        }
        jsonIO.WriteOut(filePath, arrayList);
    }

    /**
     * Clear all the data in file, and create token data with setting the default value to Null
     */
    public void Clear() {
        try {
            FileIO.write(filePath, "[{\"Booking Number\":\"Null\",\"DepartureTime\":\"Null\",\"Belongings\"" +
                    ":\"Null\",\"Departure\":\"Null\",\"ID Number\":\"Null\",\"Meal\":\"Null\",\"Gate\":\"Null\"," +
                    "\"Booking Time\":\"Null\",\"SeatClass\":\"Null\",\"Surname\":\"Null\",\"Location\":\"Null\"," +
                    "\"Flight Number\": \"Null\",\"Status\": \"Null\"}]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
