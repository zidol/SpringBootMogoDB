package me.zidol.springbootmongo;

import me.zidol.springbootmongo.account.Account;
import me.zidol.springbootmongo.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class SpringbootmongoApplication {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmongoApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            Account account = new Account();
            account.setEmail("zidol@email.com");
            account.setUsername("zidol");
            accountRepository.insert(account);
//            mongoTemplate.insert(account);

            System.out.println("finished");


        };
    }

}
