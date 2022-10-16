package account.domain.port;

import account.domain.model.Account;

import java.io.IOException;

public interface AccountPort {
    Account getAccountByUserId(String userId);

    boolean saveAccount(Account account) throws IOException;
}
