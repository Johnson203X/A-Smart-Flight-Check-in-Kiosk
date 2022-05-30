package ebu.groupone.iteration.Control;

import ebu.groupone.iteration.BackEnd.BookingIO;
import ebu.groupone.iteration.Model.Booking;

import java.util.ArrayList;

/**
 * Class of all sorts of validation methods based on Data manipulation
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:19
 */
public class Validation {

    /**
     * Validation of Duplicate data occur
     * @param booking Input Param to indicate target
     * @return Booking
     */
    public Booking duplicateData(Booking booking) {
        String bookingNumber = booking.getBookingNumber();
        BookingIO bookingIO = new BookingIO();
        BookingDataControl bookingDataControl = new BookingDataControl();
        Booking LatestBooking = bookingDataControl._GainLatestData(bookingIO.SearchByBookingNumber(bookingNumber));
        return LatestBooking;
    }

    /**
     * Validation of Booking Number
     * @param BookingNumber Input Param to indicate target
     * @return boolean
     */
    public boolean BookingNumberValidation(String BookingNumber) {
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> arrayBooking = bookingIO.SearchByBookingNumber(BookingNumber);
        if (arrayBooking.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validation of Check-in status of this very input Booking Number
     * @param BookingNumber Input Param to indicate target
     * @return boolean
     */
    public boolean CheckInValidationByBookingNumber(String BookingNumber) {
        if (BookingNumberValidation(BookingNumber)) {
            BookingDataControl bookingDataControl = new BookingDataControl();
            String Value = bookingDataControl._GetStatus(BookingNumber);
            if (Value.equals("Checked"))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    /**
     * Validation of SurName
     * @param SurName Input Param to indicate target
     * @return boolean
     */
    public boolean SurnameValidation(String SurName) {
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> arrayBooking = bookingIO.SearchBySurname(SurName);
        if (arrayBooking.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validation of Check-in status of this very input SurName
     * @param SurName Input Param to indicate target
     * @return boolean
     */
    public boolean CheckInValidationBySurname(String SurName) {
        if (SurnameValidation(SurName)) {
            BookingDataControl bookingDataControl = new BookingDataControl();
            String BookingNumber = bookingDataControl._GetBookingNumber_WithSurname(SurName);
            String Value = bookingDataControl._GetStatus(BookingNumber);
            if (Value.equals("Checked"))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    /**
     * Validation of ID Number
     * @param IDNumber Input Param to indicate target
     * @return boolean
     */
    public boolean IDNumberValidation(String IDNumber) {
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> arrayBooking = bookingIO.SearchByIDNumber(IDNumber);
        if (arrayBooking.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Validation of Check-in status of this very input IDNumber
     * @param IDNumber Input Param to indicate target
     * @return boolean
     */
    public boolean CheckInValidationByIDNumber(String IDNumber) {
        if (IDNumberValidation(IDNumber)) {
            BookingDataControl bookingDataControl = new BookingDataControl();
            String BookingNumber = bookingDataControl._GetBookingNumber_WithIDNumber(IDNumber);
            String Value = bookingDataControl._GetStatus(BookingNumber);
            if (Value.equals("Checked"))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    /**
     * Validation of IDNumber Length Correctness
     * @param IDNumber Input Param to indicate target
     * @return boolean
     */
    public boolean validateIDNumber_Length(String IDNumber) {
        if (IDNumber.isEmpty())
            return false;//Separate Null condition in advance for robust consideration
        else if ((7 <= IDNumber.length()) && (IDNumber.length() <= 9))
            return true;//Length in range
        else
            return false;//Length out of range
    }

    /**
     * Validation of BookingNumber Length Correctness
     * @param BookingNumber Input Param to indicate target
     * @return boolean
     */
    public boolean validateBookingNumber_Length(String BookingNumber) {
        if (BookingNumber.isEmpty())
            return false;//Separate Null condition in advance for robust consideration
        else if ((8 <= BookingNumber.length()) && (BookingNumber.length() <= 12))
            return true;//Length in range
        else
            return false;//Length out of range
    }

    /**
     * Validation of CreditCard Length Correctness
     * @param CreditCard Input Param to indicate target
     * @return boolean
     */
    public boolean validateCreditCard_Length(String CreditCard) {
        if (CreditCard.isEmpty())
            return false;//Separate Null condition in advance for robust consideration
        else if ((13 <= CreditCard.length()) && (CreditCard.length() <= 19))
            return true;//Length in range
        else
            return false;//Length out of range
    }

    /**
     * Validation of IDNumber Characters Correctness
     * @param IDNumber Input Param to indicate target
     * @return boolean
     */
    public boolean validateIDNumber_Characters(String IDNumber) {
        boolean allCorrect = true;//Considering correctness true initially
        for (int i = 0; i < IDNumber.length(); i++) {
            if (!(Character.isDigit(IDNumber.charAt(i))))
                allCorrect = false;//Reading invalid input, change allCorrect status
        }
        return allCorrect;
    }

    /**
     * Validation of BookingNumber Characters Correctness
     * @param BookingNumber Input Param to indicate target
     * @return boolean
     */
    public boolean validateBookingNumber_Characters(String BookingNumber) {
        boolean allCorrect = true;//Considering correctness true initially
        for (int i = 0; i < BookingNumber.length(); i++) {
            if (!(Character.isDigit(BookingNumber.charAt(i))))
                allCorrect = false;//Reading invalid input, change allCorrect status
        }
        return allCorrect;
    }

    /**
     * Validation of CreditCard Characters Correctness
     * @param CreditCard Input Param to indicate target
     * @return boolean
     */
    public boolean validateCreditCard_Characters(String CreditCard) {
        boolean allCorrect = true;//Considering correctness true initially
        for (int i = 0; i < CreditCard.length(); i++) {
            if (!(Character.isDigit(CreditCard.charAt(i))))
                allCorrect = false;//Reading invalid input, change allCorrect status
        }
        return allCorrect;
    }

    /**
     * Validation of Surname Characters Correctness
     * @param Surname Input Param to indicate target
     * @return boolean
     */
    public boolean validateSurname_Characters(String Surname) {
        boolean allCorrect = true;//Considering correctness true initially
        for (int i = 0; i < Surname.length(); i++) {
            if (!(Character.isUpperCase(Surname.charAt(i)) ||
                    Character.isLowerCase(Surname.charAt(i))))
                allCorrect = false;//Reading invalid input, change allCorrect status
        }
        return allCorrect;
    }

    /**
     * Validation of Surname Length Correctness
     * @param Surname Input Param to indicate target
     * @return boolean
     */
    public boolean validateSurname_Length(String Surname) {
        if (Surname.isEmpty())
            return false;//Separate Null condition in advance for robust consideration
        else if ((1 <= Surname.length()) && (Surname.length() <= 30))
            return true;//Length in range
        else
            return false;//Length out of range
    }
}
