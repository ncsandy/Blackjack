import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Main Game Loop
        Main main = new Main();
        main.startGame();
    }

    private void startGame() {
        Player player = createPlayer();
        int numberOfDecks = getNumberOfDecksFromPlayer();
        ArrayList<Card> tableDeck = createAndShuffleDeck(numberOfDecks);


    }

    private Player createPlayer() {
        System.out.println("Welcome to BlackJack, what is your name?");
        String playerName = getPlayerInput();
        return new Player(playerName);
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
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        return scanner.nextLine();
    }

}