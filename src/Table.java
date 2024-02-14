import java.util.ArrayList;
import java.util.Random;

public class Table {

    static Random random = new Random();
    public void dealCards(ArrayList<Card> tableDeck, ArrayList<Card> dealer, ArrayList<Card> player) {

        for (int i = 0; i < tableDeck.size(); i++) {
            int index = random.nextInt(tableDeck.size());

            System.out.println(tableDeck.get(index));
        }
    }
}
