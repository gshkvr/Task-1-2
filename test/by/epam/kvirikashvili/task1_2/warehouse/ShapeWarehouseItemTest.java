package by.epam.kvirikashvili.task1_2.warehouse;

import by.epam.kvirikashvili.task1_2.entity.Point;
import by.epam.kvirikashvili.task1_2.entity.Shape;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShapeWarehouseItemTest {

    @Test
    public void testUpdate() {
        //given
        Shape triangle = new Triangle(new Point(1, 1), new Point(3, 4), new Point(8, 35));
        WarehouseItem expected = new ShapeWarehouseItem(triangle, 69.71929812709871, 23.49999999999961);
        //when
        WarehouseItem actual = new ShapeWarehouseItem(triangle);
        ((ShapeWarehouseItem) actual).update();
        //then
        Assert.assertEquals(expected, actual);
    }
}