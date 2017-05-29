package app;

import java.io.*;
import java.net.Socket;

/**
 * Created by 14Viskubova on 10.02.2017.
 */
public class Client {
    private static String userName;

    public static void main(String[] args) throws IOException {
        String host = args[0];
        int port = Integer.parseInt(args[1]);


        try {
            if (port < 0)
                throw new IllegalArgumentException(args[1]);
            Socket socket = new Socket(host, port);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outMsg = "";
            String inMsg;

            System.out.print("Enter your name: ");
            try {
                userName = bufferedReader.readLine();
                System.out.println("Welcome, " + userName + ".");
            } catch (IOException e2) {
                System.err.println("Error I/O");
            }



            //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeObject(new Request(new Message(userName,userName + " connected", 0)));
            //out.println(userName);

            Thread thread = new Thread(new ReadMessage(objectOutputStream, objectInputStream)); //поток чтения входящих сообщений
            thread.start();

            while (true){
                outMsg = bufferedReader.readLine();
                objectOutputStream.writeObject(new Request(new Message(userName, outMsg,0)));
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
