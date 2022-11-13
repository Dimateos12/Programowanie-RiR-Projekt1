import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        String fromClient="";
        String fromServer="";
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(4444);

        } catch (IOException e) {
           System.err.println("Nie moge polaczyc sie z serverem");
           System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            Socket clientSocket = null;
            System.out.println("Jestem serwerem: ");
            System.out.println("'exit'- wyrzucenie klienta i poowne oczekiwanie");
            System.out.println("'quit' - zakonczenie pracy");
            System.out.println("Oczekiwanie na polaczenie");
            try{
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Nie moge akceptować");
            }
            assert clientSocket != null;
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true); //Tutaj moze byc blad

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while((fromClient = in.readLine()) != null)
            {
                System.out.println("Klient: " + fromClient);

                System.out.print("Server: ");
                fromServer = stdIn.readLine();
                if(fromServer != null){ out.println(fromServer);}

            }
            out.close();
            in.close();
            clientSocket.close();
            stdIn.close();
            serverSocket.close();
        }
    }
}