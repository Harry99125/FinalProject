package model;

import org.bson.types.ObjectId;

import java.util.Date;

public class Chat {
    private ObjectId id;
    private String chatRoomId;
    private String username;
    private String message;
    private Date timestamp;

    public Chat(ObjectId id, String chatRoomId, String username, String message, Date timestamp) {
        this.id = id;
        this.chatRoomId = chatRoomId;
        this.username = username;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
}
