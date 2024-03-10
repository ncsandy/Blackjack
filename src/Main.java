import java.util.Scanner;

public class Main {
    private final Scanner scanner;
    private final Messages messages;
    public Main() {
        this.scanner = new Scanner(System.in); // Create a single Scanner object
        this.messages = new Messages(); // Create message object since it will be used quite a bit
    }
    public static void main(String[] args){
        // Main Game Loop
        Main main = new Main();
        main.startGame();
    }
    private void startGame(){
        messages.getWelcomeMessage();

        // Create player object
        Player player = createPlayer();

        //Create Dealer object
        Dealer dealer = new Dealer();

        // Get number of decks from player
        int numberOfDecks = getNumberOfDecksFromPlayer();

        Table table = new Table(scanner, player, dealer, numberOfDecks);

        // Get Player input for hit/stay
        while (true) {
            table.playGame();
        }
    }
    private Player createPlayer() {
        System.out.println("What is your name?");
        String playerName = getPlayerInput();
        return new Player(playerName.isEmpty() ? "Player 1" : playerName);
    }
    private int getNumberOfDecksFromPlayer() {
        Formatter formatter = new Formatter();
        System.out.println("How many decks would you like to play with?");
        return formatter.convertToInt(getPlayerInput());
    }
    private String getPlayerInput() {
        return scanner.nextLine();
    }
}