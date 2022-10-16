package account.infrastructure.mapper;

import account.domain.model.Account;
import account.infrastructure.model.AccountEntity;

import static account.infrastructure.model.FileConstants.RETURN;
import static account.infrastructure.model.FileConstants.SEPARATOR;

public class AccountMapper {

    public AccountEntity mapToEntity(Account account) {
        StringBuilder accountData = new StringBuilder();
        accountData.append(account.getAccountId()).append(SEPARATOR)
                .append(account.getUserId()).append(SEPARATOR)
                .append(account.getBalance()).append(RETURN);
        return new AccountEntity(accountData.toString());

    }

    public Account mapToDomain(AccountEntity accountEntity) {
        String[] lineSplitted = accountEntity.getAccountData().split(SEPARATOR);
        return Account.AccountBuilder.builder()
                .accountId(lineSplitted[0])
                .userId(lineSplitted[1])
                .balance(Double.parseDouble(lineSplitted[2].trim())).build();
    }
}
