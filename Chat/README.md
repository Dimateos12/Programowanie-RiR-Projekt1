# Opis programu 
Może być wielu klientów podłączonych do serwera i mogą oni rozmawiać ze sobą, tak jak w pokoju rozmów, gdzie każdy może zobaczyć wiadomości innych użytkowników.
Po połączeniu się z serwerem, użytkownik musi podać swoją nazwę, aby wejść na czat. Serwer wysyła do nowego użytkownika listę aktualnie dostępnych użytkowników.
Każdy użytkownik jest powiadamiany o pojawieniu się nowego użytkownika oraz o jego odejściu. Każda wiadomość jest poprzedzona nazwą użytkownika, aby śledzić, kto wysłał wiadomość.
Użytkownik pisze na czacie bye zeby rozłączyć sie z chatem 

# Budowa programu 
W folderze [`src`](src) znajdują się pliki programu 
1. [ChatClient](src/ChatClient.java) - odpowiada on za użytkownika 
2. [ChatServer](src/ChatServer.java) - server główny który odpowiada za organizacje wiadomości
3. [ReadThread](src/ReadThread.java) - wątkek który odpowiada za odczyt wiadomości 
4. [WriteThread](src/WriteThread.java) - wątek odpowiada z pisanie wiadomości po stronie użytkowników 

