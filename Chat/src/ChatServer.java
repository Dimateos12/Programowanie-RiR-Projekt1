import java.io.*;
import java.net.*;
import java.util.*;


public class ChatServer {
    private int port ;
    private Set<String> userNames = new HashSet<>();
    private Set<UserThread> userThreads = new HashSet<>();

    public ChatServer(int port) {
        this.port = port;
    }

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Chat Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");

                UserThread newUser = new UserThread(socket, this);
                userThreads.add(newUser);
                newUser.start();

            }

        } catch (IOException ex) {
            System.out.println("Error in the server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }



    /**
     * Dostarczanie wiadomości od użytkownika do użytkownika (broadcasting)
     */
    void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreads) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    /**
     * Gromadzenie danych użytkownika z nowo połączonego klienta
     */
    void addUserName(String userName) {
        userNames.add(userName);
    }

    /**
     * Gdy klient jest rozłączony, usuwamy związek użytkownika i Użytkownika Wątku
     */
    void removeUser(String userName, UserThread aUser) {
        boolean removed = userNames.remove(userName);
        if (removed) {
            userThreads.remove(aUser);
            System.out.println("The user " + userName + " quitted");
        }
    }

    Set<String> getUserNames() {
        return this.userNames;
    }

    /**
    Zwracamy prawde jeśli jakiś użytkownik jest połączony
    **/
    boolean hasUsers() {
        return !this.userNames.isEmpty();
    }

    public static void main(String[] args) {

        //Sprawdzamy czy zostaly podane parametry z wiersza polecen
        if (args.length < 1) {
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }

        //Konwertujemy nasz numer portu do integera
        int port = Integer.parseInt(args[0]);

        //tworzymy server chatu
        ChatServer server = new ChatServer(port);
        server.execute();
    }
}