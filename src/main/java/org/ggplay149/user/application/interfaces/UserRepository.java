package org.ggplay149.user.application.interfaces;

import java.util.Optional;
import org.ggplay149.user.domain.User;

public interface UserRepository {

    User save (User user);
    Optional<User> findById (long id);

}
