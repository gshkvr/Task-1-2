package by.epam.kvirikashvili.task1_2.repository;

import by.epam.kvirikashvili.task1_2.entity.Point;
import by.epam.kvirikashvili.task1_2.entity.Triangle;
import org.testng.annotations.DataProvider;

public class TriangleRepositoryTestData {

    @DataProvider(name = "testQuery")
    public Object[] testQuery() {
        ShapeRepository triangleRepository = TriangleRepository.INSTANCE;
        triangleRepository.removeAll();
        triangleRepository.add(new Triangle(0, new Point(1, 1), new Point(3, 4), new Point(8, 35)));
        triangleRepository.add(new Triangle(2, new Point(-3, -2), new Point(5, 5), new Point(9, 4)));
        triangleRepository.add(new Triangle(1, new Point(6, 4), new Point(6, 5), new Point(8, 4)));
        triangleRepository.add(new Triangle(5, new Point(2, 8), new Point(-7, -44), new Point(-91, -4)));
        triangleRepository.add(new Triangle(3, new Point(6, 7), new Point(8, 5), new Point(8, 35)));
        triangleRepository.add(new Triangle(4, new Point(9, 3), new Point(-4, -3), new Point(9, 5)));
        return new Object[]{triangleRepository};
    }
}
