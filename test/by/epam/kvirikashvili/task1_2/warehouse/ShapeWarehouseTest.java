package by.epam.kvirikashvili.task1_2.warehouse;

import by.epam.kvirikashvili.task1_2.entity.Point;
import by.epam.kvirikashvili.task1_2.entity.Shape;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ShapeWarehouseTest {

    @Test
    public void testAdd() {
        //given
        Warehouse shapeWarehouse = ShapeWarehouse.INSTANCE;
        Shape triangle = new Triangle(0, new Point(1, 1), new Point(2, 2), new Point(1, 3));
        WarehouseItem item1 = new ShapeWarehouseItem(triangle);
        shapeWarehouse.add(item1);
        Map<Integer, WarehouseItem> expected = new HashMap<>();
        WarehouseItem item2 = new ShapeWarehouseItem(triangle);
        expected.put(0, item2);
        //when
        Map<Integer, WarehouseItem> actual = shapeWarehouse.getAll();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet() {
        //given
        Warehouse shapeWarehouse = ShapeWarehouse.INSTANCE;
        shapeWarehouse.removeAll();
        Shape triangle = new Triangle(0, new Point(1, 1), new Point(2, 2), new Point(1, 3));
        WarehouseItem expected = new ShapeWarehouseItem(triangle);
        shapeWarehouse.add(expected);
        //when
        WarehouseItem actual = shapeWarehouse.get(triangle.getId());
        //then
        Assert.assertEquals(expected, actual);
    }
}