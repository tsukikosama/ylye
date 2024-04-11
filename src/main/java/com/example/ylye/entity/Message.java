package com.example.ylye.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;

/**
 * WebSocket 聊天消息类
 */
@Data
public class Message {

    public static final String ENTER = "ENTER";
    public static final String SPEAK = "SPEAK";
    public static final String QUIT = "QUIT";

    private String type;  // 消息类型

    private String fromUser; // 发送人

    private String toUser;  // 接收人

    private String msg;  // 发送消息

    private int onlineCount;  // 在线用户数

    private List<String> list;

    /*
     * 聊天消息
     * 没有设置接收人 toUser ，视为群聊
     * 设置了接收人 toUser，视为私聊
     * */
    public static String jsonStr(String type, String fromUser, String toUser, String msg, int onlineCount) {
        return JSON.toJSONString(new Message(type, fromUser, toUser, msg, onlineCount));
    }
    //给指定对象发送消息
    public Message(String type, String fromUser, String toUser, String msg, int onlineCount) {
        this.type = type;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.msg = msg;
        this.onlineCount = onlineCount;
    }
    //把jsonzi字符串转成 string
    public static String jsonStr(String type, String fromUser, String toUser, String msg, int onlineCount, List<String> list) {
        return JSON.toJSONString(new Message(type, fromUser, toUser, msg, onlineCount, list));
    }
    //给全部的对象广播消息
    public Message(String type, String fromUser, String toUser, String msg, int onlineCount, List<String> list) {
        this.type = type;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.msg = msg;
        this.onlineCount = onlineCount;
        this.list = list;
    }


}


