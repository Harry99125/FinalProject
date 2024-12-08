package model;

import java.util.List;

import org.bson.types.ObjectId;

public class ChatRoom {

    private ObjectId id;
    private String name;
    //    list of user ids
    private List<String> users;
    private List<String> chatHistory;
    private byte[] image;

    public ChatRoom(ObjectId id, String name, List<String> users, List<String> chatHistory, byte[] image) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.chatHistory = chatHistory;
        this.image = image;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public List<String> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(List<String> chatHistory) {
        this.chatHistory = chatHistory;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
