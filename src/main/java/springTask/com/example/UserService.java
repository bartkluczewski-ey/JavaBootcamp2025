package springTask.com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public UserService(UserDAO userDAO, PlatformTransactionManager transactionManager){
        this.userDAO = userDAO;
        this.transactionManager = transactionManager;
    }

    public void createUsersManually(boolean shouldFail){
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        System.out.println("Beginning of the manual transaction ");

        try{
            System.out.println("Saving user 'Adam'...");

            userDAO.save(new User("Adam"));
            System.out.println("User 'Adam' has been saved");

            if(shouldFail){
                System.out.println("Simulating an error, throwing exception");
                throw new RuntimeException("Something went wrong");
            }

            System.out.println("Saving user 'Beata'...");
            userDAO.save(new User("Beata"));
            System.out.println("User 'Beata' has been saved");

            transactionManager.commit(status);
            System.out.println("Transaction succeed");
        }catch (Exception e){
            transactionManager.rollback(status);
            System.err.println("Transaction rollbacked");
        }
    }




}
