package ebu.groupone.iteration.Control;

import org.testng.Assert;

/**
 * Class of all sorts of validation TDD Results
 * @author  ebu6304.groupone
 * @version 5.0 2022/5/29 14:19
 */
public class Test {
    /**
     * Local Validation Object
     */
    public Validation Test_Validate = new Validation();

    /**
     * TDD: bookingNumberValidation
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void bookingNumberValidation() {
        Assert.assertEquals(Test_Validate.BookingNumberValidation("1234567890"),true);
        Assert.assertEquals(Test_Validate.BookingNumberValidation("12345678901"),false);
        Assert.assertEquals(Test_Validate.BookingNumberValidation("12803981323"),false);
    }

    /**
     * TDD: checkInValidationByBookingNumber
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void checkInValidationByBookingNumber() {
        Assert.assertEquals(Test_Validate.CheckInValidationByBookingNumber("1234567890"),true);
        Assert.assertEquals(Test_Validate.CheckInValidationByBookingNumber("3546680950"),false);
        Assert.assertEquals(Test_Validate.CheckInValidationByBookingNumber("5130526364"),false);
    }

    /**
     * TDD: surnameValidation
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void surnameValidation() {
        Assert.assertEquals(Test_Validate.SurnameValidation("Johnson"),true);
        Assert.assertEquals(Test_Validate.SurnameValidation("Johnsonxu"),false);
        Assert.assertEquals(Test_Validate.SurnameValidation("adjadkjjh"),false);
    }

    /**
     * TDD: checkInValidationBySurname
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void checkInValidationBySurname() {
        Assert.assertEquals(Test_Validate.CheckInValidationBySurname("Johnson"),true);
        Assert.assertEquals(Test_Validate.CheckInValidationBySurname("Dxudwhskh"),false);
        Assert.assertEquals(Test_Validate.CheckInValidationBySurname("Fdvacanys"),false);
    }

    /**
     * TDD: IDNumberValidation
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void IDNumberValidation() {
        Assert.assertEquals(Test_Validate.IDNumberValidation("12345678"),true);
        Assert.assertEquals(Test_Validate.IDNumberValidation("123456789"),false);
        Assert.assertEquals(Test_Validate.IDNumberValidation("234214738"),false);
    }

    /**
     * TDD: checkInValidationByIDNumber
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void checkInValidationByIDNumber() {
        Assert.assertEquals(Test_Validate.CheckInValidationByIDNumber("12345678"),true);
        Assert.assertEquals(Test_Validate.CheckInValidationByIDNumber("38034589"),false);
        Assert.assertEquals(Test_Validate.CheckInValidationByIDNumber("24974121"),false);
    }

    /**
     * TDD: validateIDNumber_Length
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void validateIDNumber_Length() {
        Assert.assertEquals(Test_Validate.validateIDNumber_Length("12345678"),true);
        Assert.assertEquals(Test_Validate.validateIDNumber_Length("123456"),false);
        Assert.assertEquals(Test_Validate.validateIDNumber_Length("12345678901"),false);
    }

    /**
     * TDD: validateBookingNumber_Length
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void validateBookingNumber_Length() {
        Assert.assertEquals(Test_Validate.validateBookingNumber_Length("1234567890"),true);
        Assert.assertEquals(Test_Validate.validateBookingNumber_Length("123456"),false);
        Assert.assertEquals(Test_Validate.validateBookingNumber_Length("1234567890123456"),false);
    }

    /**
     * TDD: validateCreditCard_Length
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void validateCreditCard_Length() {
        Assert.assertEquals(Test_Validate.validateCreditCard_Length("1234567890123456"),true);
        Assert.assertEquals(Test_Validate.validateCreditCard_Length("12345678"),false);
        Assert.assertEquals(Test_Validate.validateCreditCard_Length("12345678901234567890"),false);
    }

    /**
     * TDD: validateIDNumber_Characters
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void validateIDNumber_Characters() {
        Assert.assertEquals(Test_Validate.validateIDNumber_Characters("12345678901234567"),true);
        Assert.assertEquals(Test_Validate.validateIDNumber_Characters("abcdefghijklmnopq"),false);
        Assert.assertEquals(Test_Validate.validateIDNumber_Characters("1234567890abcdefg"),false);
        Assert.assertEquals(Test_Validate.validateIDNumber_Characters("1234567890 abcdefg"),false);
    }

    /**
     * TDD: validateBookingNumber_Characters
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void validateBookingNumber_Characters() {
        Assert.assertEquals(Test_Validate.validateBookingNumber_Characters("1234567890"),true);
        Assert.assertEquals(Test_Validate.validateBookingNumber_Characters("abcdefghjkl"),false);
        Assert.assertEquals(Test_Validate.validateBookingNumber_Characters("12345abcde"),false);
        Assert.assertEquals(Test_Validate.validateBookingNumber_Characters("12345 abcde"),false);
    }

    /**
     * TDD: validateCreditCard_Characters
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void validateCreditCard_Characters() {
        Assert.assertEquals(Test_Validate.validateCreditCard_Characters("1234567890123456"),true);
        Assert.assertEquals(Test_Validate.validateCreditCard_Characters("abcdefghijklmnop"),false);
        Assert.assertEquals(Test_Validate.validateCreditCard_Characters("12345678ijklmnop"),false);
    }

    /**
     * TDD: validateSurname_Characters
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void validateSurname_Characters() {
        Assert.assertEquals(Test_Validate.validateSurname_Characters("Johnson"),true);
        Assert.assertEquals(Test_Validate.validateSurname_Characters("1234567890"),false);
        Assert.assertEquals(Test_Validate.validateSurname_Characters("123456Johnson"),false);
        Assert.assertEquals(Test_Validate.validateSurname_Characters("John son"),false);
    }

    /**
     * TDD: validateSurname_Length
     * 1-SUCCESS // 2-FAILURE
     */
    @org.testng.annotations.Test
    void validateSurname_Length() {
        Assert.assertEquals(Test_Validate.validateSurname_Length("Johnson"),true);
        Assert.assertEquals(Test_Validate.validateSurname_Length(""),false);
        Assert.assertEquals(Test_Validate.validateSurname_Length("JohnsonxuJohnsonxuJohnsonxuJohnsonxu"),false);
    }
}
