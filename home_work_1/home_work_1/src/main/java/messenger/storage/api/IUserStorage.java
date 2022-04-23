package messenger.storage.api;

import messenger.core.dto.User;

import java.util.List;

public interface IUserStorage {
    void add(User user);

    List<User> getAll();

    User get(String login);

    int getCount();
}
