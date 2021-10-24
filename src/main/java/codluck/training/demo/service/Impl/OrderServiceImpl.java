package codluck.training.demo.service.Impl;

import codluck.training.demo.model.Order;
import codluck.training.demo.repository.OrderRepository;
import codluck.training.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }



    // this function will check order exist in table order
    @Override
    public boolean checkOrder(int id, int userId) {
        //get list order in db bay userId and id order
        List<Order> order = orderRepository.getListOrderByUserIDAndCarID(id, userId);
        if (order.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    // delete order by Id order
    @Override
    public void deleteOrderByID(int id) {
        orderRepository.deleteById(id);
    }
    // delete order by car id
    @Override
    public void deleteOrderByCarID(int carID) {
        orderRepository.deleteOrderByCarID(carID);
    }
}
