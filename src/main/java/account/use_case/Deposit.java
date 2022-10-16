package account.use_case;

import account.domain.model.Account;
import account.domain.port.AccountPort;
import transactions.domain.model.Transaction;
import transactions.domain.port.TransactionPort;

import java.io.IOException;

public class Deposit {
    private final AccountPort accountPort;
    private final TransactionPort transactionPort;

    public Deposit(AccountPort accountPort, TransactionPort transactionPort) {
        this.accountPort = accountPort;
        this.transactionPort = transactionPort;
    }

    public void execute(String userId, Transaction transaction) throws IOException {
        Account account = accountPort.getAccountByUserId(userId);
        account.deposit(transaction.amount());
        if (accountPort.saveAccount(account)) {
            Transaction successedTransaction = new Transaction(
                    transaction.id(),
                    transaction.accountId(),
                    transaction.operation(),
                    transaction.date(),
                    transaction.amount(),
                    account.getBalance());
            transactionPort.saveTransaction(successedTransaction);
        }
    }
}
