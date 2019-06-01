package com.example.myapplication;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by myeongsic on 2017. 9. 25..
 */

public class ChatModel {
    private String userName;
    private String message;

    public ChatModel() { }

    public ChatModel(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
