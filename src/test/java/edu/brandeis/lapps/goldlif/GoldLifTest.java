package edu.brandeis.lapps.goldlif;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author krim
 * @since 2/8/2018
 */
public class GoldLifTest {

    @Test
    public void canGetLatestAsString() {
        try {
            System.out.println(GoldLif.getAsString());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void cannotGetNonexistingLif() {
        try {
            GoldLif.getAsString("0.0.0");
            fail("should throw a 'file not found' error");
        } catch (IOException e) {
            assertTrue(e.getMessage().concat("0.0.0"), true);
        }
    }

    @Test
    public void canGetSpecificAsString() {
        try {
            System.out.println(GoldLif.getAsString("1.0.0"));
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}