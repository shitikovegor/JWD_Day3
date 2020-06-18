package test.shitikov.task3.create;

import com.shitikov.task3.create.BasketCreator;
import com.shitikov.task3.entity.Basket;
import com.shitikov.task3.exception.ProgramException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BasketCreatorTest {
    BasketCreator basketCreator;

    @BeforeClass
    public void setUp() {
        basketCreator = new BasketCreator();
    }

    @DataProvider(name = "data")
    public Object[][] createData() {
        return new Object[][]{{-3, 56, 2.5}, {90000, 150, 2.5},
                {650, -5, 2.5}, {650, 60000, 15},
                {550, 3500, -56}, {550, 3500, 150}};
    }

    @Test(dataProvider = "data", expectedExceptions = ProgramException.class)
    public void testCreateBasketException(double weightCapacity, double volumeCapacity, double radius) throws ProgramException {
        basketCreator.createBasket(weightCapacity, volumeCapacity, radius);
    }

    @Test
    public void testCreateBasket() {
        try {
            Basket actual = basketCreator.createBasket(650, 3200, 20);
            Basket expected = new Basket(650, 3200, 20);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProgramException e) {
            fail("Exception has occurred");
        }

    }
}