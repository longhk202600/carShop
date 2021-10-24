package codluck.training.demo.repository;

import codluck.training.demo.model.HistoryTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryTradeRepository extends JpaRepository<HistoryTrade, Integer> {

}
