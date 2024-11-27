package org.ggplay149.post.domain.comment;

import org.ggplay149.common.domain.PositiveIntegerCounter;
import org.ggplay149.post.domain.Post;
import org.ggplay149.post.domain.content.Content;
import org.ggplay149.user.domain.User;

public class Comment {

    private final long id;
    private final Post post;
    private final User author;
    private final Content content;
    private final PositiveIntegerCounter likeCount;


    public Comment(long id, Post post, User author, Content content) {

        if(
            author == null
            || post == null
            || content == null
        ){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.post = post;
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
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

    public void updateComment(User user, String updatedContent){

        if(!this.author.equals(user)){
            throw new IllegalArgumentException();
        }

        this.content.updateContent(updatedContent);

    }
}
