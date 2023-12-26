package codewithbhargav.com.Controller;

import codewithbhargav.com.Request.TransactionRequest;
import codewithbhargav.com.Service.TransactionService;
import codewithbhargav.com.Response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PutMapping("/credit")
    private ResponseEntity<List<TransactionResponse>> credit(@RequestBody TransactionRequest transactionRequest) {
        List<TransactionResponse> transaction = transactionService.updateCredit(transactionRequest);
        return new ResponseEntity<>(transaction, HttpStatus.OK);

    }

    @PutMapping("/debit")
    private ResponseEntity<List<TransactionResponse>> debit(@RequestBody TransactionRequest transactionRequest) {
        List<TransactionResponse> transaction = transactionService.updateDebit(transactionRequest);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }
}
