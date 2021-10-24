package codluck.training.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Car> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void setItems(List<Car> items) {
        this.items = items;
    }

    public List<Car> getItems() {
        return items;
    }

    private Car getItemById(int id) {
        for (Car i : items) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void addItem(Car t) {
        if (getItemById(t.getId()) != null) {
            Car m = getItemById(t.getId());

        } else {
            items.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }
}
