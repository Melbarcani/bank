package account.infrastructure.adapter;

import account.domain.model.Account;
import account.domain.port.AccountPort;
import account.infrastructure.mapper.AccountMapper;
import account.infrastructure.model.AccountEntity;
import account.infrastructure.repository.InMemoryAccountRepository;

import java.io.IOException;

public class AccountAdapter implements AccountPort {

    private final InMemoryAccountRepository inMemoryAccountRepository;
    private final AccountMapper accountMapper;

    public AccountAdapter(InMemoryAccountRepository inMemoryAccountRepository, AccountMapper accountMapper) {
        this.inMemoryAccountRepository = inMemoryAccountRepository;
        this.accountMapper = accountMapper;
    }


    @Override
    public Account getAccountByUserId(String userId) {
        AccountEntity accountEntity = inMemoryAccountRepository.readAccountByUserId(userId);
        return accountMapper.mapToDomain(accountEntity);
    }

    @Override
    public boolean saveAccount(Account account) throws IOException {
        var accountMapper = new AccountMapper();
        var accountEntity = accountMapper.mapToEntity(account);
        return inMemoryAccountRepository.writeInFile(accountEntity.getAccountData());
    }
}
