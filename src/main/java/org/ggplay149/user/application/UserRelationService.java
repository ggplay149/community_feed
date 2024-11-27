package org.ggplay149.user.application;

import org.ggplay149.user.application.dto.FollowUserRequestDto;
import org.ggplay149.user.application.interfaces.UserRelationRepository;
import org.ggplay149.user.application.interfaces.UserRepository;
import org.ggplay149.user.domain.User;

public class UserRelationService {

    private final UserService userService;
    private final UserRelationRepository userRelationRepository;


    public UserRelationService(UserService userService, UserRelationRepository userRepository) {
        this.userService = userService;
        this.userRelationRepository = userRepository;
    }

    public void follow(FollowUserRequestDto dto){

        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if(userRelationRepository.isAlreadyFollow(user,targetUser)){
            throw new IllegalArgumentException();
        }

        user.follow(targetUser);
        userRelationRepository.save(user);

    }

    public void unfollow(FollowUserRequestDto dto){

        User user = userService.getUser(dto.userId());
        User targetUser = userService.getUser(dto.targetUserId());

        if(!userRelationRepository.isAlreadyFollow(user,targetUser)){
            throw new IllegalArgumentException();
        }

        user.unfollow(targetUser);
        userRelationRepository.delete(targetUser);

    }
}
