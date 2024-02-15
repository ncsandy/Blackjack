import java.util.ArrayList;
import java.util.Random;

public class Table {
    static Random random = new Random();
    public void dealCards(ArrayList<Card> tableDeck, Player player, Dealer dealer) {
        int index = 0;

        for (int i = 0; i < tableDeck.size(); i++) {
            index = random.nextInt(tableDeck.size());

        }

    }
}
