package test.shitikov.task3.read;

import com.shitikov.task3.read.BasketReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketReaderTest {
    BasketReader basketReader;

    @BeforeClass
    public void setUp() {
        basketReader = new BasketReader();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testReadFileException() {
        basketReader.readFile("exception_test_file.txt");
    }

    @Test
    public void testReadFilePositive() {
        try {
            List<String> actual = basketReader.readFile("balls_test_file.txt");
            List<String> expected = new ArrayList<>();
            expected.add("grey 2.5 1.25");
            expected.add("blue 3.22 1.5");

            assertEquals(actual, expected, "Test failed as...");
        } catch (RuntimeException e) {
            fail("Exception has occurred");
        }
    }

    @Test
    public void testReadFileNegative() {
        try {
            List<String> actual = basketReader.readFile("balls_test_file.txt");
            List<String> expected = new ArrayList<>();
            expected.add("red 12.5 1.25");
            expected.add("black 18 1.5");

            assertNotEquals(actual, expected, "Test failed as...");
        } catch (RuntimeException e) {
            fail("Exception has occurred");
        }
    }
}