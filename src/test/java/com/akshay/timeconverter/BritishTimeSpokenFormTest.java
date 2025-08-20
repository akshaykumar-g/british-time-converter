package test.java.com.akshay.timeconverter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

import com.akshay.timeconverter.BritishTimeSpokenForm;

class BritishTimeSpokenFormTest {

    @ParameterizedTest
    @CsvSource({
        // Basic hours
        "0,0,midnight",
        "12,0,noon",
        "1,0,one o'clock",
        "13,0,one o'clock",
        
        // Special minutes
        "9,15,quarter past nine",
        "14,30,half past two",
        "11,45,quarter to twelve",
        
        // Regular minutes
        "10,1,one minute past ten",
        "10,29,twenty nine minutes past ten",
        
        // Special format for 31-34
        "8,31,eight thirty one",
        "8,32,eight thirty two",
        "8,33,eight thirty three",
        "8,34,eight thirty four",
        
        // Regular format for 30 and 35
        "8,30,half past eight",
        "8,35,twenty five minutes to nine",
        "8,36,twenty four minutes to nine",
        
        // Edge cases
        "0,15,quarter past twelve",
        "0,45,quarter to one",
        "23,31,eleven thirty one",
        "23,58,two minutes to twelve"
    })
    void testToBritishTime(int h, int m, String expected) {
        assertEquals(expected, BritishTimeSpokenForm.toBritishTime(h, m));
    }

    @Test
    void testEdgeCases() {
        assertEquals("midnight", BritishTimeSpokenForm.toBritishTime(0, 0));
        assertEquals("noon", BritishTimeSpokenForm.toBritishTime(12, 0));
        assertEquals("quarter past twelve", BritishTimeSpokenForm.toBritishTime(0, 15));
        assertEquals("quarter to one", BritishTimeSpokenForm.toBritishTime(0, 45));
    }
}