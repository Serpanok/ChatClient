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

    @Override
    public int hashCode() {
        final int prime = 29;
        int result = 1;
        result = prime * result + username.hashCode();
        result = prime * result + message.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        if (!username.equals(other.username))
            return false;
        if (!message.equals(other.message))
            return false;
        return true;
    }
}