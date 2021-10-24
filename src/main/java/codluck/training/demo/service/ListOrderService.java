package codluck.training.demo.service;

import codluck.training.demo.model.ListOrder;
import java.util.List;
import java.util.Optional;
public interface ListOrderService {

    List<ListOrder> getListOrder();
    void deleteById(int id);
}
