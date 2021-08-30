import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

    try {
        Socket socket = new Socket("localhost", 1978);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());



        while(true) {
            Scanner scanner = new Scanner(System.in);
            output.writeUTF(scanner.nextLine());
            output.flush();
            System.out.println(input.readUTF());
        }



    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
