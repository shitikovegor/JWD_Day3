package test.shitikov.task3.entity;

import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallTest {

    @Test
    public void testCalcVolumePositive() {
        Ball ball = new Ball(BallColor.BLACK, 15, 3);
        double actual = ball.calcVolume();
        double expected = 113.097;
        assertEquals(actual, expected, 0.001, "Test failed as... ");
    }

    @Test
    public void testCalcVolumeNegative() {
        Ball ball = new Ball(BallColor.BLACK, 10, 2);
        double actual = ball.calcVolume();
        double expected = 110.253;
        assertNotEquals(actual, expected, 0.001, "Test failed as... ");
    }
}