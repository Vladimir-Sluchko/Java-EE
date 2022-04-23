package messenger.storage;

import messenger.core.dto.Role;
import messenger.core.dto.User;
import messenger.storage.api.IUserStorage;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStorage implements IUserStorage {
    private final Map<String, User> userMap;

    private static final IUserStorage instance = new UserStorage();

    private UserStorage() {
        this.userMap = new HashMap<>();
        addAdmin();


    }
    private void addAdmin(){
        User user = new User("admin","admin","admin", LocalDate.now());
        user.setRole(Role.ADMINISTRATOR);
        userMap.put("admin",user);
    }

    public static IUserStorage getInstance(){
        return instance;
    }

    @Override
    public void add(User user) {
        String login = user.getLogin();
        userMap.put(login, user);
    }

    @Override
    public List<User> getAll() {
        return List.copyOf(userMap.values());
    }

    @Override
    public User get(String login) {
        return userMap.get(login);
    }

    @Override
    public int getCount() {
        return getAll().size();
    }
}


