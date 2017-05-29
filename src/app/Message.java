package app;

import java.io.Serializable;

/**
 * Created by leon2 on 25.05.2017.
 */
public class Message implements Serializable {
    private String username;
    private String message;

    private int ID;

    private static final long serialVersionUID = 1L;

    public Message(String username, String message, int id)
    {
        this.username = username;
        this.message = message;
        ID = id;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getMessage() {
        return message;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}