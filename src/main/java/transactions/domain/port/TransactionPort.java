package transactions.domain.port;

import transactions.domain.model.Transaction;

import java.io.IOException;
import java.util.List;

public interface TransactionPort {
    void saveTransaction(Transaction transaction) throws IOException;

    List<Transaction> getTransactions(String accountId);
}
