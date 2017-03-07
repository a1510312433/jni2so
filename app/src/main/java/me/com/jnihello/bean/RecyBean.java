package me.com.jnihello.bean;

import java.io.Serializable;

/**
 * Created by caobin on 2017/3/7.
 */

public class RecyBean implements Serializable{
   String content;

    public RecyBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RecyBean{" +
                "content='" + content + '\'' +
                '}';
    }
}
