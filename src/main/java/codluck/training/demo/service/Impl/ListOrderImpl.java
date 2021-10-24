package codluck.training.demo.service.Impl;

import codluck.training.demo.model.ListOrder;
import codluck.training.demo.repository.ListOrdersRepository;
import codluck.training.demo.service.ListOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListOrderImpl implements ListOrderService {

    @Autowired
    ListOrdersRepository listOrdersRepository;
    @Override
    public List<ListOrder> getListOrder() {
        return listOrdersRepository.getListOrder();
    }

    @Override
    public void deleteById(int id) {
        listOrdersRepository.deleteById(id);
    }
}
