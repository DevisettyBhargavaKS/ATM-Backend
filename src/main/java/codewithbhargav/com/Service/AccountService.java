package codewithbhargav.com.Service;

import codewithbhargav.com.Model.Account;
import codewithbhargav.com.Repository.AccountRepository;
import codewithbhargav.com.Request.LoginRequest;
import codewithbhargav.com.Response.LoginResponse;
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

    public LoginResponse login(LoginRequest loginRequest) {
  return null;
    }
}
