package org.ggplay149.post.domain;

import org.ggplay149.common.domain.PositiveIntegerCounter;
import org.ggplay149.post.domain.content.PostContent;
import org.ggplay149.post.domain.content.PostPublicationState;
import org.ggplay149.user.domain.User;

public class Post {

    private final long id;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;
    private PostPublicationState state;


    public Post(long id, User author, PostContent content) {

        if(author == null){
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
        this.state = PostPublicationState.PUBLIC;

    }

    public void like(User user){
        if(this.author.equals(user)){
            throw new IllegalArgumentException();
        }
        likeCount.increase();
    }

    public void unlike(){
        this.likeCount.decrease();
    }

    public void updatePost(User user, String updatedContent, PostPublicationState state){

        if(!this.author.equals(user)){
            throw new IllegalArgumentException();
        }

        this.state = state;
        this.content.updateContent(updatedContent);

    }
}
