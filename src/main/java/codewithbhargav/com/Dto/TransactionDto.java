package codewithbhargav.com.Dto;

import codewithbhargav.com.Repository.AccountRepository;
import codewithbhargav.com.Model.Transaction;
import codewithbhargav.com.Repository.TransactionalTypeRepository;
import codewithbhargav.com.Response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionDto {

    @Autowired
    private TransactionalTypeRepository transactionalTypeRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Transaction mapToCredit(Transaction transactionRow) {
        Transaction transaction = new Transaction();
        transaction.setCurrentBalance(transactionRow.getCurrentBalance());
        transaction.setAmount(transactionRow.getAmount());
        transaction.setType(transactionRow.getType());
        transaction.setUserId(transactionRow.getUserId());

        return transaction;
    }

    public List<TransactionResponse> mapToResponse(List<Transaction> transaction) {
        List<TransactionResponse> transactionResponseList = new ArrayList<>();

        for (Transaction transaction1 : transaction) {
            TransactionResponse t = new TransactionResponse();
            t.setUserId(transaction1.getUserId().getId());
            t.setAmount(transaction1.getAmount());
            t.setCurrentBalance(transaction1.getCurrentBalance());

            t.setTransactionalType(transaction1.getType());
            transactionResponseList.add(t);
        }


        return transactionResponseList;
    }


}
