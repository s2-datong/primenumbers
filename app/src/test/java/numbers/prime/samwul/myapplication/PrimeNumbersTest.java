package numbers.prime.samwul.myapplication;

import org.junit.Test;

import numbers.prime.samwul.myapplication.generator.PrimeNumbers;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class PrimeNumbersTest {

    @Test
    public void check_Primes(){
        PrimeNumbers primegenerator = new PrimeNumbers(20);
        int[] twentyprime = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};
        primegenerator.generate();
        int[] result = primegenerator.getGeneratedPrimes();

        assertArrayEquals(twentyprime, result);
    }
}