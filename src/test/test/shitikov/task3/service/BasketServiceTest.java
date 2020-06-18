package test.shitikov.task3.service;

import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.entity.Basket;
import com.shitikov.task3.exception.ProjectException;
import com.shitikov.task3.service.BasketService;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class BasketServiceTest {
    BasketService basketService;
    Basket basket;
    ArrayList<Ball> balls = new ArrayList<>();

    @BeforeTest
    public void setUp() {
        basketService = new BasketService();
        basket = new Basket(300, 1000, 6);
        balls.add(new Ball(BallColor.BLUE, 12, 3));
        balls.add(new Ball(BallColor.BLUE, 15, 5.5));
        balls.add(new Ball(BallColor.BLACK, 20, 1.5));
        balls.add(new Ball(BallColor.RED, 15, 2));
    }

    @DataProvider(name = "dataException")
    public Object[][] createDataExc() {
        return new Object[][]{{null, balls}, {basket, null}};
    }

    @Test(dataProvider = "dataException", expectedExceptions = ProjectException.class)
    public void testPutBallsToBasketException(Basket basket, ArrayList<Ball> balls) throws ProjectException {
        basketService.putBallsToBasket(basket, balls);
    }

    @Test
    public void testPutBallsToBasketTrue() {
        try {
            assertTrue(basketService.putBallsToBasket(basket, balls), "Test failed as... ");
            basket.clear();
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @DataProvider(name = "dataFalse")
    public Object[][] createDataFalse() {
        List<Ball> weightFalse = new ArrayList<>(balls);
        weightFalse.add(new Ball(BallColor.RED, 256, 4));

        List<Ball> volumeFalse = new ArrayList<>(balls);
        volumeFalse.add(new Ball(BallColor.RED, 25, 5));

        List<Ball> radiusFalse = new ArrayList<>(balls);
        radiusFalse.add(new Ball(BallColor.RED, 25, 7));

        return new Object[][]{{basket, weightFalse}, {basket, volumeFalse}, {basket, radiusFalse}};

    }

    @Test(dataProvider = "dataFalse")
    public void testPutBallsToBasketFalse(Basket basket, ArrayList<Ball> balls) {
        try {
            assertFalse(basketService.putBallsToBasket(basket, balls), "Test failed as... ");
            basket.clear();
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @BeforeGroups(groups = "color")
    public void setUpGroup() {
        basketService = new BasketService();
        basket = new Basket(300, 1000, 6);
        basket.add(new Ball(BallColor.RED, 25, 1.5));
        basket.add(new Ball(BallColor.BLACK, 30, 2.5));
        basket.add(new Ball(BallColor.BLUE, 12, 3));
        basket.add(new Ball(BallColor.BLUE, 15, 5.5));
    }

    @DataProvider(name = "dataColorException")
    public Object[][] createColorExc() {
        return new Object[][]{{null, BallColor.BLACK}, {basket, null}};
    }


    @Test(groups = "color", dataProvider = "dataColorException", expectedExceptions = ProjectException.class)
    public void testNumberOfBallsByColorException(Basket basket, BallColor color) throws ProjectException {
        basketService.numberOfBallsByColor(basket, color);
    }

    @Test(groups = "color")
    public void testNumberOfBallsByColorPositive() {
        try {
            int actual = basketService.numberOfBallsByColor(basket, BallColor.BLUE);
            int expected = 2;
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }

    @Test(groups = {"color"})
    public void testNumberOfBallsByColorNegative() {
        try {
            int actual = basketService.numberOfBallsByColor(basket, BallColor.BLUE);
            int expected = 3;
            assertNotEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred.");
        }
    }
}