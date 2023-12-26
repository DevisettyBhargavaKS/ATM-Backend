package codewithbhargav.com.DataLoader;

import codewithbhargav.com.Model.Account;
import codewithbhargav.com.Model.TransactionalType;
import codewithbhargav.com.Repository.AccountRepository;
import codewithbhargav.com.Repository.TransactionalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class SetUpDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;
    @Autowired
    private TransactionalTypeRepository transactionalTypeRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }
        TransactionalType credit = createTypeIfNotFound(TransactionalType.CREDIT);
        TransactionalType debit = createTypeIfNotFound(TransactionalType.DEBIT);

        createUserIfNotFound(5000, "bhargav", 1234);
        createUserIfNotFound(10000, "venu", 4321);
        createUserIfNotFound(15000, "nani", 8688);

    }

    @Transactional
    private TransactionalType createTypeIfNotFound(String type) {
        TransactionalType transactionalType = transactionalTypeRepository.findByType(type);
        if (transactionalType == null) {
            transactionalType = new TransactionalType();
            transactionalType.setType(type);
            transactionalType = transactionalTypeRepository.save(transactionalType);
        }
        return transactionalType;
    }

    @Transactional
    private Account createUserIfNotFound(final int balance, final String name, final int pinnumber) {
        Optional<Account> account = accountRepository.findByname(name);
        Account user = null;
        if (account.isEmpty()) {

            user = new Account();
            user.setName(name);
            user.setBalance(balance);
            user.setPinNumber(pinnumber);
            user = accountRepository.save(user);
        }
        return user;
    }
}
