package br.com.mariojp.solid.lspaccounts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BankServiceTest {

    @Test
    public void testProcessWithdrawal() {
        BankService service = new BankService();
        
        CheckingAccount checking = new CheckingAccount();
        checking.deposit(100);
        service.processWithdrawal(checking, 50);
        assertEquals(50, checking.getBalance(), 0.001);
        
        SavingsAccount savings = new SavingsAccount();
        savings.deposit(100);

       
        if (savings instanceof Withdrawable withdrawable) {
            service.processWithdrawal(withdrawable, 30);
        } else {
            
            assertEquals(100, savings.getBalance(), 0.001);
        }
    }
}
