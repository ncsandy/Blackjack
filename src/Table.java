import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Table {
    private final Random random = new Random();
    private final Formatter formatter = new Formatter();
    private final Scanner scanner;

    public Table(Scanner scanner) {
        this.scanner = scanner;
    }

    public void dealCards(ArrayList<Card> tableDeck, Player player, Dealer dealer) {

        if (tableDeck.isEmpty() || player == null || dealer == null) {
            throw new IllegalArgumentException("One of parameters is invalid");
        }

        for (int i = 0; i < 2; i++) {
            player.addCard(dealCard(tableDeck));
            dealer.addCard(dealCard(tableDeck));
        }

        dealer.firstDealerRead(formatter);
        player.readHand(formatter);

    }

    private Card dealCard(ArrayList<Card> deck) {
        int index = random.nextInt(deck.size());
        return deck.remove(index);
    }

    protected void playGame(int playerChoice, ArrayList<Card> deck, Player player, Dealer dealer) {
        if (playerChoice == 1) {
            player.addCard(dealCard(deck));
            player.readHand(formatter);
            System.out.println(player.getName() + " has a score of: " + player.getScore());
            if (player.getScore() > 21) {
                System.out.println("Bust....");
            }
        } else if (playerChoice == 2) {
            dealer.addCard(dealCard(deck));
            dealer.readHand(formatter);
            if (dealer.getScore() > 21) {
                System.out.println("Dealer busts..." + dealer.getScore());
            }
        }
    }

    protected int validateInput() {
        int selection = 0;
        do {
            try {
                selection = Integer.parseInt(scanner.nextLine());
                switch (selection) {
                    case 1:
                        System.out.println("You chose hit");
                        break;
                    case 2:
                        System.out.println("You chose stay");
                        break;
                    default:
                        System.out.println("Let's try that again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Try your input again!");
            }

        } while (selection != 1 && selection != 2);
        return selection;
    }
}
