package app;

import java.io.Serializable;

/**
 * Created by leon2 on 25.05.2017.
 */
public class MessagePackage implements Serializable {
    private Message msgs[];
    private int size;
    private int packageLimit;

    private static final long serialVersionUID = 1L;

    public MessagePackage( int packageLimit )
    {
        this.size = 0;
        this.packageLimit = packageLimit;

        msgs = new Message[packageLimit];
    }

    public boolean insert( Message msg )
    {
        if( size < packageLimit)
        {
            msgs[ size++ ] = msg;
            return true;
        }
        return false;
    }

    public int getSize()
    {
        return this.size;
    }

    public Message getMessage( int index )
    {
        return msgs[index];
    }
}