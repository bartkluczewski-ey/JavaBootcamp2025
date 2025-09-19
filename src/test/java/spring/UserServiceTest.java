package spring;

import org.hibernate.annotations.ManyToAny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @Mock
    private PlatformTransactionManager transactionManager;

    @InjectMocks
    private UserService userService;

    @Mock
    private TransactionStatus transactionStatus;

    @BeforeEach
    void setUp(){
        when(transactionManager.getTransaction(any(DefaultTransactionDefinition.class))).thenReturn(transactionStatus);
    }

    @Test
    void createUsersManually_shouldSucceedAndCommitTransaction_whenShouldFailIsFalse(){

        userService.createUsersManually(false);

        verify(userDAO, times(2)).save(any(User.class));

        verify(transactionManager).commit(transactionStatus);

        verify(transactionManager, never()).rollback(transactionStatus);

    }
    
    @Test
    void createUsersManually_shouldRollbackTransaction_whenShouldFailIsTrue(){
        userService.createUsersManually(true);

        verify(userDAO, times(1)).save(any(User.class));

        verify(transactionManager).rollback(transactionStatus);

        verify(transactionManager, never()).commit(transactionStatus);

    }

}
