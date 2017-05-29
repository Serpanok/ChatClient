package app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * NetConcurrency created by лёня on 25.05.2017.
 */
class ReadMessage implements Runnable{

    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    private static int lastId;

    public ReadMessage(ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream) {
        this.objectOutputStream = objectOutputStream;
        this.objectInputStream = objectInputStream;
        lastId=0;
    }

    @Override
    public void run() {
        try {
            while(true){

                objectOutputStream.writeObject(new Request(lastId));

                Request answer = (Request) objectInputStream.readObject();
                MessagePackage messagePackage = answer.msgs;

                boolean isGet = false;
                for (int i = 0; i < messagePackage.getSize(); i++)
                {
                    Message message = messagePackage.getMessage(i);
                    System.out.println( message.getUsername() + ": " + message.getMessage() );
                    lastId = message.getID();
                    isGet = true;
                }

                if (!isGet)
                {
                    Thread.sleep(1000);
                }
            }
        } catch (IOException e) {
            System.err.println("Error I/O");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}