package org.ggplay149.user.domain;

import java.util.Objects;
import org.ggplay149.common.domain.PositiveIntegerCounter;

public class User {

    private final Long id;
    private final UserInfo userInfo;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo userInfo) {

        if(userInfo == null){
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.userInfo = userInfo;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCount = new PositiveIntegerCounter();

    }

    public void follow (User targetUser){

        if(targetUser.equals(this)){
            throw new IllegalArgumentException();
        }

        followingCount.increase();
        targetUser.increaseFollowerCounter();

    }

    public void unfollow (User targetUser){

        if(targetUser.equals(this)){
            throw new IllegalArgumentException();
        }

        followerCount.decrease();
        targetUser.decreaseFollowerCounter();

    }

    public void increaseFollowerCounter(){
        followerCount.increase();
    }

    public void decreaseFollowerCounter(){
        followerCount.decrease();
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
