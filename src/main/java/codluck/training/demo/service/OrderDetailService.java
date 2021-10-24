package codluck.training.demo.service;

import codluck.training.demo.model.OrderDetails;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetails> getOrderDetail();

    List<OrderDetails> getOrderDetailLimit(int index);

    StringBuilder getHtmlOrderWitPage(List<OrderDetails> orderDetailsList);
}
