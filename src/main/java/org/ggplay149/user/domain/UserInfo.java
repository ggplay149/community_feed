package org.ggplay149.user.domain;

public class UserInfo {

    private final String name;
    private final String profileImgUrl;

    public UserInfo(String name, String profileImgUrl) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.profileImgUrl = profileImgUrl;
    }
}
