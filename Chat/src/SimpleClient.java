import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String fromServer, fromUser;

        try{
            System.out.println("Próbuje sie polaczyc");
            socket = new Socket("192.168.0.136", 4444);
            System.out.println("Połączenie udane ");
            System.out.println("Czekam na wiadomosc z Servera..");
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Błąd operacji wejscia wyjscia");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        out.println("Jest na linii! Pisz Serwerze!!!");

        while((fromServer = in.readLine()) != null){
            System.out.println("Server: " + fromServer); // Wydruk  na konsoli z danych serwera

            if((fromServer.equals("exit") || fromServer.equals("quit"))){ // zakonczenie przez serwer
                System.out.println("Zostalem wyrzucony przez Server !");
                break;
            }
            System.out.print("Client: ");
            fromUser = stdIn.readLine();
            if(fromUser != null){
                out.println(fromUser);
            }
        }
        out.close();
        in.close();
        stdIn.close();
        socket.close();

    }
}
