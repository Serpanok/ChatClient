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

    @Override
    public int hashCode() {
        final int prime = 29;
        int result = 1;

        for (int i = 0; i < size; i++)
            result = prime + result + msgs[i].hashCode();

        result = prime * result + size;
        result = prime * result + packageLimit;
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
        MessagePackage other = (MessagePackage) obj;
        if (size != other.size)
            return false;
        if (packageLimit != other.packageLimit)
            return false;
        for (int i = 0; i < size; i++)
            if( !msgs[i].equals(other.msgs[i]) )
                return false;
        return true;
    }
}