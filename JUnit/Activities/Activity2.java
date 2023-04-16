package activities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Activity2 {

    @Test
    public void notEnoughFunds() {
        BankAccount bk = new BankAccount(10);
        Assertions.assertThrows(NotEnoughFundsException.class, ()-> {
            bk.withdraw(12);
        });
    }

    @Test
    public void enoughFunds() {
        BankAccount bk = new BankAccount(100);
        Assertions.assertDoesNotThrow(() -> bk.withdraw(100));

    }
}
