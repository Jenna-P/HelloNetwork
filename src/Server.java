import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;


        try {
            serverSocket = new ServerSocket(1978);

        } catch (IOException e) {
            e.printStackTrace();
        }

//            System.out.println("Accepting connection on port 1978");
//            Socket socket = serverSocket.accept();
//            System.out.println("Connection established" + socket.getRemoteSocketAddress());

//            DataInputStream input = new DataInputStream(socket.getInputStream());
//            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        //Network Echo Server - Her kan man modtage og sende data
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            new HandleAClient(socket).start();

//                String inputText = input.readUTF();
//                System.out.println("Texten modtaget: " + inputText);
//                output.writeUTF("Accepted " + inputText);
//                output.flush();
        }
    }
}



    class HandleAClient extends Thread {
        private Socket socket;

        public HandleAClient(Socket socket){
            this.socket = socket;
        }

        public void run() {
            try {

                System.out.println("Accepting connection on port 1978");
                //Socket socket = serverSocket.accept();
                System.out.println("Connection established" + socket.getRemoteSocketAddress());

                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    String inputText = inputFromClient.readUTF();
                System.out.println("Texten modtaget: " + inputText);
                outputToClient.writeUTF("Accepted " + inputText);
                outputToClient.flush();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


