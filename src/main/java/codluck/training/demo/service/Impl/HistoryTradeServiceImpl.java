package codluck.training.demo.service.Impl;

import codluck.training.demo.model.HistoryTrade;
import codluck.training.demo.repository.HistoryTradeRepository;
import codluck.training.demo.service.HistoryTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HistoryTradeServiceImpl implements HistoryTradeService {

    @Autowired
    HistoryTradeRepository historyTradeRepository;

    @Override
    public HistoryTrade save(HistoryTrade historyTrade) {
        return historyTradeRepository.save(historyTrade);
    }

    @Override
    public List<Float> getlist() {
        List<HistoryTrade> list = historyTradeRepository.findAll();
        List<Float> sl = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            float money = 0;
            String moth = "";
            if (i < 10) {
                moth = "/0" + i + "/";
            } else {
                moth = "/" + i + "/";
            }
            for (HistoryTrade Ht : list) {
                if (Ht.getDate().contains(moth)) {
                    money += Ht.getMoney();
                }
            }
            sl.add(money);
        }
        return sl;
    }
}
