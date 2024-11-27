package org.ggplay149.user.application.interfaces;

import org.ggplay149.user.domain.User;

public interface UserRelationRepository {

    boolean isAlreadyFollow(User user, User targetUser);
    void save (User user);
    void delete (User user);

}
