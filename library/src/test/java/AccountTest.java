import com.thoughtworks.step.bank.Account;
import com.thoughtworks.step.bank.AccountNumberException;
import com.thoughtworks.step.bank.InsufficientBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account account;

    @Before
    public void setup() throws InsufficientBalanceException, AccountNumberException {
        account = new Account("1234-3456",1500);
    }

    @Test
    public void checkAccountNumber(){
        assertThat(account.getAccountNumber(),is("1234-3456"));
    }

    @Test(expected = AccountNumberException.class)
    public void accountNumberException() throws InsufficientBalanceException, AccountNumberException {
        Account account = new Account("123-5678", 300);
    }

    @Test(expected = AccountNumberException.class)
    public void accountNumberExceptionWithCharacter() throws InsufficientBalanceException, AccountNumberException {
        Account account = new Account("1abh-5678", 300);
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(),is(1500.0));
    }

    @Test
    public void debitAmount() throws InsufficientBalanceException {
        assertThat( account.debitAmount(200),is(1300.0));
    }

    @Test(expected = InsufficientBalanceException.class)
    public void minimumBalanceExceptionWithDebit() throws InsufficientBalanceException {
        assertThat( account.getBalance(),is(1500.0));
        account.debitAmount(1200);
    }

    @Test
    public void creditAmount() {
        assertThat(account.creditAmount(200),is(1700.0));
    }

    @Test(expected = InsufficientBalanceException.class)
    public void checkMinimumBalance() throws InsufficientBalanceException, AccountNumberException {
        Account account = new Account("1234-5678", 100);
    }
}

