import java.util.ArrayList;
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

        // Create Table object

        Table table = new Table(scanner);

        // Get number of decks from player
        int numberOfDecks = getNumberOfDecksFromPlayer();

        // Create and shuffle deck
        ArrayList<Card> tableDeck = createAndShuffleDeck(numberOfDecks);

        // Deal cards, and calculate scores
        dealCardsOnTable(tableDeck,player,dealer, table);

        // Display Message
        messages.getPlayerAction();

        // Get Player input for hit/stay
       table.playGame(table.validateInput(), tableDeck, player, dealer);

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
    private ArrayList<Card> createAndShuffleDeck(int numberOfDecks) {
        DeckCreator deckCreator = new DeckCreator(numberOfDecks);
        return deckCreator.getDeck();
    }

    private String getPlayerInput() {
        return scanner.nextLine();
    }
    private void dealCardsOnTable(ArrayList<Card> cards, Player player, Dealer dealer, Table table) {
        table.dealCards(cards, player, dealer);
    }

}