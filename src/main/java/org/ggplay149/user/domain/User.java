package org.ggplay149.user.domain;

import java.util.Objects;
import org.ggplay149.common.domain.PositiveIntegerCounter;

public class User {

    private final long id;
    private final UserInfo userInfo;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(long id, UserInfo userInfo, PositiveIntegerCounter followingCount,
        PositiveIntegerCounter followerCount) {
        this.id = id;
        this.userInfo = userInfo;
        this.followingCount = followingCount;
        this.followerCount = followerCount;
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
