package test.shitikov.task3.entity;

import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.entity.Basket;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class BasketCalculationTest {
    Basket basket;

    @BeforeTest
    public void setUp() {
        basket = new Basket(100, 6000, 10);
        basket.add(new Ball(BallColor.BLACK, 25, 1.5));
        basket.add(new Ball(BallColor.BLACK, 30, 2.5));
    }

    @Test
    public void testCalcWeightOfBallsPositive() {
        double actual = basket.calcWeightOfBalls();
        double expected = 55.0;
        assertEquals(actual, expected, "Test failed as... ");
    }

    @Test
    public void testCalcWeightOfBallsNegative() {
        double actual = basket.calcWeightOfBalls();
        double expected = 30.0;
        assertNotEquals(actual, expected, "Test failed as... ");
    }

    @Test
    public void testCalcVolumeOfBallsPositive() {
        double actual = basket.calcVolumeOfBalls();
        double expected = 79.587;
        assertEquals(actual, expected, 0.001, "Test failed as... ");
    }

    @Test
    public void testCalcVolumeOfBallsNegative() {
        double actual = basket.calcVolumeOfBalls();
        double expected = 65.255;
        assertNotEquals(actual, expected, 0.001, "Test failed as... ");
    }
}