package messenger.service.api;

import messenger.core.dto.User;

import java.util.List;

public interface IUserService {
    User createUser(String login,String password, String fullName, String dateOfBirth);

    List<User> getAll();

    User getByLogin(String login);

    boolean checkPassword(String login, String password);

    boolean isExist(String login);

    int getCount();



}
