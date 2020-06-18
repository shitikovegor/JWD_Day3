package test.shitikov.task3.parser;

import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.entity.Basket;
import com.shitikov.task3.exception.ProjectException;
import com.shitikov.task3.parser.BallBasketParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BallBasketParserTest {
    BallBasketParser parser = new BallBasketParser();

    @BeforeClass
    public void setUp() {
        parser = new BallBasketParser();
    }

    @DataProvider(name = "dataException")
    public Object[] createDataEx() {
        return new Object[]{null, "sd 54 12"};
    }

    @Test(dataProvider = "dataException", expectedExceptions = ProjectException.class)
    public void testParseBasketException(String input) throws ProjectException {
        parser.parseBasket(input);
    }

    @Test
    public void testParseBasketPositive() {
        try {
            Basket actual = parser.parseBasket("500 8000 25");
            Basket expected = new Basket(500, 8000, 25);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testParseBasketNegative() {
        try {
            Basket actual = parser.parseBasket("500 8000 25");
            Basket expected = new Basket(300, 5000, 15);
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(dataProvider = "dataException", expectedExceptions = ProjectException.class)
    public void testParseBallException(String input) throws ProjectException {
        parser.parseBall(input);
    }

    @Test
    public void testParseBallPositive() {
        try {
            Ball actual = parser.parseBall("black 150 15");
            Ball expected = new Ball(BallColor.BLACK, 150, 15);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testParseBallNegative() {
        try {
            Ball actual = parser.parseBall("black 150 15");
            Ball expected = new Ball(BallColor.RED, 160, 11);
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void testParseBallsListException() throws ProjectException {
        parser.parseBallsList(null);
    }

    @Test
    public void testParseBallsListPositive() {
        List<String> input = new ArrayList<>();
        input.add("red 150 10");
        input.add("black 70 5.5");

        Ball ball1 = new Ball(BallColor.RED, 150, 10);
        Ball ball2 = new Ball(BallColor.BLACK, 70, 5.5);

        try {
            ArrayList<Ball> actual = parser.parseBallsList(input);
            ArrayList<Ball> expected = new ArrayList<>();
            expected.add(ball1);
            expected.add(ball2);

            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testParseBallsListNegative() {
        List<String> input = new ArrayList<>();
        input.add("red 150 10");
        input.add("black 70 5.5");

        Ball ball1 = new Ball(BallColor.BLUE, 150, 10);
        Ball ball2 = new Ball(BallColor.BLACK, 60, 5.5);

        try {
            ArrayList<Ball> actual = parser.parseBallsList(input);
            ArrayList<Ball> expected = new ArrayList<>();
            expected.add(ball1);
            expected.add(ball2);

            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }
}