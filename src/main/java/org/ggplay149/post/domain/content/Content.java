package org.ggplay149.post.domain.content;

import org.ggplay149.post.domain.common.DatetimeInfo;

public abstract class Content {

    String contentText;
    final DatetimeInfo datetimeInfo;

    public Content(String contentText) {

        checkContentText(contentText);
        this.contentText = contentText;
        this.datetimeInfo = new DatetimeInfo();

    }

    public void updateContent(String updateContent){

        checkContentText(updateContent);
        this.contentText = updateContent;
        this.datetimeInfo.updateEditDatetime();

    }

    public abstract void checkContentText(String contentText);

    public String getContentText() {
        return contentText;
    }

}
