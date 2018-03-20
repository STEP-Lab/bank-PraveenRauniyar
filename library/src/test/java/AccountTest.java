import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
    private com.thougtworks.step.bank.Account account;

    @Before
    public void setup() {
        account = new com.thougtworks.step.bank.Account("1234",500);
    }

    @Test
    public void checkAccountNumber(){
        assertThat(account.getAccountNumber(),is("1234"));
    }

    @Test
    public void checkBalance() {
        assertThat(account.getBalance(),is(500.0));
    }

    @Test
    public void debitAmount() {
        assertThat( account.debitAmount(200),is(300.0));
    }

    @Test
    public void creditAmount() {
        assertThat(account.creditAmount(200),is(700.0));
    }

}

