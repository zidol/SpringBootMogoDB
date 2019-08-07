package me.zidol.springbootmongo;

import me.zidol.springbootmongo.account.Account;
import me.zidol.springbootmongo.account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByEmail(){
        Account account = new Account();
        account.setUsername("jihyeok");
        account.setEmail("jihyeok@naver.com");

        accountRepository.save(account);

        Optional<Account> byId =  accountRepository.findById(account.getId());
        assertThat(byId).isNotEmpty();
        Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
        assertThat(byEmail).isNotEmpty();
        assertThat(byEmail.get().getUsername()).isEqualTo("jihyeok");
    }
}
