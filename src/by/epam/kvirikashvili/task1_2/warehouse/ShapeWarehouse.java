package by.epam.kvirikashvili.task1_2.warehouse;

import java.util.HashMap;
import java.util.Map;

public enum ShapeWarehouse implements Warehouse {
    INSTANCE;

    private Map<Integer, WarehouseItem> itemMap = new HashMap<>();

    @Override
    public void add(WarehouseItem item) {
        itemMap.put(item.getId(), item);
    }

    @Override
    public WarehouseItem get(int id) {
        return itemMap.get(id);
    }

    @Override
    public void remove(WarehouseItem item) {
        itemMap.remove(item);
    }

    @Override
    public void removeAll() {
        itemMap = new HashMap<>();
    }

    @Override
    public Map<Integer, WarehouseItem> getAll() {
        return itemMap;
    }
}
