package test.shitikov.task3.create;

import com.shitikov.task3.create.BallCreator;
import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.exception.ProgramException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BallCreatorTest {
    BallCreator ballCreator;

    @BeforeClass
    public void setUp() {
        ballCreator = new BallCreator();
    }

    @DataProvider(name = "data")
    public Object[][] createData() {
        return new Object[][]{{null, 56, 2.5}, {BallColor.BLACK, -3, 2.5},
                {BallColor.BLACK, 3500, 2.5}, {BallColor.BLACK, 25, -5},
                {BallColor.BLACK, 25, 130}};
    }

    @Test(dataProvider = "data", expectedExceptions = ProgramException.class)
    public void testCreateBallException(BallColor color, double weight, double radius) throws ProgramException {
        ballCreator.createBall(color, weight, radius);
    }

    @Test
    public void testCreateBall() {
        try {
            Ball actual = ballCreator.createBall(BallColor.BLACK, 35, 2.5);
            Ball expected = new Ball(BallColor.BLACK, 35, 2.5);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProgramException e) {
            fail("Exception has occurred");
        }
    }
}