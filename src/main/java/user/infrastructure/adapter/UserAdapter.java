package user.infrastructure.adapter;

import user.domain.model.User;
import user.domain.port.UserPort;
import user.infrastructure.repository.InMemoryUserRepository;
import user.infrastructure.mapper.UserMapper;

public class UserAdapter implements UserPort {

    private final InMemoryUserRepository inMemoryUserRepository;
    private final UserMapper userMapper;

    public UserAdapter(InMemoryUserRepository inMemoryUserRepository, UserMapper userMapper) {
        this.inMemoryUserRepository = inMemoryUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(User user) {

    }
}
