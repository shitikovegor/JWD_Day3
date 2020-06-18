package test.shitikov.task3.entity;

import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.entity.Basket;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BasketTest {
    Basket basket;

    @BeforeTest
    public void setUp() {
        basket = new Basket(100, 6000, 10);
    }

    @Test
    public void testAddTrue() {
        Ball ball = new Ball(BallColor.BLACK, 30, 4);
        assertTrue(basket.add(ball), "Test failed as... ");
        basket.clear();
    }

    @DataProvider(name = "dataBalls")
    public Object[][] createData() {
        Ball weightBall = new Ball(BallColor.BLACK, 110, 4);
        Ball radiusBall = new Ball(BallColor.BLACK, 90, 11);
        Ball nullBall = null;

        Basket basketVolume = new Basket(100, 3000, 10);
        Ball volumeBall = new Ball(BallColor.BLACK, 90, 9);

        return new Object[][]{{basket, weightBall}, {basket, radiusBall}, {basket, nullBall}, {basketVolume, volumeBall}};
    }

    @Test(dataProvider = "dataBalls")
    public void testAddFalse(Basket basket, Ball ball) {
        assertFalse(basket.add(ball), "Test failed as... ");
    }

//    @BeforeMethod(groups = {"calc"})
//    public void setBasket() {
//        basket.add(new Ball(BallColor.BLACK, 25, 1.5));
//        basket.add(new Ball(BallColor.BLACK, 30, 2.5));
//    }
//
//    @Test(groups = {"calc"})
//    public void testCalcWeightOfBallsPositive() {
//        double actual = basket.calcWeightOfBalls();
//        double expected = 55.0;
//        assertEquals(actual, expected, "Test failed as... ");
//    }
//
//    @Test(groups = {"calc"})
//    public void testCalcWeightOfBallsNegative() {
//        double actual = basket.calcWeightOfBalls();
//        double expected = 30.0;
//        assertNotEquals(actual, expected, "Test failed as... ");
//    }
//
//    @Test(groups = {"calc"})
//    public void testCalcVolumeOfBallsPositive() {
//        double actual = basket.calcVolumeOfBalls();
//        double expected = 79.587;
//        assertEquals(actual, expected, 0.001, "Test failed as... ");
//    }
//
//    @Test(groups = {"calc"})
//    public void testCalcVolumeOfBallsNegative() {
//        double actual = basket.calcVolumeOfBalls();
//        double expected = 65.255;
//        assertNotEquals(actual, expected, 0.001, "Test failed as... ");
//    }
}