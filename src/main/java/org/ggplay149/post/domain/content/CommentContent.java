package org.ggplay149.post.domain.content;

public class CommentContent extends Content {

    private static final int MAX_POST_LENGTH = 100;

    public CommentContent(String contentText) {
        super(contentText);
    }

    @Override
    public void checkContentText(String contentText) {

        if(contentText == null || contentText.isEmpty()){
            throw new IllegalArgumentException();
        }

        if(contentText.length() > MAX_POST_LENGTH){
            throw new IllegalArgumentException();
        }

    }
}
