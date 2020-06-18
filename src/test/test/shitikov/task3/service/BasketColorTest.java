package test.shitikov.task3.service;

import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.entity.Basket;
import com.shitikov.task3.exception.ProgramException;
import com.shitikov.task3.service.BasketService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class BasketColorTest {
    BasketService basketService;
    Basket basket;

    @BeforeTest
    public void setUp() {
        basketService = new BasketService();

        basket = new Basket(300, 1000, 6);
        basket.add(new Ball(BallColor.RED, 25, 1.5));
        basket.add(new Ball(BallColor.BLACK, 30, 2.5));
        basket.add(new Ball(BallColor.BLUE, 12, 3));
        basket.add(new Ball(BallColor.BLUE, 15, 5.5));
    }

    @Test
    public void testNumberOfBallsByColorPositive() {
        try {
            int actual = basketService.numberOfBallsByColor(basket, BallColor.BLUE);
            int expected = 2;
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProgramException e) {
            fail("Exception has occurred.");
        }
    }

    @Test
    public void testNumberOfBallsByColorNegative() {
        try {
            int actual = basketService.numberOfBallsByColor(basket, BallColor.BLUE);
            int expected = 3;
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProgramException e) {
            fail("Exception has occurred.");
        }
    }
}
