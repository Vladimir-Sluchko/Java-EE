package messenger.service;

import messenger.core.dto.User;
import messenger.service.api.IUserService;
import messenger.storage.UserStorage;
import messenger.storage.api.IUserStorage;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class UserService implements IUserService {
    private final IUserStorage userStorage;
    public UserService() {
        this.userStorage = UserStorage.getInstance();
    }

    @Override
    public User createUser(String login, String password, String fullName, String dateOfBirth){
        LocalDate parseDate = LocalDate.parse(dateOfBirth);
        User user = new User(login,password,fullName,parseDate);
        userStorage.add(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userStorage.getAll();
    }

    @Override
    public User getByLogin(String login) {
        return userStorage.get(login);
    }

    @Override
    public boolean checkPassword(String login, String password) {
        User user = userStorage.get(login);
        if (isExist(login)){
            String passwordUser = user.getPassword();
            return Objects.equals(passwordUser,password);
        }else {
            return false;
        }
    }

    @Override
    public boolean isExist(String login) {
        return userStorage.get(login) != null;
    }

    @Override
    public int getCount() {
        return userStorage.getCount();
    }
}
