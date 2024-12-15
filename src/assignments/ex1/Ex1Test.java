package assignments.ex1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(11, v);

        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);


        assertTrue(Ex1.equals(s10, s2));
    }


    @Test
    void isBasisNumberTest() {

        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG"};
        for (String string : good) {
            boolean ok = Ex1.isNumber(string);
            assertTrue(ok);
        }


        String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (String s : not_good) {
            boolean not_ok = Ex1.isNumber(s);
            assertFalse(not_ok);
        }
    }

    @Test
    void int2NumberTest() {

        assertEquals("101b2", Ex1.int2Number(5, 2));
        assertEquals("11bA", Ex1.int2Number(11, 10));
        assertEquals("C1b10", Ex1.int2Number(193, 16));


        assertEquals("", Ex1.int2Number(-1, 2));
        assertEquals("", Ex1.int2Number(10, 1));
        assertEquals("", Ex1.int2Number(10, 17));
    }


    @Test
    void maxIndexTest() {

        String[] arr = {"101b2", "11bA", "C1b10", "xyzb2", "123b5"};
        assertEquals(2, Ex1.maxIndex(arr));
        String[] invalidArr = {" xyzb2 ", "1b1", "123b18"};
        assertEquals(0, Ex1.maxIndex(invalidArr));

    }
}


