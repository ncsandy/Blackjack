import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Table {
    private final Random random = new Random();
    private final Formatter formatter = new Formatter();
    private final Scanner scanner;
    private final ArrayList<Card> tableDeck;
    private final Player player;
    private final Dealer dealer;

    public Table(Scanner scanner, ArrayList<Card> tableDeck, Player player, Dealer dealer) {
        this.scanner = scanner;
        this.tableDeck = tableDeck;
        this.player = player;
        this.dealer = dealer;
    }

    public void playGame() {
        dealCards();
        while (true) {
            if (player.getScore() == 21) {
                System.out.printf("Blackjack !");
                break;
            }
            int selection = getPlayerInput();
            if (selection == 1) {
                playerHit();
                if (player.getScore() > 21) {
                    System.out.println("Bust..");
                    break;
                }
            } else if (selection == 2) {
                dealerStay();
                break;
            }
        }
        evaluateGame();
        resetHands();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void dealCards() {
        if (tableDeck.isEmpty() || player == null || dealer == null) {
            throw new IllegalArgumentException("One of the parameters is invalid");
        }

        for (int i = 0; i < 2; i++) {
            player.addCard(dealCard(tableDeck));
            dealer.addCard(dealCard(tableDeck));
        }

        dealer.firstDealerRead(formatter);
        player.readHand(formatter);

        System.out.println("1.) Hit or 2.) Stay?");
    }

    private int getPlayerInput() {
        int selection = 0;
        while (true) {
            try {
                System.out.println("Enter your choice (1 - Hit, 2 - Stay):");
                selection = Integer.parseInt(scanner.nextLine());
                if (selection != 1 && selection != 2) {
                    System.out.println("Invalid input! Please enter 1 or 2.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        return selection;
    }

    private Card dealCard(ArrayList<Card> deck) {
        int index = random.nextInt(deck.size());
        return deck.remove(index);
    }

    private void playerHit() {
        player.getHand().add(dealCard(tableDeck));
        player.readHand(formatter);
        System.out.println("Your score is now " + player.getScore());
    }

    private void dealerStay() {
        while (dealer.getScore() < 17) {
            dealer.getHand().add(dealCard(tableDeck));
            dealer.readHand(formatter);
        }
    }

    private void evaluateGame() {
        int playerScore = player.getScore();
        int dealerScore = dealer.getScore();

        if (playerScore == dealerScore) {
            System.out.println("Push!");
        } else if (playerScore > dealerScore && playerScore <= 21 || dealerScore > 21) {
            System.out.println("Player wins! With a score of " + playerScore);
        } else {
            System.out.println("Dealer wins! With a score of " + dealerScore);
        }
    }

    private void resetHands() {
        player.clearHand();
        dealer.clearHand();
    }
}