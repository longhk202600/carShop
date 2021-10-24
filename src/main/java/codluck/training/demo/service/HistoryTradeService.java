package codluck.training.demo.service;

import codluck.training.demo.model.HistoryTrade;

import java.util.List;
import java.util.Optional;

public interface HistoryTradeService {
    public HistoryTrade save(HistoryTrade historyTrade);
    public List<Float> getlist();

}
