package codewithbhargav.com.Service;

import codewithbhargav.com.Model.Account;
import codewithbhargav.com.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRespository;

    public Account findById(int id) {
        Account account = accountRespository.findById(id).get();
        return account;


    }
}
