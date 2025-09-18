package cleanCode;

import java.util.Optional;

public interface UserRepository {
    void save(User var1);

    Optional<User> findById(String var1);
}
