package app;

import java.io.Serializable;

/**
 * NetConcurrency created by лёня on 25.05.2017.
 */
public class Request implements Serializable {

    public int type;
    public int lastId;
    public Message sendMessage;
    public MessagePackage msgs;
    private static final long serialVersionUID = 1L;

    public Request(Message message){
        this.type = 1;
        this.sendMessage = message;
        this.msgs = null;
        this.lastId = -1;
    }

    public Request(int lastId){
        this.type = 0;
        this.msgs = null;
        this.lastId = lastId;
        this.sendMessage = null;
    }
}
