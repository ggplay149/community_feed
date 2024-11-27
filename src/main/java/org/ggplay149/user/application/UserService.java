package org.ggplay149.user.application;

import org.ggplay149.user.application.dto.CreateUserRequestDto;
import org.ggplay149.user.application.interfaces.UserRepository;
import org.ggplay149.user.domain.User;
import org.ggplay149.user.domain.UserInfo;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequestDto dto){
        UserInfo info = new UserInfo(dto.name(), dto.profileImgUrl());
        User user = new User(null,info);
        return userRepository.save(user);
    }

    public User getUser(long id){
        return userRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }


}
