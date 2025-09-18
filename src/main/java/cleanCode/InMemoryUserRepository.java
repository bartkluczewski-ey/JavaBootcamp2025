package cleanCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> database = new HashMap();

    public void save(User user) {
        System.out.println("Saving data in DB: " + user.toString());
        this.database.put(user.getId(), user);
    }

    public Optional<User> findById(String id) {
        return Optional.ofNullable((User)this.database.get(id));
    }
}
