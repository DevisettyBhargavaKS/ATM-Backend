package codewithbhargav.com.Repository;

import codewithbhargav.com.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("FROM Transaction t Where  t.userId.id=?1 ")
    List<Transaction> findTransactionByUserId(int userId);


}
