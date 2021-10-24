package codluck.training.demo.service;

import codluck.training.demo.model.Order;

public interface OrderService {

    Order save(Order order);

    boolean checkOrder(int id, int user_id);

    void deleteOrderByID(int id);

    void deleteOrderByCarID(int carID);
}
