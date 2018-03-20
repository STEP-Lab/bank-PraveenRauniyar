import com.thoughtworks.step.bank.Account;
import com.thoughtworks.step.bank.AccountNumberException;
import com.thoughtworks.step.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private Account account;

    @Before
    public void setup() throws MinimumBalanceException, AccountNumberException {
        account = new Account("1234-3456",1500);
    }

    @Test
    public void checkAccountNumber(){
        assertThat(account.getAccountNumber(),is("1234-3456"));
    }

    @Test(expected = AccountNumberException.class)
    public void accountNumberException() throws MinimumBalanceException, AccountNumberException {
        Account account = new Account("123-5678", 300);
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(),is(1500.0));
    }

    @Test
    public void debitAmount() throws MinimumBalanceException {
        assertThat( account.debitAmount(200),is(1300.0));
    }

    @Test(expected = MinimumBalanceException.class)
    public void minimumBalanceExceptionWithDebit() throws MinimumBalanceException {
        account.debitAmount(1100);
    }

    @Test
    public void creditAmount() {
        assertThat(account.creditAmount(200),is(1700.0));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, AccountNumberException {
        Account account = new Account("1234-5678", 300);
    }
}

