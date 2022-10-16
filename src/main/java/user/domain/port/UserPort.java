package user.domain.port;

import user.domain.model.User;

public interface UserPort {
    void saveUser(User user);
}

