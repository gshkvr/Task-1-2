package by.epam.kvirikashvili.task1_2.warehouse;

import java.util.Map;

public interface Warehouse {
    void add(WarehouseItem item);

    WarehouseItem get(int id);

    void remove(WarehouseItem item);

    void removeAll();

    Map<Integer, WarehouseItem> getAll();
}
