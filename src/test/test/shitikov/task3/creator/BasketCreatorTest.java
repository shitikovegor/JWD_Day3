package test.shitikov.task3.creator;

import com.shitikov.task3.creator.BasketCreator;
import com.shitikov.task3.entity.Basket;
import com.shitikov.task3.exception.ProjectException;
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

    @Test(dataProvider = "data", expectedExceptions = ProjectException.class)
    public void testCreateBasketException(double weightCapacity, double volumeCapacity, double radius) throws ProjectException {
        basketCreator.createBasket(weightCapacity, volumeCapacity, radius);
    }

    @Test
    public void testCreateBasket() {
        try {
            Basket actual = basketCreator.createBasket(650, 3200, 20);
            Basket expected = new Basket(650, 3200, 20);
            assertEquals(actual, expected, "Test failed as... ");
        } catch (ProjectException e) {
            fail("Exception has occurred");
        }

    }
}