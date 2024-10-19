package lab_3a;

import static org.junit.Assert.assertEquals;
import java.time.LocalTime;
import java.util.logging.Logger;

import org.junit.Test;

public class MovieTicketPriceCalculatorTest {

    /**
     * Test for sinior discount.
     */
    @Test 
    public void testComputeDiscount1(){
        LocalTime matineeStart = LocalTime.of(9, 00);
        LocalTime matineeEnd = LocalTime.of(15, 00);
        MovieTicketPriceCalculator MTPC = new MovieTicketPriceCalculator(matineeStart, matineeEnd, 12, 60);
        int output = MTPC.computeDiscount(60);
        int expected = 400;
        assertEquals(output, expected);
    }

    /**
     * Test for no dicount.
     */
    @Test 
    public void testComputeDiscount2(){
        LocalTime matineeStart = LocalTime.of(9, 00);
        LocalTime matineeEnd = LocalTime.of(15, 00);
        MovieTicketPriceCalculator MTPC = new MovieTicketPriceCalculator(matineeStart, matineeEnd, 12, 60);
        int output = MTPC.computeDiscount(50);
        int expected = 0;
        assertEquals(output, expected);
    }


    /**
     * Test for child discount.
     */
    @Test 
    public void testComputeDiscount3(){
        LocalTime matineeStart = LocalTime.of(9, 00);
        LocalTime matineeEnd = LocalTime.of(15, 00);
        MovieTicketPriceCalculator MTPC = new MovieTicketPriceCalculator(matineeStart, matineeEnd, 12, 60);
        int output = MTPC.computeDiscount(12);
        int expected = 300;
        assertEquals(output, expected);
    }

    /**
     * Test for normal price no age discount.
     */
    @Test 
    public void testComputePrice1(){
        LocalTime matineeStart = LocalTime.of(9, 00);
        LocalTime matineeEnd = LocalTime.of(15, 00);
        MovieTicketPriceCalculator MTPC = new MovieTicketPriceCalculator(matineeStart, matineeEnd, 12, 60);
        int output = MTPC.computePrice(LocalTime.of(16, 45), 13);
        int expected = 2700;
        assertEquals(output, expected);
    }

    /**
     * test for start of matinee price with age discount.
     */
    @Test
    public void testComputePrice2(){
        LocalTime matineeStart = LocalTime.of(9, 00);
        LocalTime matineeEnd = LocalTime.of(15, 00);
        MovieTicketPriceCalculator MTPC = new MovieTicketPriceCalculator(matineeStart, matineeEnd, 12, 60);
        int output = MTPC.computePrice(LocalTime.of(9, 00), 68);
        int expected = 2400-400;
        assertEquals(output, expected);
    }

    /**
     * test for middle of matinee price with age discount.
     */
    @Test
    public void testMovieTicketPriceCalculator(){
        LocalTime matineeStart = LocalTime.of(15, 00);
        LocalTime matineeEnd = LocalTime.of(9, 00);
        try{
        MovieTicketPriceCalculator MTPC = new MovieTicketPriceCalculator(matineeStart, matineeEnd, 12, 60);
        } catch(IllegalArgumentException e){
            String expected = "matinee start time cannot come after end time";
            assertEquals(e.getMessage(), expected);
        }
    }
}
