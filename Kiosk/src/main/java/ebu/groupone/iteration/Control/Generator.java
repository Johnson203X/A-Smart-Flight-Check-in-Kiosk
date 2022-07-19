package ebu.groupone.iteration.Control;

import ebu.groupone.iteration.BackEnd.BookingIO;
import ebu.groupone.iteration.Model.Booking;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Class of generating random data for running the kiosk application
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:19
 */
public class Generator extends Thread {
    /**
     * The Generate data size, default 2500. Too large will cause out of JVM memory
     */
    public static final int MAX_GENERATE = 200;
    /**
     * The Generate flight number size, default 10. Needs sufficient planes to match MAX_GENERATE, otherwise insufficient ticket for check-in
     */
    public static final int MAX_PLANES = 8;
    /**
     * Global Param Counter within the process of indicating the progress
     */
    public static int counter = 0;
    /**
     * Parameter of regulating generation of MAX_NAMESIAZE
     */
    public final int MAX_NAMESIAZE = 12;
    /**
     * Parameter of regulating generation of MIN_NAMESIAZE
     */
    public final int MIN_NAMESIAZE = 3;
    /**
     * Parameter of regulating generation of IDNmuberSize
     */
    public final int IDNmuberSize = 8;
    /**
     * Parameter of regulating generation of BookingNumberSize
     */
    public final int BookingNumberSize = 10;
    /**
     * Parameter of regulating generation of BelongingsSize
     */
    public final int BelongingsSize = 15;
    /**
     * Parameter Cabin Genre selection
     */
    public String Cabin = "";
    /**
     * Parameter Seat Genre selection
     */
    public String Seat = "";
    /**
     * Parameter Seat Row Min indicator
     */
    public int Seat_X_MIN = 0;
    /**
     * Parameter Seat Row Max indicator
     */
    public int Seat_X_MAX = 0;
    /**
     * Parameter Seat Column Min indicator
     */
    public int Seat_Y_MIN = 1;
    /**
     * Parameter Seat Column Max indicator
     */
    public int Seat_Y_MAX = 0;
    /**
     * Parameter First-class Row Min
     */
    public int FC_X_MIN = 1;
    /**
     * Parameter First-class Row Max
     */
    public int FC_X_MAX = 4;
    /**
     * Parameter First-class Column Max
     */
    public int FC_Y = 4;
    /**
     * Parameter Business Column Min
     */
    public int BS_X_MIN = 5;
    /**
     * Parameter Business Row Max
     */
    public int BS_X_MAX = 12;
    /**
     * Parameter Business Column Max
     */
    public int BS_Y = 6;
    /**
     * Parameter Economy Row Min
     */
    public int EC_X_MIN = 13;
    /**
     * Parameter Economy Row Max
     */
    public int EC_X_MAX = 50;
    /**
     * Parameter Economy Column Max
     */
    public int EC_Y = 10;
    /**
     * Parameter Seat Row Location
     */
    public int Seat_X = 0;
    /**
     * Parameter Seat Column Location
     */
    public int Seat_Y = 0;
    /**
     * Parameter FlightList Array
     */
    private String[] FlightList = new String[MAX_PLANES];
    /**
     * Parameter GateList Array
     */
    private String[] GateList = new String[MAX_PLANES];
    /**
     * Parameter LocationList Array
     */
    private String[] LocationList = new String[MAX_PLANES];
    /**
     * Parameter DepartureTimeList Array
     */
    private String[] DepartureTimeList = new String[MAX_PLANES];
    /**
     * Parameter Display_Status, default to false
     */
    private boolean Display_Status = false;

    /**
     * The override run() method of Generate extends Thread class to generate data
     */
    @Override
    public void run() {
        counter = 0;
        System.out.println("Generating New Data...");
        intializeFlight();
        BookingIO bookingIO = new BookingIO();
        bookingIO.Clear();
        ArrayList<Object> Data = new ArrayList<Object>();
        String[] flightinfo = randomFlightNumber();
        Data.add(new Booking("1234567890", "Johnson", "12345678", BookingTimeIntial(),
                flightinfo[4], randomMeal(), flightinfo[0], flightinfo[1], flightinfo[3],
                "LHR", flightinfo[2], randomBelongings(), "Unchecked", flightinfo[5]));
        bookingIO.WriteOut(Data);
        //counter ++;
        for (int i = 0; i < MAX_GENERATE; i++) {
            Data.remove(0);
            flightinfo = randomFlightNumber();
            Data.add(new Booking(randomBookingNumber(), randomName(), randomIDNumber(), BookingTimeIntial(),
                    flightinfo[4], randomMeal(), flightinfo[0], flightinfo[1], flightinfo[3],
                    "LHR", flightinfo[2], randomBelongings(), randomStatus(), flightinfo[5]));
            bookingIO.WriteOut(Data);
            counter++;
        }
        System.out.println("--------------------------------------------");
        System.out.println("Generation Finished");
    }

    /**
     * Initialize Flights in the first place
     */
    public void intializeFlight() {
        for (int i = 0; i < MAX_PLANES; i++) {
            this.FlightList[i] = randomFlight();
            this.GateList[i] = randomGate();
            this.LocationList[i] = randomLocation();
            this.DepartureTimeList[i] = randomDepartueTime();
        }
    }

    /**
     * Generate random FlightNumber and return in String[] format
     * @return String[]
     */
    public String[] randomFlightNumber() {
        String[] FlightInfo = new String[6];
        int target = (int) (Math.random() * MAX_PLANES);
        FlightInfo[0] = FlightList[target];
        FlightInfo[1] = GateList[target];
        FlightInfo[2] = LocationList[target];
        FlightInfo[3] = DepartureTimeList[target];
        String[] randomSeat_info = randomSeat(FlightInfo[0]);
        FlightInfo[4] = randomSeat_info[0];
        FlightInfo[5] = randomSeat_info[1];
        return FlightInfo;
    }


    /**
     * Generate random Meal and Drinks combination and return in String format
     * @return String
     */
    public String randomMeal() {
        String[] Staple = {"Rice", "Noodle", "Roll", "Hamburger", "Sushi", "Reserved"};
        String[] Dishes = {"Pork", "Beef", "Chicken", "Fish", "Reserved_Dishes"};
        String[] Drink = {"Water", "Juice", "Coffee", "Tea", "Coke", "Reserved_Drinks"};
        String Output_Staple = Staple[(int) (Math.random() * 6)];
        String Output_Dishes = Dishes[(int) (Math.random() * 5)];
        String Output_Drink = Drink[(int) (Math.random() * 6)];
        return Output_Staple + Output_Dishes + Output_Drink;
    }

    /**
     * Generate random Seats combination and return in String[] format
     * @param FlightNumber Input Param to targat flights
     * @return String[]
     */
    public String[] randomSeat(String FlightNumber) {
        String[] Cabin_Selection = {"First-Class", "Business", "Economy"};
        String[] Seat_Selection = {"Windows-Seat", "Middle-Seat", "Asile-Seat"};
        String randomSeat[] = new String[2];
        String Locate = "";
        while (true) {
            Cabin = Cabin_Selection[(int) (Math.random() * 3)];
            Seat = Seat_Selection[(int) (Math.random() * 3)];
            if (!(Cabin.equals("First-Class") && Seat.equals("Middle-Seat"))) {
                Locate = Location();
                if (!duplicate_Location(Locate, FlightNumber)) {
                    break;
                }
            }
        }
        randomSeat[0] = Cabin + "-" + Seat;
        randomSeat[1] = Locate;
        return randomSeat;
    }

    /**
     * Num to Alphabet convertor to display column on plane in Alphabet format
     * @param Num The original Param of column num
     * @return String
     */
    public String Num_To_Alphabet(int Num) {
        switch (Num) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            case 6:
                return "F";
            case 7:
                return "G";
            case 8:
                return "H";
            case 9:
                return "I";
            case 10:
                return "J";
            default:
                return "K";
        }
    }

    /**
     * Judging if the location duplication occurs for this Locate and FlightNumber
     * @param Locate The location on plane
     * @param FlightNumber The target flight number
     * @return boolean
     */
    public boolean duplicate_Location(String Locate, String FlightNumber) {
        boolean status = false;
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> Data = bookingIO.ReadAll();
        for (int i = 0; i < Data.size(); i++) {
            Booking booking = (Booking) Data.get(i);
            System.out.println("-----------------------------Generated Data------------------------------" + Integer.toString(counter + 1) + "/" + Integer.toString(MAX_GENERATE));
            System.out.println(booking.getFlightNumber() + " // " + FlightNumber);
            System.out.println(booking.getLocate() + " // " + Locate);
            if (booking.getFlightNumber().equals(FlightNumber)) {
                if (booking.getLocate().equals(Locate)) {
                    System.out.println("-----------------------------Duplicate Data------------------------------" + Integer.toString(counter + 1) + "/" + Integer.toString(MAX_GENERATE));
                    System.out.println(booking.getFlightNumber() + " // " + FlightNumber);
                    System.out.println(booking.getLocate() + " // " + Locate);
                    status = true;
                }
            }
        }
        return status;
    }

    /**
     * Generate Random Location on plane with considering duplication
     * @return String
     */
    public String Location() {
        Random rd = new Random();
        switch (Cabin) {
            case "First-Class":
                Seat_X = FC_X_MIN + rd.nextInt(FC_X_MAX - FC_X_MIN + 1);
                Seat_X_MIN = FC_X_MIN;
                Seat_X_MAX = FC_X_MAX;
                Seat_Y_MAX = FC_Y;
                break;
            case "Business":
                Seat_X = BS_X_MIN + rd.nextInt(BS_X_MAX - BS_X_MIN + 1);
                Seat_X_MIN = BS_X_MIN;
                Seat_X_MAX = BS_X_MAX;
                Seat_Y_MAX = BS_Y;
                break;
            case "Economy":
                Seat_X = EC_X_MIN + rd.nextInt(EC_X_MAX - EC_X_MIN + 1);
                Seat_X_MIN = EC_X_MIN;
                Seat_X_MAX = EC_X_MAX;
                Seat_Y_MAX = EC_Y;
                break;
            default:
                Seat_X = 0;
                Seat_Y_MAX = 0;
        }
        switch (Seat) {
            case "Windows-Seat":
                int location = rd.nextInt(2);
                switch (location) {
                    case 0:
                        Seat_Y = Seat_Y_MIN;
                        break;
                    case 1:
                        Seat_Y = Seat_Y_MAX;
                        break;
                    default:
                        Seat_Y = 0;
                }
                break;
            case "Middle-Seat":
                if (Seat_Y_MAX == 4) {
                    Seat_Y = 0;
                    break;
                } else if (Seat_Y_MAX == 6) {
                    location = rd.nextInt(2);
                    switch (location) {
                        case 0:
                            Seat_Y = 2;
                            break;
                        case 1:
                            Seat_Y = 5;
                            break;
                        default:
                            Seat_Y = 0;
                    }
                    break;
                } else if (Seat_Y_MAX == 10) {
                    location = rd.nextInt(4);
                    switch (location) {
                        case 0:
                            Seat_Y = 2;
                            break;
                        case 1:
                            Seat_Y = 5;
                            break;
                        case 2:
                            Seat_Y = 6;
                            break;
                        case 3:
                            Seat_Y = 9;
                            break;
                        default:
                            Seat_Y = 0;
                    }
                    break;
                } else {
                    break;
                }
            case "Asile-Seat":
                if (Seat_Y_MAX == 4 || Seat_Y_MAX == 6) {
                    location = rd.nextInt(2);
                    switch (location) {
                        case 0:
                            Seat_Y = Seat_Y_MAX / 2;
                            break;
                        case 1:
                            Seat_Y = Seat_Y_MAX / 2 + 1;
                            break;
                        default:
                            Seat_Y = 0;
                    }
                    break;
                } else {
                    location = rd.nextInt(4);
                    switch (location) {
                        case 0:
                            Seat_Y = 3;
                            break;
                        case 1:
                            Seat_Y = 4;
                            break;
                        case 2:
                            Seat_Y = 7;
                            break;
                        case 3:
                            Seat_Y = 8;
                            break;
                        default:
                            Seat_Y = 0;
                    }
                    break;
                }
            default:
                Seat_Y = 0;
        }
        return Seat_X + Num_To_Alphabet(Seat_Y);
    }

    /**
     * Generate Random Depature Time based on current time of future 0~12 hours
     * @return String
     */
    public String randomDepartueTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long rad_time = (long) (Math.random() * 12) * 60 * 60 * 1000 + (long) (Math.random() * 60) * 60 * 1000 + (long) (Math.random() * 60) * 1000;//Future 12 hours
        Date RandomTime = new Date(System.currentTimeMillis() + rad_time);
        return sdf.format(RandomTime);
    }

    /**
     * Generating Random Flight Number
     * @return String
     */
    public String randomFlight() {
        String Flight = "*****";
        char[] GenerateChar = new char[3];
        for (int i = 0; i < 3; i++) {
            GenerateChar[i] = (char) (Math.random() * 10 + 48);
        }
        Flight = "BA" + new String(GenerateChar);
        return Flight;
    }

    /**
     * Generate Random Gate
     * @return String
     */
    public String randomGate() {
        String Gate = "***";
        char[] GenerateChar = new char[2];
        for (int i = 0; i < 2; i++) {
            GenerateChar[i] = (char) (Math.random() * 10 + 48);
        }
        Gate = (char) (Math.random() * 4 + 65) + new String(GenerateChar);
        return Gate;
    }

    /**
     * Generating Random Location of Destination
     * @return String
     */
    public String randomLocation() {
        String Location = "***";
        char[] GenerateChar = new char[3];
        for (int i = 0; i < 3; i++) {
            GenerateChar[i] = (char) (Math.random() * 26 + 65);
        }
        Location = new String(GenerateChar);
        return Location;
    }

    /**
     * Generating Random Name
     * @return String
     */
    public String randomName() {
        String name;
        char[] nameChar;
        int nameLength = (int) (Math.random() * (MAX_NAMESIAZE - MIN_NAMESIAZE + 1)) + MIN_NAMESIAZE;
        nameChar = new char[nameLength];
        nameChar[0] = (char) (Math.random() * 26 + 65);
        for (int i = 1; i < nameLength; i++) {
            nameChar[i] = (char) (Math.random() * 26 + 97);
        }
        name = new String(nameChar);
        return name;
    }

    /**
     * Judging if the Booking Number duplication occurs
     * @param Number The target Booking number
     * @return boolean
     */
    public boolean duplicate_BookingNumber(String Number) {
        boolean status = false;
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> Data = bookingIO.ReadAll();
        for (int i = 0; i < Data.size(); i++) {
            Booking booking = (Booking) Data.get(i);
            if (booking.getBookingNumber() == Number) {
                status = true;
            }
        }
        return status;
    }

    /**
     * Judging if the ID Number duplication occurs
     * @param Number The target ID number
     * @return boolean
     */
    public boolean duplicate_IDNumber(String Number) {
        boolean status = false;
        BookingIO bookingIO = new BookingIO();
        ArrayList<Object> Data = bookingIO.ReadAll();
        for (int i = 0; i < Data.size(); i++) {
            Booking booking = (Booking) Data.get(i);
            if (booking.getIDNumber() == Number) {
                status = true;
            }
        }
        return status;
    }

    /**
     * Generate Random IDNumber and consider duplication as well
     * @return String
     */
    public String randomIDNumber() {
        String IDNumber = "********";
        char[] GenerateChar = new char[IDNmuberSize];
        while (true) {
            for (int i = 0; i < IDNmuberSize; i++) {
                GenerateChar[i] = (char) (Math.random() * 10 + 48);
            }
            IDNumber = new String(GenerateChar);
            if (!duplicate_IDNumber(IDNumber))
                break;
        }
        return IDNumber;
    }


    /**
     * Generating Random Status
     * @return String
     */
    public String randomStatus() {
        int status = (int) (Math.random() * 2);
        if (status == 1)
            return "Checked";
        else
            return "Unchecked";
    }

    /**
     * Generate Random Belongings Code
     * @return String
     */
    public String randomBelongings() {
        String Belongings = "***************";
        char[] GenerateChar = new char[BelongingsSize];
        for (int i = 0; i < BelongingsSize; i++) {
            while (true) {
                double range = Math.random() * 53 + 48;
                if ((48 <= range && range <= 57) || (65 <= range && range <= 90) || (97 <= range && range <= 122)) {
                    GenerateChar[i] = (char) range;
                    break;
                }
            }
        }
        Belongings = new String(GenerateChar);
        return Belongings;
    }

    /**
     * Generate Random BookingNumber and consider duplication as well
     * @return String
     */
    public String randomBookingNumber() {
        String BookingNumber = "**********";
        ;
        char[] GenerateChar = new char[BookingNumberSize];
        while (true) {
            for (int i = 0; i < BookingNumberSize; i++) {
                GenerateChar[i] = (char) (Math.random() * 10 + 48);
            }
            BookingNumber = new String(GenerateChar);
            if (!duplicate_BookingNumber(BookingNumber))
                break;
        }
        return BookingNumber;
    }

    /**
     * Initialize the BookingTime as the moment generating the data
     * @return String
     */
    public String BookingTimeIntial() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Latest_Update = new Date();
        return sdf.format(Latest_Update);
    }

}
